package org.oilmod.api.rep.stdimpl.world;

import org.oilmod.api.rep.world.LocationEntityRep;
import org.oilmod.api.rep.world.WorldRep;

public class LocationEntityImpl extends LocationImpl implements LocationEntityRep {
    private final double pitch;
    private final double yaw;

    protected LocationEntityImpl(double x, double y, double z, double yaw, double pitch, WorldRep world) {
        super(x, y, z, world);
        this.pitch = pitch;
        this.yaw = yaw;
    }

    @Override
    public double getPitch() {
        return pitch;
    }

    @Override
    public double getYaw() {
        return yaw;
    }
}
