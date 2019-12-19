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

    default void clear() {
        for (int i = 0; i < getSize(); i++) {
            setStored(i, ItemStackFactory.INSTANCE.empty());
        }
    }

    default ItemStackRep store(ItemStackRep stack) {
        int max = stack.getMaxStackSize(); //todo add inv max

        for (int i = 0; i < getSize(); i++) {
            ItemStackRep slotStack = getStored(i);
            if (slotStack.getAmount() >= max)continue;
            boolean slotEmpty = slotStack.isEmpty();

            if (slotEmpty && stack.getAmount() <= max) {
                setStored(i, stack);
                return ItemStackFactory.INSTANCE.empty();
            }
            if (slotEmpty || slotStack.isSimilar(stack)) {
                int fill = Math.min(max, slotStack.getAmount() + stack.getAmount());
                int remaining = Math.min(0, (slotStack.getAmount() + stack.getAmount()) - fill);
                if (slotEmpty) {
                    setStored(i, stack.asQuantity(fill));
                } else {
                    slotStack.setAmount(fill);
                }
                if (remaining > 0) {
                    stack.setAmount(remaining);
                } else {
                    return ItemStackFactory.INSTANCE.empty();
                }
            }
        }
        return stack;
    }

    default Iterator<ItemStackRep> getAllStored() {
        return IntStream.range(0, getSize()).mapToObj(this::getStored).iterator();
    }

    default Iterable<ItemStackRep> asIterable() {
        return this::getAllStored;
    }

    //todo add more stuff, accessible etc

    static int convert2DIndex(InventoryRep inv, int left, int top) {
        if (!inv.is2d() && top != 0) throw new IllegalArgumentException("Cannot request top != 1 for 1D inventory");
        return left + top * inv.getWidth();
    }
}
