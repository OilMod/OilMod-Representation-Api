package org.oilmod.api.util.checkstate.immutable;

import org.oilmod.api.util.checkstate.ArrayState;
import org.oilmod.api.util.checkstate.StateHolderFactory;

public class FlagState extends ImmutableValueStateBase {
    public static final StateHolderFactory<FlagState, Object> FACTORY = (currentBackup, maxBackup, key) -> new FlagState();
    public static final StateHolderFactory<FlagArrayState, Object> FACTORY_ARRAY = (currentBackup, maxBackup, key) -> new FlagArrayState(maxBackup);

    public static class FlagArrayState extends ArrayState<FlagState> {
        public FlagArrayState(int maxBackup) {
            super(FACTORY, FlagState[]::new, maxBackup);
        }


        public boolean hasFlag(int index) {
            return hasState(index) && getOrCreateState(index).hasFlag();
        }

        public void setFlag(int index) {
            getOrCreateState(index).setFlag();
        }

    }

    public FlagState(){}

    @Override
    protected void reset() {
    }

    public boolean hasFlag() {
        return hasBeenSet();
    }

    public void setFlag() {
        beenSet();
    }

}
