package org.oilmod.api.util.checkstate;

import org.apache.commons.lang3.Validate;
import org.oilmod.api.util.checkstate.immutable.ImmutableState;
import org.oilmod.api.util.checkstate.immutable.ImmutableValueStateBase;
import org.oilmod.api.util.checkstate.mutable.MutableIntState;

import java.util.function.Function;
import java.util.function.IntFunction;

import static org.oilmod.util.LamdbaCastUtils.cast;

public class ArrayState<Base extends IStateHolder> extends ImmutableValueStateBase {
    private final StateHolderFactory<Base, Object> baseFactory;
    private final IntFunction<Base[]> arrayCtor;
    private Base[] array;
    private int maxBackup;

    public ArrayState(StateHolderFactory<Base, ?> baseFactory, IntFunction<Base[]> arrayCtor, int maxBackup) {
        this.baseFactory = cast(baseFactory);
        this.arrayCtor = arrayCtor;
        this.maxBackup = maxBackup;
    }

    public void assureCreated(int size) {
        if (array == null) {
            beenSet();
            array = arrayCtor.apply(size);
        } else {
            Validate.isTrue(array.length == size, "Array already exist however size do not match! current=%d, request=%d", array.length, size);
        }
    }

    public Base getOrCreateState(int index) {
        if (!hasBeenSet())throw new IllegalStateException("Array was not set yet! use assureCreated");
        Base result = array[index];
        if (result == null) {
            result = baseFactory.create(getCurrentBackup(), maxBackup, index);
            array[index] = result;
        }
        return result;
    }


    public boolean hasState(int index) {
        if (!hasBeenSet())throw new IllegalStateException("Array was not set yet! use assureCreated");
        return array[index] != null;
    }

    @Override
    protected void reset() {
        array = null;
    }

    @Override
    public void setMaxBackup(int maxBackup) {
        super.setMaxBackup(maxBackup);
        this.maxBackup = maxBackup;
        if (hasBeenSet()) for (Base current:array) {
            if (current == null)continue;
            current.setMaxBackup(maxBackup);
        }
    }

    @Override
    public void backupState() {
        super.backupState();
        if (hasBeenSet()) for (Base current:array) {
            if (current == null)continue;
            current.backupState();
        }
    }

    @Override
    public void revertState(int by) {
        super.revertState(by);
        if (hasBeenSet()) for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {
            Base current = array[i];
            if (current == null) continue;
            current.revertState(by);
            if (!current.isInUse()) {
                array[i] = null;
            }
        }
    }

    @Override
    public void confirmState(int by) {
        super.confirmState(by);
        if (hasBeenSet()) for (Base current:array) {
            if (current == null)continue;
            current.confirmState(by);
        }
    }
}
