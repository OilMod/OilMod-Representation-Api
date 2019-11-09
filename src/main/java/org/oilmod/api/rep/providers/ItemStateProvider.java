package org.oilmod.api.rep.providers;

import org.oilmod.api.rep.block.BlockStateRep;
import org.oilmod.api.rep.item.ItemStateRep;

public interface ItemStateProvider {
    ItemStateRep getProvidedItemState();
}
