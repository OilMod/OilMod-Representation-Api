package org.oilmod.api.rep.states.implapi;


import it.unimi.dsi.fastutil.objects.ObjectRBTreeSet;
import it.unimi.dsi.fastutil.objects.ObjectSortedSet;

public class StateImplementationResolver<TImpl extends IImplementation<TImpl, TData>, TData> {
    private final StateCollector associatedStateCollector;

    //have specific ones first
    private ObjectSortedSet<TImpl> setupSet = new ObjectRBTreeSet<>((o1, o2) -> (o2.isGeneral() == o1.isGeneral() ? 0 : (o2.isGeneral() ? 1 : -1)));
    private TImpl[] implementations;

    public StateImplementationResolver(StateCollector associatedStateCollector, TImpl[] arrayExample) {
        this.associatedStateCollector = associatedStateCollector;
        this.implementations = arrayExample.clone();
        if (arrayExample.length != 0)throw new IllegalArgumentException("type example array has to be of length 0");
        //noinspection unchecked
        associatedStateCollector.addResolver(this);
    }

    public boolean isFrozen() {
        return setupSet == null;
    }

    void freeze() {
        if (isFrozen()) throw new IllegalStateException("Cannot freeze twice");
        //noinspection unchecked
        implementations = (TImpl[]) setupSet.toArray(implementations);
        setupSet = null;
    }

    public void addImplementation(TImpl impl) {
        if (isFrozen()) throw new IllegalStateException("Cannot add implementation after resolver is frozen");
        setupSet.add(impl);
    }

    public TImpl findApplicable(TData data) {
        for (TImpl impl:implementations) {
            if (impl.isApplicable(data)) return impl; //creates problem if two claim applicability and shadowed one actually has feature
        }
        throw new IllegalStateException("This is not applicable to this data holder object");
    }


    public boolean isApplicable(TData data) {
        for (TImpl impl:implementations) {
            if (impl.isApplicable(data)) return true;
        }
        return false;
    }


    public TImpl findFeature(TData data) {
        for (TImpl impl:implementations) {
            if (impl.isApplicable(data) && impl.hasFeature(data)) return impl;
        }
        return null;
    }


    public boolean hasFeature(TData data) {
        for (TImpl impl:implementations) {
            if (impl.isApplicable(data) && impl.hasFeature(data)) return true;
        }
        return false;
    }

    public StateCollector getAssociatedStateCollector() {
        return associatedStateCollector;
    }
}
