package org.oilmod.api.util.checkstate.mutable;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import org.oilmod.api.util.checkstate.StateHolderFactory;

public class MutableIntState extends MutableCheckStateBase {
    public static final StateHolderFactory<MutableIntState, Object> FACTORY = (currentBackup, maxBackup, key) -> new MutableIntState(currentBackup, maxBackup);
    private final IntList helperList;

    private MutableIntState(int currentBackupId, int maxBackup) {
        super(currentBackupId, maxBackup);
        this.helperList = new IntArrayList(maxBackup);
    }

    public void set(int value) {
        helperList.set(getCurrentIndex(), value);
    }

    public int get() {
        return helperList.getInt(getCurrentIndex());
    }

    @Override
    protected void copy(int indexFrom, int indexTo) {
        helperList.set(indexTo, helperList.getInt(indexFrom));
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
