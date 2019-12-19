package org.oilmod.api.util.checkstate;

@FunctionalInterface
public interface StateHolderFactory<T extends IStateHolder, K>{
    T create(int currentBackup, int maxBackup, K key);
}
