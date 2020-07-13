package org.oilmod.api.util.checkstate.immutable;

import org.oilmod.api.util.checkstate.StateHolderFactory;

public class ImmutableIntState extends ImmutableValueStateBase {
    public static final StateHolderFactory<ImmutableIntState, Object> FACTORY = (currentBackup, maxBackup, key) -> new ImmutableIntState();
    private int value;


    public ImmutableIntState(){}

    @Override
    protected void reset() {
        this.value = 0; //revert to std value
    }

    public void set(int value) {
        if (hasBeenSet())throw calledTwice();
        this.value = value;
        beenSet();
    }

    public int get() {
        if (!hasBeenSet())return 0;
        return value;
    }
}
