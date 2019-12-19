package org.oilmod.api.util.checkstate.immutable;

import org.oilmod.api.util.checkstate.StateHolderFactory;

public class ImmutableState<T> extends ImmutableValueStateBase {
    private T value;

    public ImmutableState(Class<T> clazz){
        if (clazz.isPrimitive() || clazz == Double.class || clazz == Float.class || clazz == Long.class ||
                clazz == Integer.class || clazz == Short.class || clazz == Character.class ||
                clazz == Byte.class || clazz == Boolean.class) {
            throw new IllegalArgumentException("Please do not use this for wrapper types, instead create your own impl for the primary data type, just copy the code from ImmutableIntState cheers");
        }
    }

    @Override
    protected void reset() {
        this.value = null; //revert to std value
    }

    public void set(T value) {
        if (hasBeenSet())throw calledTwice();
        this.value = value;
    }

    public T get() {
        if (!hasBeenSet())return null;
        return value;
    }
}
