package org.oilmod.api.rep.item;

import org.oilmod.api.rep.variant.IVariantable;

public interface ItemRep {
    ItemStateRep getStandardState();
    int getMaxDurability();
}
