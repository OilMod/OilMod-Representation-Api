package org.oilmod.api.rep.providers;

import org.oilmod.api.rep.block.BlockStateRep;

public interface BlockStateProvider {
    BlockStateRep getProvidedBlockState();
}
