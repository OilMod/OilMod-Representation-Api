package org.oilmod.api.rep.crafting;

import org.oilmod.api.rep.inventory.InventoryRep;
import org.oilmod.api.rep.itemstack.ItemStackRep;
import org.oilmod.api.rep.itemstack.state.ItemStackStateRep;
import org.oilmod.api.rep.providers.ItemStackStateProvider;

public abstract class ReusableIngredientAccessor implements IIngredientAccessor {
    private ReusableIngredientSupplier supplier;
    private int index;
    private int left;
    private int top;
    private boolean shaped;

    public ReusableIngredientAccessor reset(ReusableIngredientSupplier supplier, int index) {
        this.supplier = supplier;
        this.index = index;
        this.left = -1;
        this.top = -1;
        this.shaped = false;
        return this;

    }
    public ReusableIngredientAccessor reset(ReusableIngredientSupplier supplier, int left, int top) {
        this.supplier = supplier;
        this.index = -1;
        this.left = left;
        this.top = top;
        this.shaped = supplier.is2d();
        return this;
    }

    @Override
    public final int getIndex() {
        return index;
    }

    @Override
    public final int getLeft() {
        return left;
    }

    @Override
    public final int getTop() {
        return top;
    }

    public final boolean isShaped() {
        return shaped;
    }

    public final InventoryRep getSupplier() {
        return supplier;
    }

    @Override
    public ItemStackStateProvider getItemState() {
        return getStack();
    }

    @Override
    public boolean isEmpty() {
        return shaped ? supplier.isEmpty(left, top): supplier.isEmpty(index);
    }

    protected ItemStackRep getStack() {
        return shaped ? supplier.getStored(left, top): supplier.getStored(index);
    }
    protected int getAmount() {
        return shaped ? supplier.getStack(left, top): supplier.getStack(index);
    }

    protected void setStack(ItemStackRep stack) {
        if (shaped) {
            supplier.setStored(left, top, stack);
        } else {
            supplier.setStored(index, stack);
        }
    }
}
