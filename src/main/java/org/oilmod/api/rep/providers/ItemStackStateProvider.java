package org.oilmod.api.rep.providers;

import org.oilmod.api.rep.block.BlockStateRep;
import org.oilmod.api.rep.itemstack.state.ItemStackStateRep;

public interface ItemStackStateProvider {
    ItemStackStateRep getProvidedItemStackState();
}
