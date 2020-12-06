package org.oilmod.api.rep.crafting;

import it.unimi.dsi.fastutil.ints.IntSortedSet;
import org.oilmod.api.rep.itemstack.ItemStackConsumerRep;
import org.oilmod.api.rep.itemstack.ItemStackFactory;
import org.oilmod.api.rep.itemstack.ItemStackRep;
import org.oilmod.api.util.checkstate.ICheckState;

import java.util.Collections;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

public final class EmptyIngredient implements IIngredient {

    EmptyIngredient(){}

    @Override
    public Supplier<ItemStackRep> getExampleSupplier() {
        return ItemStackFactory::empty;
    }

    @Override
    public List<ItemStackRep> getExamples() {
        return Collections.singletonList(ItemStackFactory.empty());
    }


    @Override
    public boolean check(IIngredientAccessor accessor, ICheckState checkState, int slotId, int slotCount, IntPredicate disclaimer, IntPredicate reclaimer) {
        return accessor.isEmpty();
    }

    @Override
    public boolean confirmState(IIngredientSupplier supplier, IntSortedSet slots, int current, int needed, ICheckState checkState, IntPredicate disclaimer) {
        return true;
    }

    @Override
    public int consume(IIngredientAccessor accessor, int slotId, ItemStackConsumerRep stackConsumer, int multiplier, ICheckState checkState, boolean simulate) {
        return multiplier;
    }

    @Override
    public boolean resetCheckState(ICheckState checkState) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean isStatic() {
        return true;
    }

    @Override
    public boolean isSingular() {
        return true;
    }

    @Override
    public boolean equals(IIngredient that) {
        return that == IIngredient.EMPTY;
    }

    @Override
    public int createHashCode() {
        return hashCode();
    }
}
