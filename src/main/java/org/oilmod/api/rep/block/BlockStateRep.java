package org.oilmod.api.rep.block;

import org.oilmod.api.rep.world.LocationBlockRep;

public interface BlockStateRep {
    BlockRep getBlock();

    //BlockType getBlockType(); //todo import from oilapi
    float getBlockHardness(LocationBlockRep location); //todo this is weird, improve
    //todo add way to access states
}
