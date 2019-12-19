package org.oilmod.api.util.checkstate;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

import java.util.Map;

public class CheckState implements ICheckState {
    private Map<Object, IStateHolder> data = new Object2ObjectOpenHashMap<>();
    private int currentBackup = -1;
    private int maxBackup = 5; //this is a value that hopefully should never be increased as increasing it might be a very expensive operation

    @Override
    public void reset() {
        data.clear();
        currentBackup = -1;
    }

    @Override
    public <T extends IStateHolder, K> T getTag(K holder, StateHolderFactory<T, K> factory) {
        //noinspection unchecked
        return (T)data.computeIfAbsent(holder, o -> factory.create(getCurrentBackup(), getMaxBackup(), (K)o));
    }

    @Override
    public boolean hasTag(Object holder) {
        return data.containsKey(holder);
    }

    @Override
    public void backupState() {
        for (IStateHolder stateHolder:data.values()) {
            if (stateHolder.isInUse())stateHolder.backupState();
        }
        currentBackup++;
    }

    @Override
    public void revertState(int to) {
        for (IStateHolder stateHolder:data.values()) {
            if (stateHolder.isInUse())stateHolder.revertState(to);
        }
        currentBackup-=to;
    }

    @Override
    public void confirmState(int to) {
        for (IStateHolder stateHolder:data.values()) {
            if (stateHolder.isInUse())stateHolder.confirmState(to);
        }
        currentBackup-=to;
    }

    @Override
    public int getCurrentBackup() {
        return currentBackup;
    }

    @Override
    public void requireMaxBackup(int by) {
        if (maxBackup < currentBackup+by) {
            maxBackup = currentBackup+by;

            for (IStateHolder stateHolder:data.values()) {
                stateHolder.setMaxBackup(maxBackup);
            }
        }
    }

    @Override
    public int getMaxBackup() {
        return maxBackup;
    }
}
