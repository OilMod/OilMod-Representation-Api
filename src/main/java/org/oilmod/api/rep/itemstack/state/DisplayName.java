package org.oilmod.api.rep.itemstack.state;

import org.oilmod.api.rep.itemstack.ItemStackFactory;
import org.oilmod.api.rep.providers.ItemStackStateProvider;
import org.oilmod.api.rep.states.implapi.ImplementationBase;
import org.oilmod.api.rep.states.implapi.StateImplementationResolver;

public class DisplayName {
    public final static StateImplementationResolver<DisplayName.DisplayNameHelper, ItemStackStateRep> RESOLVER = new StateImplementationResolver<>(ItemStackFactory.getStateCollector(), new DisplayName.DisplayNameHelper[]{});

    public static void set(ItemStackStateProvider stateProv, String displayName) {
        ItemStackStateRep state = stateProv.getProvidedItemStackState();
        RESOLVER.findApplicable(state).set(state, displayName);
    }
    public static String get(ItemStackStateProvider stateProv) {
        ItemStackStateRep state = stateProv.getProvidedItemStackState();
        return RESOLVER.findApplicable(state).get(state);
    }

    public abstract static class DisplayNameHelper extends ImplementationBase<DisplayName.DisplayNameHelper, ItemStackStateRep> {

        protected abstract void set(ItemStackStateRep state, String displayName);
        protected abstract String get(ItemStackStateRep state);


        @Override
        public void apply(ItemStackStateRep from, ItemStackStateRep to, DisplayName.DisplayNameHelper toImpl, boolean additive, boolean force) {
            toImpl.set(to, get(from));
        }
    }
}
