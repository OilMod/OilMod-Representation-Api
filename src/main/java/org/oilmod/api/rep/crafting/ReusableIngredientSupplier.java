package org.oilmod.api.rep.crafting;

import org.oilmod.api.rep.inventory.InventoryRep;
import org.oilmod.api.rep.inventory.InventoryView;
import org.oilmod.api.rep.itemstack.ItemStackRep;

import java.util.Iterator;

public class ReusableIngredientSupplier implements IIngredientSupplier, InventoryView {
    private final InventoryRep root;
    private final ReusableIngredientAccessor accessor;
    private final IIngredientCategory category;
    private int leftOff;
    private int topOff;
    private int width;
    private int height;
    private boolean shaped;
    int[] shapelessAccessorMap;

    public ReusableIngredientSupplier(IIngredientCategory category, InventoryRep root, ReusableIngredientAccessor accessor) {
        this.category = category;
        this.root = root;
        this.accessor = accessor;
        reset();
    }


    //<editor-fold defaultstate="collapsed" desc="InventoryView Impl">
    @Override
    public boolean is2d() {
        return shaped;
    }

    @Override
    public InventoryRep getRoot() {
        return root;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }


    public int getLeftOff() {
        return leftOff;
    }

    public int getTopOff() {
        return topOff;
    }
    //</editor-fold>


    public void reset() {
        this.leftOff = 0;
        this.topOff = 0;
        this.width = root.getWidth();
        this.height = root.getHeight();
        this.shaped = root.is2d();
        this.shapelessAccessorMap = null;
    }

    public void resize(int left, int width, int top, int height) {
        this.leftOff = left;
        this.width = width;
        this.topOff = top;
        this.height = height;
        this.shaped = true;
    }

    public void setShapelessAccessorMap(int[] shapelessAccessorMap) {
        this.shapelessAccessorMap = shapelessAccessorMap;
    }

    @Override
    public boolean isShaped() {
        return shaped;
    }

    @Override
    public IIngredientAccessor getSuppliedShaped(int left, int top) {
        return accessor.reset(this, left, top, width);
    }

    @Override
    public IIngredientAccessor getSuppliedShapeless(int index) {
        return accessor.reset(this, shapelessAccessorMap[index]);
    }

    @Override
    public int getSupSlotMaxStack(int index) {
        return getMaxStack(index);
    }

    @Override
    public int getSupSlotMaxStack(int left, int top) {
        return getMaxStack(left, top);
    }


    private Object nms;
    @Override
    public void setNMS(Object nms) {
        this.nms = nms;
    }

    @Override
    public Object getNMS() {
        return nms;
    }

    @Override
    public IIngredientCategory getCategory() {
        return category;
    }

    @Override
    public int getSuppliedWidth() {
        return getWidth();
    }

    @Override
    public int getSuppliedHeight() {
        return getHeight();
    }

    @Override
    public int getSuppliedAmount() {
        return shapelessAccessorMap==null?0:shapelessAccessorMap.length;
    }

    @Override
    public int getSize() {
        return isShaped()?getWidth()*getHeight():getSuppliedAmount();
    }

    @Override
    public Iterator<ItemStackRep> getSuppliedAll() {
        return getAllStored();
    }

    @Override
    public Iterable<ItemStackRep> asIterable() {
        return IIngredientSupplier.super.asIterable();
    }



}
