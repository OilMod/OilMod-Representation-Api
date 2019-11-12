package org.oilmod.api.rep.states.implapi;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import it.unimi.dsi.fastutil.objects.ObjectSets;

import java.util.Set;
import java.util.stream.Collectors;

public class StateCollector<TData> {
    private final ObjectSet<StateImplementationResolver<? extends IImplementation<?, TData>, TData>> resolvers = new ObjectOpenHashSet<>();
    private final Set<StateImplementationResolver<? extends IImplementation<?, TData>, TData>> resolversReadOnly = ObjectSets.unmodifiable(resolvers);

    void addResolver(StateImplementationResolver<? extends IImplementation<?, TData>, TData> resolver) {
        resolvers.add(resolver);
    }

    public void freeze() {
        resolvers.forEach(StateImplementationResolver::freeze);
    }

    public Set<StateImplementationResolver<? extends IImplementation<?, TData>, TData>> getAllResolver() {
        return resolversReadOnly;
    }

    public Set<StateImplementationResolver<? extends IImplementation<?, TData>, TData>> getAllApplicableResolvers(TData data) {
        return resolvers.stream().filter(r -> r.isApplicable(data)).collect(Collectors.toSet());
    }

    public Set<IImplementation<?, TData>> getAllApplicableImplementations(TData data) {
        return resolvers.stream().filter(r -> r.isApplicable(data)).map(r -> r.findApplicable(data)).collect(Collectors.toSet());
    }

    public Set<StateImplementationResolver<? extends IImplementation<?, TData>, TData>> getAllResolverForWhichDataHasFeature(TData data) {
        return resolvers.stream().filter(r -> r.hasFeature(data)).collect(Collectors.toSet());
    }

    public Set<IImplementation<?, TData>> getAllImplementationsForWhichDataHasFeature(TData data) {
        return resolvers.stream().filter(r -> r.hasFeature(data)).map(r -> r.findFeature(data)).collect(Collectors.toSet());
    }

    public void apply(TData from, TData to, boolean additive, boolean force) {
        resolvers.stream().filter(r -> r.hasFeature(from) && (!force || r.isApplicable(to))).
                forEach(r -> r.findFeature(from).apply(from, to, additive, force));
    }
}
