package org.oilmod.api.util.checkstate.mutable;

import it.unimi.dsi.fastutil.booleans.BooleanArrayList;
import it.unimi.dsi.fastutil.booleans.BooleanList;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import org.oilmod.api.util.checkstate.ArrayState;
import org.oilmod.api.util.checkstate.StateHolderFactory;
import org.oilmod.api.util.checkstate.immutable.FlagState;

public class MutableBooleanState extends MutableCheckStateBase {
    public static final StateHolderFactory<MutableBooleanState, Object> FACTORY = (currentBackup, maxBackup, key) -> new MutableBooleanState(currentBackup, maxBackup);
    public static final StateHolderFactory<ArrayState<MutableBooleanState>, Object> FACTORY_ARRAY = (currentBackup, maxBackup, key) -> new ArrayState<>(FACTORY, MutableBooleanState[]::new, maxBackup);
    private final BooleanList helperList;

    private MutableBooleanState(int currentBackupId, int maxBackup) {
        super(currentBackupId, maxBackup);
        this.helperList = new BooleanArrayList(maxBackup);
    }

    public void set(boolean value) {
        onSet();
        helperList.set(getCurrentIndex(), value);
    }

    public boolean get() {
        return helperList.getBoolean(getCurrentIndex());
    }

    @Override
    protected void copy(int indexFrom, int indexTo) {
        helperList.set(indexTo, helperList.getBoolean(indexFrom));
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
