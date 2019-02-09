package org.oilmod.api.rep.world;

import org.oilmod.api.rep.stdimpl.world.LocFactoryImpl;

public interface LocationBlockRep extends LocationRep {
    int getBlockX();
    int getBlockY();
    int getBlockZ();

    default LocationBlockRep createBlockLocation(int x, int y, int z, WorldRep w) {
        return LocFactoryImpl.INSTANCE.createBlockLocation(x, y, z, w);
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
}
