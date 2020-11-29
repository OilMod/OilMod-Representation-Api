package org.oilmod.api.rep.providers;

import org.oilmod.api.rep.block.BlockStateRep;
import org.oilmod.api.rep.itemstack.ItemStackFactory;
import org.oilmod.api.rep.itemstack.ItemStackRep;
import org.oilmod.api.rep.itemstack.state.ItemStackStateRep;

public interface ItemStackStateProvider {
    ItemStackStateRep getProvidedItemStackState();


    default ItemStackRep createStack(int amount) {
        return ItemStackFactory.INSTANCE.create(this.getProvidedItemStackState().getProvidedItem(), this.getProvidedItemStackState(), amount);
    }
}
