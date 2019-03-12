package org.oilmod.api.rep.block;

import org.oilmod.api.rep.world.LocationBlockRep;

public interface BlockStateRep {
    boolean isReadOnly();
    BlockRep getBlock();
    BlockStateRep copy();

    //BlockType getBlockType(); //todo import from oilapi
    float getBlockHardness(LocationBlockRep location); //todo this is weird, improve
    //todo add way to access states (using currently unfinished variation api)
}
