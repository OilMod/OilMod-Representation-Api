package org.oilmod.api.rep.itemstack;

import org.oilmod.api.rep.enchant.EnchantmentRep;
import org.oilmod.api.rep.item.ItemRep;

public interface ItemStackRep {

    ItemRep getItem();
    
    /**
     * Gets the amount of items in this stack
     *
     * @return Amount of items in this stack
     */
    int getAmount();

    /**
     * Sets the amount of items in this stack
     *
     * @param amount New amount of items in this stack
     */
    void setAmount(int amount);


    /**
     * Sets the durability of this item
     *
     * @param durability Durability of this item
     */
    void setDurability(final short durability);

    /**
     * Gets the durability of this item
     *
     * @return Durability of this item
     */
    short getDurability();

    /**
     * Get the maximum stacksize for the material hold in this ItemStack.
     * (Returns -1 if it has no idea)
     *
     * @return The maximum you can stack this material to.
     */
    int getMaxStackSize();

    /**
     * This method is the same as equals, but does not consider stack size
     * (amount).
     *
     * @param stack the item stack to compare to
     * @return true if the two stacks are equal, ignoring the amount
     */
    boolean isSimilar(ItemStackRep stack);

    ItemStackRep clone();

    /**
     * Gets the level of the specified enchantment on this item stack
     *
     * @param ench EnchantmentRep to check
     * @return Level of the enchantment, or 0
     */
    int getEnchantmentLevel(EnchantmentRep ench);

    /**
     * Adds the specified {@link EnchantmentRep} to this item stack.
     * <p>
     * If this item stack already contained the given enchantment (at any
     * level), it will be replaced.
     *
     * @param ench EnchantmentRep to add
     * @param level Level of the enchantment
     * @throws IllegalArgumentException if enchantment null, or enchantment is
     *     not applicable
     */
    void addEnchantment(EnchantmentRep ench, int level, boolean force);


    /**
     * Removes the specified {@link EnchantmentRep} if it exists on this
     * ItemStack
     *
     * @param ench EnchantmentRep to remove
     * @return Previous level, or 0
     */
    int removeEnchantment(EnchantmentRep ench);

    /**
     * Clones the itemstack and returns it a single quantity.
     * @return The new itemstack with 1 quantity
     */
    default ItemStackRep asOne() {
        return asQuantity(1);
    }

    /**
     * Clones the itemstack and returns it as the specified quantity
     * @param qty The quantity of the cloned item
     * @return The new itemstack with specified quantity
     */
    default ItemStackRep asQuantity(int qty) {
        ItemStackRep clone = clone();
        clone.setAmount(qty);
        return clone;
    }

    boolean isEmpty();

}
