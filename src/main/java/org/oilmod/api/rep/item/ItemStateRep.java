package org.oilmod.api.rep.item;

import org.oilmod.api.rep.providers.ItemStateProvider;

public interface ItemStateRep extends ItemStateProvider {
    boolean isReadOnly();
    ItemStateRep copy();
    ItemRep getItem();

    @Override
    default ItemStateRep getProvidedItemState() {
        return this;
    }
}
