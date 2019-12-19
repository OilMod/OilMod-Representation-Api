package org.oilmod.api.rep.crafting;

import org.oilmod.api.rep.itemstack.ItemStackRep;
import org.oilmod.api.util.checkstate.ICheckState;

public interface IResult {
    ItemStackRep getResult(ICraftingState state, ICheckState checkState);
}
