package org.oilmod.api.rep.inventory;

import org.oilmod.api.rep.itemstack.ItemStackFactory;
import org.oilmod.api.rep.itemstack.ItemStackRep;

import java.util.Iterator;
import java.util.stream.IntStream;

public interface InventoryRep {
    default int getSize() {
        return is2d()?getWidth() * getHeight():getWidth();
    }
    int getWidth();
    int getHeight();
    default boolean is2d() {
        return getHeight() > 0;
    }

    ItemStackRep getStored(int slot);
    default ItemStackRep getStored(int left, int top) {
        return getStored(convert2DIndex(this, left, top));
    }
    void setStored(int slot, ItemStackRep stack);

    default void setStored(int left, int top, ItemStackRep stack) {
        setStored(convert2DIndex(this, left, top), stack);
    }

    boolean isEmpty(int slot);
    default boolean isEmpty(int left, int top) {
        return isEmpty(convert2DIndex(this, left, top));
    }

    int getStack(int slot);
    default int getStack(int left, int top) {
        return getStack(convert2DIndex(this, left, top));
    }

    boolean isNative();

    default InventoryView createView(int indexOffset, int size) {
        return new InventoryViewImpl(this, indexOffset, size);
    }
    default InventoryView createView2d(int left, int width, int top, int height) {
        return new InventoryViewImpl(this, left, width, top, height);
    }
    default InventoryView createView2d(int indexOffset, int width, int height) {
        return new InventoryViewImpl(this, indexOffset, width, height);
    }

    /**
     * Custom implementation need to account for resizing or mirroree themselves! This is for fixed after ctor sized inventories only
     * @return
     */
    default MirrorSizedInventoryRep createSizeMirror() {
        return is2d()?InventoryFactory.INSTANCE.createFixedSizeMirrorer2d(this):InventoryFactory.INSTANCE.createFixedSizeMirrorer1d(this);
    }


    int getMaxStack(int slot);
    default int getMaxStack(int left, int top) {
        return getMaxStack(convert2DIndex(this, left, top));
    }

    default void clear() {
        for (int i = 0; i < getSize(); i++) {
            setStored(i, ItemStackFactory.empty());
        }
    }

    default ItemStackRep store(ItemStackRep stack) {
        int max = stack.getMaxStackSize();

        for (int i = 0; i < getSize(); i++) {
            ItemStackRep slotStack = getStored(i);
            boolean slotEmpty = slotStack.isEmpty();

            int slotMax = Math.min(max, getMaxStack(i));

            if (slotEmpty && stack.getAmount() <= slotMax) {
                setStored(i, stack);
                return ItemStackFactory.empty();
            }
            if (slotEmpty || slotStack.isSimilar(stack)) {
                int fill = Math.min(slotMax, slotStack.getAmount() + stack.getAmount());
                int remaining = Math.max(0, (slotStack.getAmount() + stack.getAmount()) - fill);
                if (slotEmpty) {
                    setStored(i, stack.asQuantity(fill));
                } else {
                    slotStack.setAmount(fill);
                }
                if (remaining > 0) {
                    stack.setAmount(remaining);
                } else {
                    return ItemStackFactory.empty();
                }
            }
        }
        return stack;
    }


    default int take(ItemStackRep stack) {
        int remaining = stack.getAmount();

        for (int i = 0; i < getSize(); i++) {
            ItemStackRep slotStack = getStored(i);
            boolean slotEmpty = slotStack.isEmpty();


            if (!slotEmpty && slotStack.isSimilar(stack)) {
                if (slotStack.getAmount() >= remaining) {
                    slotStack.setAmount(slotStack.getAmount() - remaining);
                    return 0;
                } else {
                    remaining -= slotStack.getAmount();
                    slotStack.setAmount(0);
                }
            }
        }
        return remaining;
    }

    default boolean isEmpty() {
        for (int i = 0; i < getSize(); i++) {
            if (!getStored(i).isEmpty())return false;
        }
        return true;
    }

    default Iterator<ItemStackRep> getAllStored() {
        return IntStream.range(0, getSize()).mapToObj(this::getStored).iterator();
    }

    default Iterable<ItemStackRep> asIterable() {
        return this::getAllStored;
    }

    //todo add more stuff, accessible etc

    static int convert2DIndex(InventoryRep inv, int left, int top) {
        if (!inv.is2d() && top != 0) throw new IllegalArgumentException("Cannot request top != 0 for 1D inventory");
        return left + top * inv.getWidth();
    }

    InventoryRep EMPTY = new InventoryRep() {
        @Override
        public int getWidth() {
            return 0;
        }

        @Override
        public int getHeight() {
            return 0;
        }

        @Override
        public ItemStackRep getStored(int slot) {
            return null;
        }

        @Override
        public void setStored(int slot, ItemStackRep stack) {

        }

        @Override
        public boolean isEmpty(int slot) {
            return true;
        }

        @Override
        public int getStack(int slot) {
            return 0;
        }

        @Override
        public boolean isNative() {
            return false;
        }

        @Override
        public int getMaxStack(int slot) {
            return 0;
        }
    };
}
