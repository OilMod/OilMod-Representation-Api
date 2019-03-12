package org.oilmod.api.rep.itemstack;

import org.oilmod.api.rep.enchant.EnchantmentRep;
import org.oilmod.api.rep.item.ItemRep;
import org.oilmod.api.rep.item.ItemStateRep;

public interface ItemStackRep {

    ItemRep getItem();


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

    boolean isEmpty();

}
