package org.oilmod.api.rep.providers;

import org.oilmod.api.rep.item.ItemRep;
import org.oilmod.api.rep.itemstack.ItemStackFactory;
import org.oilmod.api.rep.itemstack.ItemStackRep;

public interface ItemProvider {
    ItemRep getProvidedItem();


    default ItemStackRep createStack(int amount) {
        return ItemStackFactory.create(this.getProvidedItem(), amount);
    }

    /***
     * use this to signal that the item provider in fact is not self-referential or direct and will be resolved at call-time
     */
    interface StdDeferred extends ItemProvider {
    }
}
