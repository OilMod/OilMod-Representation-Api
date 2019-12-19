package org.oilmod.api.rep.inventory;

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
                remaining = Math.min(0, slotStackAmount + remaining - fill);
                overriddenAmount[i] = fill;
                if (remaining == 0) {
                    return 0;
                }
            }
        }
        return remaining;
    }
}
