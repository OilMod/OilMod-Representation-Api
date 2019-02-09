package org.oilmod.api.rep.world;

public interface LocFactory {
    VectorRep createVector(double x, double y, double z);
    LocationRep createLocation(double x, double y, double z, WorldRep w);
    LocationBlockRep createBlockLocation(int x, int y, int z, WorldRep w);
    LocationEntityRep createEntityLocation(double x, double y, double z, double yaw, double pitch, WorldRep w);
    LocBuilder createBuilder();

    default VectorRep createVector(LocBuilder b) {
        return createVector(b.getX(), b.getY(), b.getZ());
    }

    default LocationRep createLocation(LocBuilder b) {
        return createLocation(b.getX(), b.getY(), b.getZ(), b.getWorld());
    }

    default LocationBlockRep createBlockLocation(LocBuilder b) {
        return createBlockLocation((int)b.getX(), (int)b.getY(), (int)b.getZ(), b.getWorld());
    }

    default LocationEntityRep createEntityLocation(LocBuilder b) {
        return createEntityLocation(b.getX(), b.getY(), b.getZ(), b.getPitch(), b.getYaw(), b.getWorld());
    }
}
