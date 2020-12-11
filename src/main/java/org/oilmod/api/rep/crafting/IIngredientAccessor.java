package org.oilmod.api.rep.crafting;

import org.oilmod.api.rep.itemstack.ItemStackConsumerRep;
import org.oilmod.api.rep.itemstack.ItemStackRep;
import org.oilmod.api.rep.itemstack.state.ItemStackStateRep;
import org.oilmod.api.rep.providers.ItemStackStateProvider;

public interface IIngredientAccessor {
    int getIndex();
    int getLeft();
    int getTop();
    ItemStackStateProvider getItemState();
    int use(int amount, boolean simulate);
    int use(int amount, ItemStackStateProvider replaceWith, ItemStackConsumerRep stackConsumer, boolean simulate);
    int getSameMatched(int requested);
    int getTotalMatched(int requested);
    boolean isEmpty();
}
