package org.oilmod.api.rep.crafting;

import org.oilmod.api.rep.itemstack.ItemStackConsumerRep;
import org.oilmod.api.rep.itemstack.ItemStackRep;
import org.oilmod.api.util.checkstate.ICheckState;

import java.util.List;
import java.util.function.Supplier;

public interface IIngredient {
    EmptyIngredient EMPTY = new EmptyIngredient();

    /**
     * Might always return unique examples and not repeat or it repeats after some time.
     * If it repeats it has the same values as getExamples()
     * @return returns examples
     */
    Supplier<ItemStackRep> getExampleSupplier(); //todo this probably needs checkstate

    /**
     * @return returns list of examples, might not be as exhaustive as getExampleSupplier()
     */
    List<ItemStackRep> getExamples();
    boolean check(ItemStackRep rep, ICheckState checkState, int slotId);
    int consume(ItemStackRep rep, int slotId, ItemStackConsumerRep stackConsumer, int multiplier, int maxStack, ICheckState checkState, boolean simulate);

    default boolean isEmpty() {
        return false;
    }
}
