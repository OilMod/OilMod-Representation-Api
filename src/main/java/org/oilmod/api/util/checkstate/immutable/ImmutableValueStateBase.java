package org.oilmod.api.util.checkstate.immutable;

import org.oilmod.api.util.checkstate.IStateHolder;

public abstract class ImmutableValueStateBase implements IStateHolder {
    private int currentBackup = -1;
    private int setFlagBackup = Integer.MAX_VALUE;



    protected ImmutableValueStateBase(){}



    @Override
    public void backupState() {
        currentBackup++;
    }

    @Override
    public void revertState(int by) {
        currentBackup -= by;
        if (!hasBeenSet()) {
            setFlagBackup = Integer.MAX_VALUE;
        }
    }

    @Override
    public void confirmState(int by) {
        currentBackup -= by;
        setFlagBackup = Math.min(currentBackup, setFlagBackup);
    }

    @Override
    public void setMaxBackup(int to) {}

    @Override
    public boolean isInUse() {
        return hasBeenSet();
    }

    protected void beenSet() {
        if (!hasBeenSet()) {
            setFlagBackup = currentBackup;
        }
    }

    protected boolean hasBeenSet() {
        return setFlagBackup>=currentBackup;
    }

    protected int getCurrentBackup() {
        return currentBackup;
    }

    protected int getSetFlagBackup() {
        return setFlagBackup;
    }

    protected abstract void reset();

    protected RuntimeException calledTwice() {
        return new IllegalStateException("Cannot set immutable state (set has been called twice");
    }
}
