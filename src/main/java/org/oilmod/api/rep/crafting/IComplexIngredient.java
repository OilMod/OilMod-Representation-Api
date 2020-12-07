package org.oilmod.api.rep.crafting;

import it.unimi.dsi.fastutil.ints.IntSortedSet;
import org.oilmod.api.util.checkstate.ICheckState;

import java.util.function.IntPredicate;

public interface IComplexIngredient extends IIngredient{
    boolean confirmState(IIngredientSupplier supplier, IntSortedSet slots, int current, int needed, ICheckState checkState, IntPredicate disclaimer);

    /**
     *
     * @return true if and only if so far no state existed
     */
    boolean prepareRematch(ICheckState checkState);

    /**
     * @return true if matcher is only able to match 1! item/item variant
     */
    default boolean isStatic() {
        return false;
    }

    /**
     * @return true if matcher does not have state. that means only ever considers the current input
     */
    default boolean isSingular() {
        return false;
    }

    /**
     * Please also write equals and getHashCode, this allows for some shortcuts in shapeless matching
     */
    default boolean equals(IIngredient that) {
        return equals((Object)that);
    }

    /**
     * Please also write equals and getHashCode, this allows for some shortcuts in shapeless matching
     */
    default int createHashCode() {
        return hashCode();
    }
}
