package org.oilmod.api.rep.stdimpl.world;

import org.oilmod.api.rep.world.LocationRep;
import org.oilmod.api.rep.world.WorldRep;

public class LocationImpl extends VectorImpl implements LocationRep {
    private final WorldRep world;

    protected LocationImpl(double x, double y, double z, WorldRep world) {
        super(x, y, z);
        this.world = world;
    }

    @Override
    public WorldRep getWorld() {
        return world;
    }
}
