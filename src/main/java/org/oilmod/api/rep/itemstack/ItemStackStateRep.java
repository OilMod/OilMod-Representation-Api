package org.oilmod.api.rep.itemstack;

import org.oilmod.api.rep.enchant.EnchantmentRep;
import org.oilmod.api.rep.item.ItemStateRep;

public interface ItemStackStateRep {
    ItemStateRep getItemState();



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
}
