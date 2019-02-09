package org.oilmod.api.rep.enchant;

import org.oilmod.api.rep.item.ItemRep;

public interface EnchantmentRep {
    /**
     * Gets the unique name of this enchantment
     *
     * @return Unique name
     */
    String getName();

    /**
     * Gets the maximum level that this Enchantment may become.
     *
     * @return Maximum level of the Enchantment
     */
    int getMaxLevel();

    /**
     * Gets the level that this Enchantment should start at
     *
     * @return Starting level of the Enchantment
     */
    int getStartLevel();

    /**
     * Checks if this enchantment is a treasure enchantment.
     * <br>
     * Treasure enchantments can only be received via looting, trading, or
     * fishing.
     *
     * @return true if the enchantment is a treasure enchantment
     */
    boolean isTreasure();

    /**
     * Checks if this enchantment is a cursed enchantment
     * <br>
     * Cursed enchantments are found the same way treasure enchantments are
     *
     * @return true if the enchantment is cursed
     */
    boolean isCurse();

    /**
     * Check if this enchantment conflicts with another enchantment.
     *
     * @param other The enchantment to check against
     * @return True if there is a conflict.
     */
    boolean conflictsWith(EnchantmentRep other);

    /**
     * Checks if this Enchantment may be applied to the given {@link
     * ItemRep}.
     *
     * @param item Item to test
     * @return True if the enchantment may be applied, otherwise False
     */
    boolean canEnchantItem(ItemRep item);
}
