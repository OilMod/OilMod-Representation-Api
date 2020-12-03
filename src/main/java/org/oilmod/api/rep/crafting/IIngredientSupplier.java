package org.oilmod.api.rep.crafting;

import org.oilmod.api.rep.itemstack.ItemStackRep;

import java.util.Iterator;
import java.util.List;

public interface IIngredientSupplier {
    boolean isShaped();
    IIngredientAccessor getSuppliedShapeless(int index);
    IIngredientAccessor getSuppliedShaped(int left, int top);
    int getSupSlotMaxStack(int index);
    int getSupSlotMaxStack(int left, int top);
    void setNMS(Object nms);
    Object getNMS();

    /**
     * This is the reduced width. empty columns are not be counted!
     * @return
     */
    int getSuppliedWidth();
    /**
     * This is the reduced height. empty rows are not be counted!
     * @return
     */
    int getSuppliedHeight();
    /**
     * This returns the amount of items contained. this might be less than the supplied width*height!
     * @return
     */
    int getSuppliedAmount();
    Iterator<ItemStackRep> getSuppliedAll();


    default Iterable<ItemStackRep> asIterable() {
        return this::getSuppliedAll;
    }
}
