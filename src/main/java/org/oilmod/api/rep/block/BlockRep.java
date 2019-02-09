package org.oilmod.api.rep.block;

import org.oilmod.api.rep.item.ItemRep;

public interface BlockRep {
    boolean hasItem();
    ItemRep getItem();
}
