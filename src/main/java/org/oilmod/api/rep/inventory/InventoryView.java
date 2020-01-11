package org.oilmod.api.rep.inventory;

import org.oilmod.api.rep.itemstack.ItemStackRep;

public interface InventoryView extends InventoryRep {
    InventoryRep getRoot();
    int getLeftOff();
    int getTopOff();

    default int getBaseIndexOff() {
        return InventoryRep.convert2DIndex(getRoot(), this.getLeftOff(), this.getTopOff());
    }

    default int translateIndex(int index) {
        return getBaseIndexOff() + index;
    }

    default int translateIndex(int left, int top) {
        if (!getRoot().is2d()) {
            return translateIndex(InventoryRep.convert2DIndex(this, left, top));
        }
        return InventoryRep.convert2DIndex(getRoot(), this.getLeftOff() + left, this.getTopOff() + top);
    }

    @Override
    default ItemStackRep getStored(int slot) {
        return getRoot().getStored(translateIndex(slot));
    }

    @Override
    default ItemStackRep getStored(int left, int top) {
        if (!getRoot().is2d()) {
            return getRoot().getStored(translateIndex(left, top));
        }
        return getRoot().getStored(getLeftOff() + left, getTopOff() + top);
    }


    default int getMaxStack(int slot) {
        return getRoot().getMaxStack(translateIndex(slot));
    }
    default int getMaxStack(int left, int top) {
        if (!getRoot().is2d()) {
            return getRoot().getMaxStack(translateIndex(left, top));
        }
        return getRoot().getMaxStack(getLeftOff() + left, getTopOff() + top);
    }

    @Override
    default void setStored(int slot, ItemStackRep stack) {
        getRoot().setStored(translateIndex(slot), stack);
    }

    @Override
    default void setStored(int left, int top, ItemStackRep stack) {
        if (!getRoot().is2d()) {
            getRoot().setStored(translateIndex(left, top), stack);
        }
        getRoot().setStored(getLeftOff() + left, getTopOff() + top, stack);
    }

    @Override
    default boolean isNative() {
        return getRoot().isNative();
    }
}
