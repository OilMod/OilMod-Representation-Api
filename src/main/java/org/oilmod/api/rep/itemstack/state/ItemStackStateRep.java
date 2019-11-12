package org.oilmod.api.rep.itemstack.state;

import org.oilmod.api.rep.enchant.EnchantmentRep;
import org.oilmod.api.rep.item.ItemRep;
import org.oilmod.api.rep.item.ItemStateRep;
import org.oilmod.api.rep.itemstack.ItemStackFactory;
import org.oilmod.api.rep.providers.ItemProvider;
import org.oilmod.api.rep.providers.ItemStackStateProvider;
import org.oilmod.api.rep.providers.ItemStateProvider;
import org.oilmod.api.util.ReadSet;

public interface ItemStackStateRep extends ItemStackStateProvider, ItemStateProvider, ItemProvider {
    ItemStateRep getItemState();
    void applyItemState(ItemStateRep state);
    boolean isAttached();

    default void applyTo(ItemStackStateProvider state, boolean additive, boolean force) {
        ItemStackFactory.STATE_COLLECTOR.apply(this, state.getProvidedItemStackState(), additive, force);
    }


    default ItemStackStateRep copy() {
        return ItemStackFactory.INSTANCE.cloneStackState(this);
    }

    @Override
    default ItemStackStateRep getProvidedItemStackState() {
        return this;
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
     * This method is the same as equals, but does not consider stack size
     * (amount).
     *
     * @param stack the item stack to compare to
     * @return true if the two stacks are equal, ignoring the amount
     */
    boolean isSimilar(ItemStackStateProvider state);

}
