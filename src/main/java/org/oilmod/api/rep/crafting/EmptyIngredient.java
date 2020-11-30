package org.oilmod.api.rep.crafting;

import org.oilmod.api.rep.itemstack.ItemStackConsumerRep;
import org.oilmod.api.rep.itemstack.ItemStackFactory;
import org.oilmod.api.rep.itemstack.ItemStackRep;
import org.oilmod.api.util.checkstate.ICheckState;

import java.util.Collections;
import java.util.List;
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
    public boolean check(ItemStackRep rep, ICheckState checkState, int slotId) {
        return rep.isEmpty();
    }

    @Override
    public int consume(ItemStackRep rep, int slotId, ItemStackConsumerRep stackConsumer, int multiplier, int maxStack, ICheckState checkState, boolean simulate) {
        return multiplier;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }
}
