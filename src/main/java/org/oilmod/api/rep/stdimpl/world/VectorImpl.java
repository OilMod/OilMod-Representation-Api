package org.oilmod.api.rep.stdimpl.world;

import org.oilmod.api.rep.world.VectorRep;

public class VectorImpl implements VectorRep {
    private final double x;
    private final double y;
    private final double z;

    protected VectorImpl(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
}
