package org.oilmod.api.rep.stdimpl.world;

import org.oilmod.api.rep.world.LocationBlockRep;
import org.oilmod.api.rep.world.WorldRep;

public class LocationBlockImpl implements LocationBlockRep {
    private final int x;
    private final int y;
    private final int z;
    private final WorldRep world;

    protected LocationBlockImpl(int x, int y, int z, WorldRep world) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.world = world;
    }

    @Override
    public WorldRep getWorld() {
        return world;
    }

    @Override
    public int getBlockX() {
        return x;
    }

    @Override
    public int getBlockY() {
        return y;
    }

    @Override
    public int getBlockZ() {
        return z;
    }
}
