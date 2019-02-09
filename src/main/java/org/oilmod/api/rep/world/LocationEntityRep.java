package org.oilmod.api.rep.world;

import org.oilmod.api.rep.stdimpl.world.LocFactoryImpl;

public interface LocationEntityRep extends LocationRep {
    double getPitch();
    double getYaw();

    default LocationEntityRep createLocation(double x, double y, double z, double yaw, double pitch, WorldRep w) {
        return LocFactoryImpl.INSTANCE.createEntityLocation(x, y, z, yaw, pitch, w);
    }

    default LocBuilder toBuilder() {
        return LocationRep.super.toBuilder().pitch(getPitch()).yaw(getYaw());
    }
}
