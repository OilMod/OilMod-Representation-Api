package org.oilmod.util;

import it.unimi.dsi.fastutil.ints.*;
import org.jetbrains.annotations.NotNull;

import java.util.BitSet;
import java.util.NoSuchElementException;

public class IntFixedRangeSet extends AbstractIntSortedSet {
    private final BitSet bits;
    private int size;
    private int max;

    public IntFixedRangeSet(int max, boolean insertAll) {
        this.size = insertAll?max:0;
        this.bits = new BitSet(max);
        if (insertAll)bits.set(0, max);
        this.max = max;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public IntBidirectionalIterator iterator(int fromElement) {
        return new IntBidirectionalIterator() {
            int next = bits.nextSetBit(fromElement);
            int current = next;

            @Override
            public boolean hasPrevious() {
                return next != -1;
            }

            @Override
            public int previousInt() {
                if (next != -1) {
                    current = next;
                    next = bits.previousSetBit(next -1);
                    return current;
                } else {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public int nextInt() {
                if (next != -1) {
                    current = next;
                    next = bits.nextSetBit(next +1);
                    return current;
                } else {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public boolean hasNext() {
                return next != -1;
            }

            @Override
            public void remove() {
                IntFixedRangeSet.this.remove(current);
            }
        };
    }

    @Override
    public @NotNull IntBidirectionalIterator iterator() {
        return iterator(0);
    }

    @Override
    public IntSortedSet subSet(int fromElement, int toElement) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IntSortedSet headSet(int toElement) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IntSortedSet tailSet(int fromElement) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IntComparator comparator() {
        return IntComparators.NATURAL_COMPARATOR;
    }

    @Override
    public int firstInt() {
        if (size == 0)throw new NoSuchElementException();
        return bits.nextSetBit(0);
    }

    @Override
    public int lastInt() {
        if (size == 0)throw new NoSuchElementException();
        return bits.previousSetBit(size);
    }

    @Override
    public boolean contains(int k) {
        if (k >= max || k < 0)return false;
        return bits.get(k);
    }

    @Override
    public boolean add(int k) {
        if (k >= max) throw new UnsupportedOperationException("Cannot add item outside of range!");
        if(bits.get(k)) return true;
        bits.set(k);
        size++;
        return false;
    }

    @Override
    public boolean remove(int k) {
        if (k >= max) throw new UnsupportedOperationException("Cannot remove item outside of range!");
        if(!bits.get(k)) return false;
        bits.clear(k);
        size--;
        return true;
    }

    @Override
    public void clear() {
        bits.clear();
        size = 0;
    }
}
