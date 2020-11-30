package org.oilmod.api.util.checkstate.mutable;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;

public class MutableState<T> extends MutableCheckStateBase {
    private final ObjectList<T> helperList;

    private MutableState(Class<T> clazz,  int currentBackupId, int maxBackup) {
        super(currentBackupId, maxBackup);
        if (clazz.isPrimitive() || clazz == Double.class || clazz == Float.class || clazz == Long.class ||
                clazz == Integer.class || clazz == Short.class || clazz == Character.class ||
                clazz == Byte.class || clazz == Boolean.class) {
            throw new IllegalArgumentException("Please do not use this for wrapper types, instead create your own impl for the primary data type, just copy the code from MutableIntState cheers");
        }
        this.helperList = new ObjectArrayList<>(maxBackup);
    }

    public void set(T value) {
        onSet();
        helperList.set(getCurrentIndex(), value);
    }

    public T get() {
        return helperList.get(getCurrentIndex());
    }

    @Override
    protected void copy(int indexFrom, int indexTo) {
        helperList.set(indexTo, helperList.get(indexFrom));
    }

    @Override
    protected void releaseValues(int indexFrom, int indexTo) {
        helperList.removeElements(indexFrom, indexTo);
    }

    @Override
    protected void setArraySize(int size) {
        helperList.size(size);
    }
}
