package org.oilmod.api.rep.providers;

import org.oilmod.api.rep.block.BlockStateRep;
import org.oilmod.api.rep.item.ItemRep;

public interface ItemProvider {
    ItemRep getProvidedItem();
}
