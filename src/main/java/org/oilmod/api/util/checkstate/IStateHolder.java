package org.oilmod.api.util.checkstate;

public interface IStateHolder {
    void backupState();
    /**
     * will dispose all backups after getCurrentBackup()-by
     * @param by
     */
    void revertState(int by);

    /**
     * will dispose all backups after getCurrentBackup()-to and replace getCurrentBackup()-by with the current head
     * @param by
     */
    void confirmState(int by);
    void setMaxBackup(int to);
    boolean isInUse();
}
