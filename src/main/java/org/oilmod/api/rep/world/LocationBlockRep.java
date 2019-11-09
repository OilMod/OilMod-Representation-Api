package org.oilmod.api.rep.world;

import org.oilmod.api.rep.block.BlockStateRep;
import org.oilmod.api.rep.providers.BlockStateProvider;
import org.oilmod.api.rep.stdimpl.world.LocFactoryImpl;
import org.oilmod.api.rep.world.internal.GeneralIntVector;

public interface LocationBlockRep extends LocationRep, GeneralIntVector {

    default LocationBlockRep createBlockLocation(int x, int y, int z, WorldRep w) {
        return LocFactoryImpl.getInstance().createBlockLocation(x, y, z, w);
    }

    @Override
    default double getX() {
        return getBlockX();
    }

    @Override
    default double getY() {
        return getBlockY();
    }

    @Override
    default double getZ() {
        return getBlockZ();
    }

    default LocationBlockRep getRelative(GeneralIntVector relVec) {
        return toBuilder().add(relVec).toBlockLocation();
    }


    default BlockStateRep getBlock() {
        return getWorld().getBlockAt(this);
    }
    default void setBlock(BlockStateProvider blockState) {
        getWorld().setBlockAt(this, blockState);
    }
}
