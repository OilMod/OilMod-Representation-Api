package org.oilmod.api.util;


import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class WrappedReadSet<T> implements ReadSet<T> {
    private final Set<T> internal;

    public WrappedReadSet(Set<T> internal) {
        this.internal = internal;
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
    public boolean contains(T o) {
        return internal.contains(o);
    }

    @Override
    public boolean containsAll(Collection<T> c) {
        return internal.containsAll(c);
    }

    @Override
    public Iterator<T> iterator() {
        return internal.iterator();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) || internal.equals(obj);
    }

    @Override
    public int hashCode() {
        return internal.hashCode();
    }
}
