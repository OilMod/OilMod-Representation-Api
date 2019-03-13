package org.oilmod.api.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;

public class ConvertedReadSet<To,From> implements ReadSet<To> {
    private final Set<From> internal;
    private final Function<From,To> converter;
    private final Function<To,From> converterBack;

    public ConvertedReadSet(Set<From> internal, Function<From, To> converter, Function<To, From> converterBack) {
        this.internal = internal;
        this.converter = converter;
        this.converterBack = converterBack;
    }

    @Override
    public int size() {
        return internal.size();
    }

    @Override
    public boolean isEmpty() {
        return internal.isEmpty();
    }

    @Override
    public boolean contains(To o) {
        return internal.contains(converterBack.apply(o));
    }

    @Override
    public boolean containsAll(Collection<To> c) {
        return internal.stream().map(converter).allMatch(c::contains);
    }

    @Override
    public Iterator<To> iterator() {
        return internal.stream().map(converter).iterator();
    }

    @Override
    public int hashCode() {
        return internal.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Collection) {
            return internal.containsAll((Collection<?>) obj) || containsAll((Collection<To>) obj);
        }
        return super.equals(obj);
    }
}
