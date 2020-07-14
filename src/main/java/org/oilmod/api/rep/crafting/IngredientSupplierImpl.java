package org.oilmod.api.rep.crafting;

import org.oilmod.api.rep.inventory.InventoryRep;
import org.oilmod.api.rep.itemstack.ItemStackRep;

import java.util.Iterator;

public class IngredientSupplierImpl implements IIngredientSupplier {
    private final InventoryRep inv;
    private final boolean shaped;
    private Object nms;

    public IngredientSupplierImpl(InventoryRep inv, boolean shaped) {
        this.inv = inv;
        this.shaped = shaped;
        if (shaped && !inv.is2d())throw new IllegalArgumentException("Cannot supply 1D inventory to shaped ingredient supplier");
    }

    @Override
    public boolean isShaped() {
        return shaped;
    }

    @Override
    public ItemStackRep getSupplied(int index) {
        return inv.getStored(index);
    }

    @Override
    public ItemStackRep getSupplied(int left, int top) {
        return inv.getStored(left, top);
    }

    @Override
    public int getSupSlotMaxStack(int index) {
        return inv.getMaxStack(index);
    }

    @Override
    public int getSupSlotMaxStack(int left, int top) {
        return inv.getMaxStack(left, top);
    }

    @Override
    public void setNMS(Object nms) {
        this.nms = nms;
    }

    @Override
    public Object getNMS() {
        return nms;
    }

    @Override
    public int getSuppliedWidth() {
        return inv.getWidth();
    }

    @Override
    public int getSuppliedHeight() {
        return inv.getHeight();
    }

    @Override
    public Iterator<ItemStackRep> getSuppliedAll() {
        return inv.getAllStored();
    }

}
