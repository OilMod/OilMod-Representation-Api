package org.oilmod.api.rep.crafting;

import org.oilmod.api.util.checkstate.ICheckState;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public interface IRecipeRep {

    Collection<IIngredientCategory> getIngredientCategories();
    Collection<IResultCategory> getResultCategories();

    IMatcher getMatcher(IIngredientCategory category);



    List<IResult> getResultsCategory(IResultCategory category);
    Iterator<IResult> getResultsAll();

    default Iterable<IResult> asIterableResults() {
        return this::getResultsAll;
    }
}
