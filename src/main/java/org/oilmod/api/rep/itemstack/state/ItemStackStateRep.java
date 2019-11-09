package org.oilmod.api.rep.itemstack.state;

import org.oilmod.api.rep.enchant.EnchantmentRep;
import org.oilmod.api.rep.item.ItemStateRep;
import org.oilmod.api.rep.itemstack.ItemStackFactory;
import org.oilmod.api.rep.itemstack.ItemStackRep;
import org.oilmod.api.rep.providers.ItemStackStateProvider;
import org.oilmod.api.util.ReadSet;

import java.util.Map;
import java.util.Set;

public interface ItemStackStateRep extends ItemStackStateProvider {
    ItemStateRep getItemState();
    void applyItemState(ItemStateRep state);
    boolean isAttached();

    default void applyTo(ItemStackRep stack) {
        applyTo(stack.getItemStackState());
    }

    default void applyTo(ItemStackStateRep to) {
        to.applyItemState(getItemState());
        to.setItemDamage(getItemDamage());
        for (EnchantmentRep ench:to.getEnchantments()) {
            to.removeEnchantment(ench);
        }
        for (EnchantmentRep ench:getEnchantments()) {
            to.addEnchantment(ench, getEnchantmentLevel(ench), true); //assumed to be valid or already forced
        }
    }

    default ItemStackStateRep copy() {
        return ItemStackFactory.INSTANCE.cloneStackState(this);
    }

    @Override
    default ItemStackStateRep getProvidedItemStackState() {
        return this;
    }

    /**
     * Sets the damage of this item
     *
     * @param itemDamage damage of this item
     */
    void setItemDamage(final int itemDamage);

    /**
     * Gets the damage of this item
     *
     * @return damage of this item
     */
    int getItemDamage();

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
     * @param force makes sure the enchantment is applied even if it doesnt fit or conflict
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

    ReadSet<? extends EnchantmentRep> getEnchantments();
}
