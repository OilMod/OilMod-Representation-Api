package org.oilmod.api.rep.crafting;

import org.oilmod.api.util.checkstate.ICheckState;

public class RecipeLookupResult {
    public final IRecipeRep recipe;
    public final ICraftingState craftingState;
    public final ICheckState checkState;

    public RecipeLookupResult(IRecipeRep recipe, ICraftingState craftingState, ICheckState checkState) {
        this.recipe = recipe;
        this.craftingState = craftingState;
        this.checkState = checkState;
    }
}
