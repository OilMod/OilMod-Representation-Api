package org.oilmod.api.rep.crafting;

public interface ICraftingState {
    IIngredientSupplier getIngredients(IIngredientCategory category);
    int getSupplierCount();

    IRecipeRep getRecipe();

}
