package org.oilmod.api.rep.itemstack.state;

import org.oilmod.api.rep.itemstack.ItemStackFactory;
import org.oilmod.api.rep.providers.ItemStackStateProvider;
import org.oilmod.api.rep.states.implapi.ImplementationBase;
import org.oilmod.api.rep.states.implapi.StateImplementationResolver;

public class Durability {
    public final static StateImplementationResolver<DurabilityHelper, ItemStackStateRep> RESOLVER = new StateImplementationResolver<>(ItemStackFactory.STATE_COLLECTOR, new DurabilityHelper[]{});

    public static void setDamage(ItemStackStateProvider stateProv, int durability) {
        ItemStackStateRep state = stateProv.getProvidedItemStackState();
        RESOLVER.findApplicable(state).setDamage(state, durability);
    }
    public static int getDamage(ItemStackStateProvider stateProv) {
        ItemStackStateRep state = stateProv.getProvidedItemStackState();
        return RESOLVER.findApplicable(state).getDamage(state);
    }

    public static int getMaxDamage(ItemStackStateProvider stateProv) {
        ItemStackStateRep state = stateProv.getProvidedItemStackState();
        return RESOLVER.findApplicable(state).getMaxDamage(state);
    }

    public abstract static class DurabilityHelper extends ImplementationBase<DurabilityHelper, ItemStackStateRep> {

        protected abstract void setDamage(ItemStackStateRep state, int durability);
        protected abstract int getDamage(ItemStackStateRep state);
        protected abstract int getMaxDamage(ItemStackStateRep state);


        @Override
        public void apply(ItemStackStateRep from, ItemStackStateRep to, DurabilityHelper toImpl, boolean additive, boolean force) {
            toImpl.setDamage(to, getDamage(from));
        }
    }
}
