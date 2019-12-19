package org.oilmod.api.util.checkstate;

public interface ICheckState {
    void reset();
    <T extends IStateHolder,K> T getTag(K holder, StateHolderFactory<T, K> factory);
    boolean hasTag(Object holder);
    void backupState();
    /**
     * will dispose all backups after getCurrentBackup()-to
     * @param by
     */
    void revertState(int by);
    default void revertState() {revertState(1);}

    /**
     * will dispose all backups after getCurrentBackup()-to and replace getCurrentBackup()-by with the current head
     * @param by
     */
    void confirmState(int by);
    default void confirmState() {confirmState(1);}

    int getCurrentBackup();

    /**
     * will set the maximum backup to Math.max(getMaxBackup(), getCurrentBackup()+to)
     * @param by
     */
    void requireMaxBackup(int by);
    int getMaxBackup();
}
