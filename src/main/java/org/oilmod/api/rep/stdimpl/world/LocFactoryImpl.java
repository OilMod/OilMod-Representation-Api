package org.oilmod.api.rep.stdimpl.world;

import org.oilmod.api.rep.world.LocBuilder;
import org.oilmod.api.rep.world.LocFactory;
import org.oilmod.api.rep.world.LocationBlockRep;
import org.oilmod.api.rep.world.LocationEntityRep;
import org.oilmod.api.rep.world.LocationRep;
import org.oilmod.api.rep.world.VectorRep;
import org.oilmod.api.rep.world.WorldRep;

public class LocFactoryImpl implements LocFactory {
    private static final Object MUTEX = new Object();
    private static LocFactory instance;
    private static final String CANNOT_INITIALISE_SINGLETON_TWICE = "Cannot initialise singleton twice!";

    protected LocFactoryImpl() {}


    public static void setInstance(LocFactoryImpl instance) {
        if (LocFactoryImpl.instance == null) {
            synchronized (MUTEX) {
                if (LocFactoryImpl.instance == null) {
                    LocFactoryImpl.instance = instance;
                } else {
                    throw new IllegalStateException(CANNOT_INITIALISE_SINGLETON_TWICE);
                }
            }
        } else {
            throw new IllegalStateException(CANNOT_INITIALISE_SINGLETON_TWICE);
        }
    }

    public static LocFactory getInstance() {
        if (instance == null) throw new IllegalStateException("LocFactoryImpl is not initialised either call initStandard() or provide own implementation during application setup");
        return instance;
    }

    public static void initStandard() {
        setInstance(new LocFactoryImpl());
    }

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
