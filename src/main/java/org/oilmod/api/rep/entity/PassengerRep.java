package org.oilmod.api.rep.entity;

public interface PassengerRep {

    /**
     * Returns whether this entity is inside a vehicle.
     *
     * @return True if the entity is in a vehicle.
     */
    boolean isInsideVehicle();

    /**
     * Leave the current vehicle. If the entity is currently in a vehicle (and
     * is removed from it), true will be returned, otherwise false will be
     * returned.
     *
     * @return True if the entity was in a vehicle.
     */
    boolean leaveVehicle();

    /**
     * Get the vehicle that this player is inside. If there is no vehicle,
     * null will be returned.
     *
     * @return The current vehicle.
     */
    VehicleRep getVehicle();
}
