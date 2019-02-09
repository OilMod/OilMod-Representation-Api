package org.oilmod.api.rep.entity;

public interface EntityLivingRep extends EntityRep {
    /**
     * Returns the amount of air that the living entity has remaining, in
     * ticks.
     *
     * @return amount of air remaining
     */
    int getRemainingAir();

    /**
     * Sets the amount of air that the living entity has remaining, in ticks.
     *
     * @param ticks amount of air remaining
     */
    void setRemainingAir(int ticks);

    /**
     * Returns the maximum amount of air the living entity can have, in ticks.
     *
     * @return maximum amount of air
     */
    int getMaximumAir();

    /**
     * Sets the maximum amount of air the living entity can have, in ticks.
     *
     * @param ticks maximum amount of air
     */
    void setMaximumAir(int ticks);

    /**
     * Returns the living entity's current maximum no damage ticks.
     * <p>
     * This is the maximum duration in which the living entity will not take
     * damage.
     *
     * @return maximum no damage ticks
     */
    int getMaximumNoDamageTicks();

    /**
     * Sets the living entity's current maximum no damage ticks.
     *
     * @param ticks maximum amount of no damage ticks
     */
    void setMaximumNoDamageTicks(int ticks);

    /**
     * Returns the living entity's last damage taken in the current no damage
     * ticks time.
     * <p>
     * Only damage higher than this amount will further damage the living
     * entity.
     *
     * @return damage taken since the last no damage ticks time period
     */
    double getLastDamage();

    /**
     * Sets the damage dealt within the current no damage ticks time period.
     *
     * @param damage amount of damage
     */
    void setLastDamage(double damage);

    /**
     * Returns the living entity's current no damage ticks.
     *
     * @return amount of no damage ticks
     */
    int getNoDamageTicks();

    /**
     * Sets the living entity's current no damage ticks.
     *
     * @param ticks amount of no damage ticks
     */
    void setNoDamageTicks(int ticks);


    /**
     * Sets whether or not the living entity can pick up items.
     *
     * @param pickup whether or not the living entity can pick up items
     */
    void setCanPickupItems(boolean pickup);

    /**
     * Gets if the living entity can pick up items.
     *
     * @return whether or not the living entity can pick up items
     */
    boolean getCanPickupItems();



    /**
     * Checks to see if an entity is gliding, such as using an Elytra.
     * @return True if this entity is gliding.
     */
    boolean isGliding();

    /**
     * Makes entity start or stop gliding. This will work even if an Elytra
     * is not equipped, but will be reverted by the server immediately after
     * unless an event-cancelling mechanism is put in place.
     * @param gliding True if the entity is gliding.
     */
    void setGliding(boolean gliding);

    /**
     * Sets whether an entity will have AI.
     *
     * @param ai whether the mob will have AI or not.
     */
    void setAI(boolean ai);

    /**
     * Checks whether an entity has AI.
     *
     * @return true if the entity has AI, otherwise false.
     */
    boolean hasAI();

    /**
     * Set if this entity will be subject to collisions other entities.
     * <p>
     * Note that collisions are bidirectional, so this method would need to be
     * set to false on both the collidee and the collidant to ensure no
     * collisions take place.
     *
     * @param collidable collision status
     */
    void setCollidable(boolean collidable);

    /**
     * Gets if this entity is subject to collisions with other entities.
     * <p>
     * Please note that this method returns only the custom collidable state,
     * not whether the entity is non-collidable for other reasons such as being
     * dead.
     *
     * @return collision status
     */
    boolean isCollidable();
}
