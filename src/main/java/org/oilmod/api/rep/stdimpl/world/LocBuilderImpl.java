package org.oilmod.api.rep.stdimpl.world;

import org.oilmod.api.rep.world.LocBuilder;
import org.oilmod.api.rep.world.LocFactory;
import org.oilmod.api.rep.world.WorldRep;

public class LocBuilderImpl implements LocBuilder {

    private double x;
    private double y;
    private double z;
    private double pitch;
    private double yaw;
    private WorldRep world;
    private final LocFactory factory;

    protected LocBuilderImpl(LocFactory factory) {
        this.factory = factory;
    }


    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public double getPitch() {
        return pitch;
    }

    @Override
    public double getYaw() {
        return yaw;
    }

    @Override
    public WorldRep getWorld() {
        return world;
    }

    @Override
    public LocFactory getFactory() {
        return factory;
    }

    @Override
    public LocBuilder x(double x) {
        this.x = x;
        return this;
    }

    @Override
    public LocBuilder y(double y) {
        this.y = y;
        return this;
    }

    @Override
    public LocBuilder z(double z) {
        this.z = z;
        return this;
    }

    @Override
    public LocBuilder pitch(double pitch) {
        this.pitch = pitch;
        return this;
    }

    @Override
    public LocBuilder yaw(double yaw) {
        this.yaw = yaw;
        return this;
    }

    @Override
    public LocBuilder world(WorldRep w) {
        this.world = w;
        return this;
    }

    @Override
    public LocBuilder clone() {
        return getFactory().createBuilder().add(this).yaw(getYaw()).pitch(getPitch()).world(getWorld());
    }

}
