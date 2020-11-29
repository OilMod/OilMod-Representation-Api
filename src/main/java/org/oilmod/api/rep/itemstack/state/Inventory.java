package org.oilmod.api.rep.itemstack.state;

import org.oilmod.api.rep.inventory.InventoryRep;
import org.oilmod.api.rep.itemstack.ItemStackFactory;
import org.oilmod.api.rep.itemstack.ItemStackRep;
import org.oilmod.api.rep.providers.ItemStackStateProvider;
import org.oilmod.api.rep.states.implapi.ImplementationBase;
import org.oilmod.api.rep.states.implapi.StateImplementationResolver;

public class Inventory {
    public final static StateImplementationResolver<InventoryHelper, ItemStackStateRep> RESOLVER = new StateImplementationResolver<>(ItemStackFactory.INSTANCE.STATE_COLLECTOR , new InventoryHelper[]{});

    public static InventoryRep get(ItemStackStateProvider stateProv) {
        ItemStackStateRep state = stateProv.getProvidedItemStackState();
        return RESOLVER.findApplicable(state).get(state);
    }

    public abstract static class InventoryHelper extends ImplementationBase<InventoryHelper, ItemStackStateRep> {

        protected abstract InventoryRep get(ItemStackStateRep state);


        @Override
        public void apply(ItemStackStateRep from, ItemStackStateRep to, InventoryHelper toImpl, boolean additive, boolean force) {
            InventoryRep i1 = get(from);
            InventoryRep i2 = toImpl.get(to);
            int max = Math.min(i1.getSize(), i2.getSize());
            for (int i = 0; i < max; i++) {
                ItemStackRep stack = i1.getStored(i);
                if (!stack.isEmpty() || additive) {
                    i2.setStored(i, stack.copy());
                }
            }
        }
    }
}
