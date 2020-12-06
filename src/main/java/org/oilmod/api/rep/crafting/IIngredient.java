package org.oilmod.api.rep.crafting;

import it.unimi.dsi.fastutil.ints.IntSortedSet;
import org.oilmod.api.rep.itemstack.ItemStackConsumerRep;
import org.oilmod.api.rep.itemstack.ItemStackRep;
import org.oilmod.api.util.checkstate.ICheckState;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.IntPredicate;
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
    boolean check(IIngredientAccessor accessor, ICheckState checkState, int slotId, int slotCount, IntPredicate disclaimer, IntPredicate reclaimer);

    /**
     * Must be called at least once and return true during matching process. May be called multiple times and before @ref{this.check}
     */
    default boolean confirmState(IIngredientSupplier supplier, @Nullable IntSortedSet slots, int current, int needed, ICheckState checkState, IntPredicate disclaimer) {
        return current == needed;
    }

    int consume(IIngredientAccessor accessor, int slotId, ItemStackConsumerRep stackConsumer, int multiplier, ICheckState checkState, boolean simulate); //todo, we should move slotId as that should be handled by the accessor instead!

    /**
     * @return true if and only if so far no state existed
     */
    default boolean resetCheckState(ICheckState checkState) {
        return true;
    }

    default boolean isEmpty() {
        return false;
    }

    /**
     * @return true if matcher is only able to match 1! item/item variant
     */
    boolean isStatic();
    /**
     * @return true if matcher does not have state. that means only ever considers the current input
     */
    boolean isSingular();

    /**
     * Please also write equals and getHashCode, this allows for some shortcuts in shapeless matching
     */
    boolean equals(IIngredient that);

    /**
     * Please also write equals and getHashCode, this allows for some shortcuts in shapeless matching
     */
    int createHashCode();
}
