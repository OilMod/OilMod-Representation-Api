package org.oilmod.api.rep.itemstack.state;

import org.oilmod.api.rep.enchant.EnchantmentRep;
import org.oilmod.api.rep.item.ItemRep;
import org.oilmod.api.rep.item.ItemStateRep;
import org.oilmod.api.rep.itemstack.ItemStackFactory;
import org.oilmod.api.rep.itemstack.ItemStackRep;
import org.oilmod.api.rep.providers.ItemProvider;
import org.oilmod.api.rep.providers.ItemStackStateProvider;
import org.oilmod.api.rep.providers.ItemStateProvider;
import org.oilmod.api.util.ReadSet;

public interface ItemStackStateRep extends ItemStackStateProvider, ItemStateProvider, ItemProvider {
    ItemStateRep getItemState();
    void applyItemState(ItemStateRep state);
    boolean isAttached();

    default void applyTo(ItemStackStateProvider state, boolean additive, boolean force) {
        ItemStackFactory.INSTANCE.STATE_COLLECTOR .apply(this, state.getProvidedItemStackState(), additive, force);
    }


    default ItemStackStateRep copy() {
        return ItemStackFactory.INSTANCE.cloneStackState(this);
    }

    @Override
    default ItemStackStateRep getProvidedItemStackState() {
        return this;
    }

    @Override
    default ItemStackRep createStack(int amount) {
        return ItemStackStateProvider.super.createStack(amount);
    }

    @Override
    default ItemStateRep getProvidedItemState() {
        return getItemState();
    }

    @Override
    default ItemRep getProvidedItem() {
        return getItemState().getItem();
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
     * @param state the item state to compare to
     * @return true if the two stacks are equal, ignoring the amount
     */
    boolean isSimilar(ItemStackStateProvider state);


    boolean equals(ItemStackStateRep other);
    int getHashCode();
}
