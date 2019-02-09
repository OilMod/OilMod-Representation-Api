package org.oilmod.api.rep.world;

import org.oilmod.api.rep.world.internal.GeneralVector;

public interface LocBuilder extends GeneralVector {
    double getPitch();
    double getYaw();
    WorldRep getWorld();
    LocFactory getFactory();

    LocBuilder x(double x);

    default LocBuilder x(int x) {
        return x((double)x);
    }

    LocBuilder y(double y);

    default LocBuilder y(int y) {
        return y((double)y);
    }

    LocBuilder z(double z);

    default LocBuilder z(int z) {
        return z((double)z);
    }

    LocBuilder pitch(double pitch);
    LocBuilder yaw(double yaw);
    LocBuilder world(WorldRep w);
    LocBuilder clone();

    default LocBuilder add(GeneralVector v) {
        return x(getX()+v.getX()).y(getY()+v.getY()).z(getZ()+v.getZ());
    }
    default LocBuilder subtract(GeneralVector v) {
        return x(getX()-v.getX()).y(getY()-v.getY()).z(getZ()-v.getZ());
    }
    default LocBuilder multiply(GeneralVector v) {
        return x(getX()*v.getX()).y(getY()*v.getY()).z(getZ()*v.getZ());
    }
    default LocBuilder devideBy(GeneralVector v) {
        return x(getX()/v.getX()).y(getY()/v.getY()).z(getZ()/v.getZ());
    }
    default LocBuilder add(double x, double y, double z) {
        return x(getX()+x).y(getY()+y).z(getZ()+z);
    }
    default LocBuilder subtract(double x, double y, double z) {
        return x(getX()-x).y(getY()-y).z(getZ()-z);
    }
    default LocBuilder multiply(double x, double y, double z) {
        return x(getX()*x).y(getY()*y).z(getZ()*z);
    }
    default LocBuilder devideBy(double x, double y, double z) {
        return x(getX()/x).y(getY()/y).z(getZ()/z);
    }
    default LocBuilder add(double scala) {
        return x(getX()+scala).y(getY()+scala).z(getZ()+scala);
    }
    default LocBuilder subtract(double scala) {
        return x(getX()-scala).y(getY()-scala).z(getZ()-scala);
    }
    default LocBuilder multiply(double scala) {
        return x(getX()*scala).y(getY()*scala).z(getZ()*scala);
    }
    default LocBuilder devideBy(double scala) {
        return x(getX()/scala).y(getY()/scala).z(getZ()/scala);
    }

    default VectorRep toVector() {
        return getFactory().createVector(this);
    }

    default LocationRep toLocation() {
        return getFactory().createLocation(this);
    }

    default LocationBlockRep toBlockLocation() {
        return getFactory().createBlockLocation(this);
    }

    default LocationEntityRep toEntityLocation() {
        return getFactory().createEntityLocation(this);
    }
}
