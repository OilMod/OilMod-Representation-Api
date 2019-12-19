package org.oilmod.api.rep.crafting;

import java.util.Collection;
import java.util.Set;

public interface ICraftingManager {
    int getIngredientCategoriesCount();
    Collection<IIngredientCategory> getIngredientCategories();
    Collection<IResultCategory> getResultCategories();
    RecipeLookupResult find(ICraftingState state, IRecipeRep... cache);
    Collection<IRecipeRep> getAllRecipes();
    void add(IRecipeRep recipe);
    void remove(IRecipeRep recipe);


}
