package org.oilmod.api.rep.itemstack;

import org.oilmod.api.rep.item.ItemRep;

public abstract class ItemStackFactory {
    public static ItemStackFactory INSTANCE;

    public abstract ItemStackRep create(ItemRep item);
    public abstract ItemStackRep create(ItemRep item, int amount);
}
