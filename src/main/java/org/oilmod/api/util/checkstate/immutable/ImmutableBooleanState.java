package org.oilmod.api.util.checkstate.immutable;

import org.oilmod.api.util.checkstate.ArrayState;
import org.oilmod.api.util.checkstate.StateHolderFactory;

public class ImmutableBooleanState extends ImmutableValueStateBase {
    public static final StateHolderFactory<ImmutableBooleanState, Object> FACTORY = (currentBackup, maxBackup, key) -> new ImmutableBooleanState();
    public static final StateHolderFactory<ArrayState<ImmutableBooleanState>, Object> FACTORY_ARRAY = (currentBackup, maxBackup, key) -> new ArrayState<>(FACTORY, ImmutableBooleanState[]::new, maxBackup);
    private boolean value;


    public ImmutableBooleanState(){}

    @Override
    protected void reset() {
        this.value = false; //revert to std value
    }

    public void set(boolean value) {
        if (hasBeenSet())throw calledTwice();
        this.value = value;
        beenSet();
    }

    public boolean get() {
        if (!hasBeenSet())return false;
        return value;
    }
}
