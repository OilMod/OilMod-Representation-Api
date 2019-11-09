package org.oilmod.api.rep.world;

import org.oilmod.api.rep.block.BlockRep;
import org.oilmod.api.rep.block.BlockStateRep;
import org.oilmod.api.rep.providers.BlockStateProvider;
import org.oilmod.api.rep.world.internal.GeneralIntVector;

public interface WorldRep {
    BlockStateRep getBlockAt(LocationBlockRep loc);
    void setBlockAt(LocationBlockRep loc, BlockStateProvider blockState);
}
