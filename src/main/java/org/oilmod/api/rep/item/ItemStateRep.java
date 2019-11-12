package org.oilmod.api.rep.item;

import org.oilmod.api.rep.providers.ItemProvider;
import org.oilmod.api.rep.providers.ItemStateProvider;

public interface ItemStateRep extends ItemStateProvider, ItemProvider {
    boolean isReadOnly();
    ItemStateRep copy();
    ItemRep getItem();

    @Override
    default ItemStateRep getProvidedItemState() {
        return this;
    }

    @Override
    default ItemRep getProvidedItem() {
        return getItem();
    }

    boolean isSimilar(ItemStateProvider itemState);
}
