package org.oilmod.api.rep.stdimpl.world;

import org.oilmod.api.rep.world.LocBuilder;
import org.oilmod.api.rep.world.LocFactory;
import org.oilmod.api.rep.world.LocationBlockRep;
import org.oilmod.api.rep.world.LocationEntityRep;
import org.oilmod.api.rep.world.LocationRep;
import org.oilmod.api.rep.world.VectorRep;
import org.oilmod.api.rep.world.WorldRep;

public class LocFactoryImpl implements LocFactory {
    public static LocFactory INSTANCE = new LocFactoryImpl();

    protected LocFactoryImpl() {}

    @Override
    public VectorRep createVector(double x, double y, double z) {
        return new VectorImpl(x, y, z);
    }

    @Override
    public LocationRep createLocation(double x, double y, double z, WorldRep w) {
        return new LocationImpl(x, y, z, w);
    }

    @Override
    public LocationBlockRep createBlockLocation(int x, int y, int z, WorldRep w) {
        return new LocationBlockImpl(x, y, z, w);
    }

    @Override
    public LocationEntityRep createEntityLocation(double x, double y, double z, double yaw, double pitch, WorldRep w) {
        return new LocationEntityImpl(x, y, z, yaw, pitch, w);
    }

    @Override
    public LocBuilder createBuilder() {
        return new LocBuilderImpl(this);
    }
}
