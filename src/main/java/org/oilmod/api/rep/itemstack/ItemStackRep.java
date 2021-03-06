package org.oilmod.api.rep.itemstack;

import org.oilmod.api.rep.enchant.EnchantmentRep;
import org.oilmod.api.rep.item.ItemRep;
import org.oilmod.api.rep.item.ItemStateRep;
import org.oilmod.api.rep.itemstack.state.ItemStackStateRep;
import org.oilmod.api.rep.providers.ItemProvider;
import org.oilmod.api.rep.providers.ItemStackStateProvider;
import org.oilmod.api.rep.providers.ItemStateProvider;

public interface ItemStackRep extends ItemStackStateProvider, ItemStateProvider, ItemProvider {

    ItemRep getItem();

    @Override
    default ItemStackRep createStack(int amount) {
        return ItemStackStateProvider.super.createStack(amount);
    }

    ItemStackStateRep getItemStackState();

     default ItemStateRep getItemState() {
         return getItemStackState().getItemState();
     }

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



    default void grow(int diff) {
        this.setAmount(getAmount() + diff);
    }

    default void shrink(int diff) {
        this.grow(-diff);
    }
    
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
    boolean isSimilar(ItemStackStateProvider stack); //name suggestion areStackable/isCoStackable

    ItemStackRep copy();



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
        ItemStackRep clone = copy();
        clone.setAmount(qty);
        return clone;
    }


    ItemStackStateRep getContainerItem();

    //todo this is a stupid name as it suggest that it should return true for e.g. backpacks
    boolean isContainer();

    boolean isEmpty();

    @Override
    default ItemStackStateRep getProvidedItemStackState() {
        return getItemStackState();
    }

    @Override
    default ItemRep getProvidedItem() {
        return getItem();
    }

    @Override
    default ItemStateRep getProvidedItemState() {
        return getItemState();
    }


    boolean equals(ItemStackRep other);
    int getHashCode();
}
