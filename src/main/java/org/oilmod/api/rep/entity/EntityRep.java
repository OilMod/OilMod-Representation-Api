package org.oilmod.api.rep.entity;

import org.oilmod.api.rep.world.LocationEntityRep;
import org.oilmod.api.rep.world.LocationRep;
import org.oilmod.api.rep.world.VectorRep;
import org.oilmod.api.rep.world.WorldRep;

import java.util.UUID;

public interface EntityRep {

    /**
     * Gets the entity's current position
     *
     * @return a new copy of Location containing the position of this entity
     */
    LocationEntityRep getLocationRep();

    /**
     * Sets this entity's velocity
     *
     * @param velocity New velocity to travel with
     */
    void setVelocity(VectorRep velocity);

    /**
     * Gets this entity's current velocity
     *
     * @return Current traveling velocity of this entity
     */
    VectorRep getVelocityRep();

    /**
     * Returns true if the entity is supported by a block. This value is a
     * state updated by the server and is not recalculated unless the entity
     * moves.
     *
     * @return True if entity is on ground.
     */
    boolean isOnGround();

    /**
     * Gets the current world this entity resides in
     *
     * @return World
     */
    WorldRep getWorld();

    /**
     * Teleports this entity to the given location. If this entity is riding a
     * vehicle, it will be dismounted prior to teleportation.
     *
     * @param location New location to teleport this entity to
     * @return <code>true</code> if the teleport was successful
     */
    boolean teleport(LocationRep location);


    /**
     * Returns the entity's current fire ticks Rep(ticks before the entity stops
     * being on fire).
     *
     * @return int fireTicks
     */
    int getFireTicks();

    /**
     * Returns the entity's maximum fire ticks.
     *
     * @return int maxFireTicks
     */
    int getMaxFireTicks();

    /**
     * Sets the entity's current fire ticks Rep(ticks before the entity stops
     * being on fire).
     *
     * @param ticks Current ticks remaining
     */
    void setFireTicks(int ticks);

    /**
     * Mark the entity's removal.
     */
    void remove();

    /**
     * Returns true if this entity has been marked for removal.
     *
     * @return True if it is dead.
     */
    boolean isDead();

    /**
     * Returns false if the entity has died or been despawned for some other
     * reason.
     *
     * @return True if valid.
     */
    boolean isValid();



    /**
     * Returns the distance this entity has fallen
     *
     * @return The distance.
     */
    float getFallDistance();

    /**
     * Sets the fall distance for this entity
     *
     * @param distance The new distance.
     */
    void setFallDistance(float distance);


    /**
     * Returns a unique and persistent id for this entity
     *
     * @return unique id
     */
    UUID getUniqueId();



}
