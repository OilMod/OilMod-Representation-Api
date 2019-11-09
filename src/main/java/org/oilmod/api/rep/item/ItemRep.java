package org.oilmod.api.rep.item;

import org.oilmod.api.rep.providers.ItemProvider;
import org.oilmod.api.rep.variant.IVariantable;

public interface ItemRep extends ItemProvider {
    ItemStateRep getStandardState();
    int getMaxDurability();

    @Override
    default ItemRep getProvidedItem() {
        return this;
    }
}
