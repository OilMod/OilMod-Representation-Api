package org.oilmod.api.rep.crafting;

import org.oilmod.api.util.checkstate.ICheckState;

public interface IMatcher {
    boolean isShaped();
    boolean check(IIngredientSupplier supplier, ICheckState checkState);

    /**
     *
     * @param supplier
     * @param checkState
     * @return returns true is successful or partial as in some slots where skipped as they were empty
     */
    boolean checkPartial(IIngredientSupplier supplier, IPartialCheckState checkState);

    int getInputWidth();
    int getInputHeight();
    int getInputSize();


    //IIngredientCategory getCategory();
}
