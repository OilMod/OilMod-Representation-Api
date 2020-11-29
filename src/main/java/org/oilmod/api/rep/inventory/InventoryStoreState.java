package org.oilmod.api.rep.inventory;

import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import org.oilmod.api.rep.itemstack.ItemStackFactory;
import org.oilmod.api.rep.itemstack.ItemStackRep;
import org.oilmod.api.rep.itemstack.state.ItemStackStateRep;

public class InventoryStoreState {
    private final InventoryRep inv;
    private final ItemStackStateRep[] overriddenStates;
    private final int[] overriddenAmount;

    public InventoryStoreState(InventoryRep inv) {
        this.inv = inv;
        overriddenAmount = new int[inv.getSize()];
        overriddenStates = new ItemStackStateRep[inv.getSize()];
    }

    private ItemStackStateRep getState(int index) {
        ItemStackStateRep result;
        if ((result = overriddenStates[index])==null) {
            return inv.getStored(index).getItemStackState();
        } else {
            return result;
        }
    }
    private int getAmount(int index) {
        int result;
        if ((result = overriddenAmount[index])==0) {
            return inv.getStored(index).getAmount();
        } else {
            return result;
        }
    }

    private boolean isEmpty(int index) {
        return getAmount(index)==0;
    }


    private boolean isFull(int index) {
        int amount = getAmount(index);
        return amount >= inv.getMaxStack(index) || amount >= getState(index).getMaxStackSize();
    }

    public int store(ItemStackRep[] stacks, int multiplier) {
        //first lets make sure all out stacks are unique
        //lets hope that ItemStackStateRep implemented their hashcode and equals correctly
        Object2ObjectMap<ItemStackStateRep, ItemStackRep> stackMap = new Object2ObjectOpenHashMap<>(stacks.length);
        for (int i = 0; i < stacks.length; i++) {
            ItemStackRep stack =stacks[i];
            stackMap.compute(stack.getItemStackState(), (k, v) -> {
                if (v == null) {
                    return stack;
                }
                v.setAmount(v.getAmount() + stack.getAmount());
                return v;
            });
        }
        stacks = stackMap.values().toArray(stacks);

        //find all empty and filled slots, so we only iterate over slots that have the right properties
        int invSlots = inv.getSize();
        int finishedBags = 0;
        IntSet emptyBags = new IntOpenHashSet(invSlots-stacks.length);
        IntSet filledBags = new IntOpenHashSet(invSlots);

        for (int i = 0; i < inv.getSize(); i++) {
            if (isFull(i)) {
                finishedBags++;
                continue;
            }
            (isEmpty(i)?emptyBags:filledBags).add(i);
        }

        //find out max stack size for each
        //also find slots prefilled with same item state
        int[] maxes = new int[stacks.length];
        int[] free = new int[stacks.length];
        IntSet[] matchingBags = new IntSet[stacks.length];
        int totalAmount = 0;
        boolean allHavePrefilled = true;
        for (int i = 0; i < stacks.length; i++) {
            ItemStackRep stack =stacks[i];
            maxes[i] = stack.getMaxStackSize();
            totalAmount += stack.getAmount();
            matchingBags[i] = new IntOpenHashSet(emptyBags.size()/stacks.length);
            boolean missing = true;
            for(IntIterator iter = filledBags.iterator();iter.hasNext();) {
                int j = iter.nextInt();
                if (getState(j).isSimilar(stack)) {
                    iter.remove();
                    matchingBags[i].add(j);
                    free[i] += Math.min(maxes[i], inv.getMaxStack(j)) - getAmount(j); //this should never be negative or 0 as these bags should have been isFull == true
                    missing = false;
                }
            }

            //for the algorithm below we all need to have at least 1 slot assigned
            if (missing) {
                if (emptyBags.size() == 0) return multiplier; //no space for this stack type
                int j = removeAny(emptyBags);
                free[i] += Math.min(maxes[i], inv.getMaxStack(j));
                matchingBags[i].add(j);
            }
        }

        //calculate best case
        int filledFree = 0;
        for (int i = 0; i < free.length; i++) {
            filledFree += free[i];
        }
        int emptyFree = 0;
        for(IntIterator iter = emptyBags.iterator();iter.hasNext();) {
            int i = iter.nextInt();
            emptyFree += inv.getMaxStack(i);
        }

        int remaining = Math.min(multiplier, (filledFree + emptyFree)/totalAmount);




        //three outcomes. we store everything: multiplier == 0, we run out of bags [early return], in one go we exactly fill all bags:  finishedBags == inv.getSize()
        while (remaining > 0 && finishedBags < inv.getSize()) {
            int shot = remaining;

            //get the max shot to fill up all the current bags
            for (int i = 0; i < stacks.length; i++) {
                ItemStackRep stack =stacks[i];
                int step = stack.getAmount();
                int minShot = free[i]/step;
                shot = Math.min(minShot, shot);
            }

            //fill bags
            for (int i = 0; i < stacks.length; i++) {
                ItemStackRep stack =stacks[i];
                IntSet currentBags = matchingBags[i];
                int step = stack.getAmount();
                int maxStack = maxes[i];
                int toFill = shot * step;
                free[i] -= toFill;

                //remove filled bags
                for(IntIterator iter = currentBags.iterator();iter.hasNext();) {
                    int j = iter.nextInt();
                    overriddenStates[j] = stack.getItemStackState();
                    int maxSlot = Math.min(maxStack, inv.getMaxStack(j));
                    int amount = getAmount(j);
                    int space = maxSlot - amount;
                    if (toFill >= space) {
                        overriddenAmount[j] = maxSlot;
                        iter.remove();
                        finishedBags++;
                    } else {
                        overriddenAmount[j] = amount + toFill;
                        break;
                    }
                }
            }

            //assign remaining multiplier
            multiplier -= shot;
            remaining -= shot;

            //assign empty bags
            for (int i = 0; i < stacks.length; i++) {
                ItemStackRep stack =stacks[i];
                int step = stack.getAmount();
                if (free[i] < step) {
                    if (emptyBags.size() == 0) return multiplier; //no space anymore, the remaining multiplier cannot be stored
                    int j = removeAny(emptyBags);
                    free[i] += Math.min(maxes[i], inv.getMaxStack(j));
                    matchingBags[i].add(j);
                }
            }


        }

        return multiplier;
    }

    private static int removeAny(IntSet set) {
        IntIterator iter = set.iterator();
        int result = iter.nextInt();
        iter.remove();
        return result;
    }

    public int store(ItemStackRep stack, int multiplier) {
        int max = stack.getMaxStackSize(); //todo add inv max
        int remaining = stack.getAmount() * multiplier;

        for (int i = 0; i < inv.getSize(); i++) {
            int slotStackAmount = getAmount(i);
            if (slotStackAmount >= max)continue;
            boolean slotEmpty = slotStackAmount == 0;
            if (slotEmpty) {
                overriddenStates[i] = stack.getItemStackState();
            }

            if (slotEmpty && remaining <= max) {
                overriddenAmount[i] = remaining;
                return 0;
            } else if (slotEmpty || stack.isSimilar(getState(i))) {
                int fill = Math.min(max, slotStackAmount + remaining);
                remaining = Math.max(0, slotStackAmount + remaining - fill);
                overriddenAmount[i] = fill;
                if (remaining == 0) {
                    return 0;
                }
            }
        }
        return (remaining+stack.getAmount()-1)/stack.getAmount(); //round up
    }
}
