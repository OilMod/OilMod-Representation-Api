package org.oilmod.api.util.checkstate.mutable;

import org.oilmod.api.util.checkstate.IStateHolder;

public abstract class MutableCheckStateBase implements IStateHolder {
    private int currentBackupId;
    private int baseBackupId;
    private int maxBackup;

    public MutableCheckStateBase(int currentBackupId, int maxBackup) {
        this.currentBackupId = currentBackupId-1;
        this.baseBackupId = currentBackupId;
        this.maxBackup = maxBackup;
    }
    protected void init() {
        setMaxBackup(maxBackup);
    }

    @Override
    public void backupState() {
        copy(currentBackupId -baseBackupId, ++currentBackupId - baseBackupId);
    }

    @Override
    public void revertState(int by) {
        changeState(by, false);
        currentBackupId -= by;
    }

    @Override
    public void confirmState(int by) {
        changeState(by, true);
        currentBackupId -= by;
        baseBackupId = Math.min(currentBackupId, baseBackupId);
    }

    private void changeState(int reductionBy, boolean isConfirm) {
        int indexLower = Math.max(currentBackupId-reductionBy-baseBackupId+1, 0);
        int indexHigher = Math.max(currentBackupId-baseBackupId,0);
        if (isConfirm) {
            copy(indexHigher, indexLower);
            indexLower++;
        }
        if (indexLower <= indexHigher) {
            releaseValues(indexLower, indexHigher);
        }
    }

    @Override
    public void setMaxBackup(int to) {
        if (maxBackup<to) {
            setArraySize(to);
            maxBackup = to;
        }

    }

    @Override
    public boolean isInUse() {
        return currentBackupId>=baseBackupId;
    }

    protected int getCurrentIndex() {
        if (!isInUse()) throw new IllegalStateException("State is currently not in use, if you program a setter u must call onSet()");
        return currentBackupId-baseBackupId;
    }

    protected void onSet() {
        if (!isInUse()) {
            baseBackupId = currentBackupId;
        }
    }

    protected abstract void copy(int indexFrom, int indexTo);
    protected abstract void releaseValues(int indexFrom, int indexTo);
    protected abstract void setArraySize(int size);
}
