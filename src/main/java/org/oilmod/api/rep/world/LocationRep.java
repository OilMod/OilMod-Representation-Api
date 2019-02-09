package org.oilmod.api.rep.world;

import org.oilmod.api.rep.stdimpl.world.LocFactoryImpl;

public interface LocationRep extends VectorRep {
    WorldRep getWorld();


    default LocationRep createLocation(double x, double y, double z, WorldRep w) {
        return LocFactoryImpl.INSTANCE.createLocation(x, y, z, w);
    }



    default LocBuilder toBuilder() {
        return VectorRep.super.toBuilder().world(getWorld());
    }
}
