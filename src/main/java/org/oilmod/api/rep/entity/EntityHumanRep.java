package org.oilmod.api.rep.entity;

import org.oilmod.api.rep.inventory.InventoryRep;
import org.oilmod.api.rep.inventory.InventoryUIRep;
import org.oilmod.api.rep.itemstack.ItemStackRep;

public interface EntityHumanRep extends EntityLivingRep {
    /**
     * Returns the name of this player
     *
     * @return Player name
     */
    public String getName();


    /**
     * Opens an inventory window with the specified inventory on the top and
     * the player's inventory on the bottom.
     *
     * @param inventory The inventory to open
     * @return The newly opened inventory view
     */
    public InventoryUIRep openInventory(InventoryRep inventory);

    /**
     * Returns the ItemStack currently in your hand, can be empty.
     *
     * @return The ItemStack of the item you are currently holding.
     * @deprecated Humans may now dual wield in their off hand, use explicit
     * methods in TODO PlayerInventory.
     */
    public ItemStackRep getItemInHand();

    /**
     * Returns the ItemStack currently on your cursor, can be empty. Will
     * always be empty if the player currently has no open window.
     *
     * @return The ItemStack of the item you are currently moving around.
     */
    public ItemStackRep getItemOnCursor();

    /**
     * Sets the item to the given ItemStack, this will replace whatever the
     * user was moving. Will always be empty if the player currently has no
     * open window.
     *
     * @param stack The ItemStack which will end up in the hand
     */
    public void setItemOnCursor(ItemStackRep stack);

    /**
     * Returns whether this player is slumbering.
     *
     * @return slumber state
     */
    public boolean isSleeping();

    /**
     * Get the sleep ticks of the player. This value may be capped.
     *
     * @return slumber ticks
     */
    public int getSleepTicks();

    /**
     * Check if the player is currently blocking (ie with a shield).
     *
     * @return Whether they are blocking.
     */
    public boolean isBlocking();

    /**
     * Get the total amount of experience required for the player to level
     *
     * @return Experience required to level up
     */
    public int getExpToLevel();


    /**
     * Returns if the player is in sneak mode
     *
     * @return true if player is in sneak mode
     */
    public boolean isSneaking();

    /**
     * Sets the sneak mode the player
     *
     * @param sneak true if player should appear sneaking
     */
    public void setSneaking(boolean sneak);

    /**
     * Gets whether the player is sprinting or not.
     *
     * @return true if player is sprinting.
     */
    public boolean isSprinting();

    /**
     * Sets whether the player is sprinting or not.
     *
     * @param sprinting true if the player should be sprinting
     */
    public void setSprinting(boolean sprinting);
}
