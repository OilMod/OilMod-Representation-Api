package org.oilmod.api.rep.crafting;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CustomRecipe implements IRecipeRep {
    private final Map<IIngredientCategory, IMatcher> matchers;
    private final Map<IResultCategory, List<IResult>> results;

    public CustomRecipe(Map<IIngredientCategory, IMatcher> matchers, Map<IResultCategory, List<IResult>> results) {
        this.matchers = matchers;
        this.results = results;
    }

    @Override
    public Collection<IIngredientCategory> getIngredientCategories() {
        return matchers.keySet();
    }

    @Override
    public Collection<IResultCategory> getResultCategories() {
        return results.keySet();
    }

    @Override
    public IMatcher getMatcher(IIngredientCategory category) {
        return matchers.get(category);
    }


    @Override
    public List<IResult> getResultsCategory(IResultCategory category) {
        return results.get(category);
    }

    @Override
    public Iterator<IResult> getResultsAll() {
        return results.values().stream().flatMap(Collection::stream).iterator();
    }
}
