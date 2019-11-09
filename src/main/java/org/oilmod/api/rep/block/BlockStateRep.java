package org.oilmod.api.rep.block;

import org.oilmod.api.rep.providers.BlockStateProvider;
import org.oilmod.api.rep.world.LocationBlockRep;

public interface BlockStateRep extends BlockStateProvider {
    boolean isReadOnly();
    BlockRep getBlock();
    BlockStateRep copy();
    boolean isSame(BlockStateProvider other);

    @Override
    default BlockStateRep getProvidedBlockState() {
        return this;
    }

    //BlockType getBlockType(); //todo import from oilapi
    float getBlockHardness(LocationBlockRep location); //todo this is weird, improve
    //todo add way to access states (using currently unfinished variation api)
}
