package org.oilmod.api.rep.states.implapi;

//TODO this should be a specialisation of the MPI api
public abstract class ImplementationBase<TImpl extends ImplementationBase<TImpl, TData>, TData> implements IImplementation<TImpl, TData> {
    private StateImplementationResolver<TImpl, TData> resolver;

    @Override
    public StateImplementationResolver<TImpl, TData> getResolver() {
        return resolver;
    }

    @Override
    public void setResolver(StateImplementationResolver<TImpl, TData> resolver) {
        this.resolver = resolver;
    }
}
