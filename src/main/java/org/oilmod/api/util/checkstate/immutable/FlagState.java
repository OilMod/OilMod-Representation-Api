package org.oilmod.api.util.checkstate.immutable;

import org.oilmod.api.util.checkstate.StateHolderFactory;

public class FlagState extends ImmutableValueStateBase {
    public static final StateHolderFactory<FlagState, Object> FACTORY = (currentBackup, maxBackup, key) -> new FlagState();



    private FlagState(){}

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
