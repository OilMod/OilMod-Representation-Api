package org.oilmod.api.rep.states.implapi;

public interface IImplementation<TImpl extends IImplementation<TImpl, TData>, TData> {
    boolean isApplicable(TData data);
    boolean hasFeature(TData data);
    boolean isGeneral();
    default void apply(TData from, TData to, boolean additive, boolean force) {
        TImpl toImpl = getResolver().findApplicable(to);
        apply(from, to, toImpl, additive, force);
    }
    void apply(TData from, TData to, TImpl toImpl, boolean additive, boolean force);
    StateImplementationResolver<TImpl, TData> getResolver();
    void setResolver(StateImplementationResolver<TImpl, TData> resolver);
}
