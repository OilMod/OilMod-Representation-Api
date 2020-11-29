package org.oilmod.api.rep.providers;

import org.oilmod.api.rep.block.BlockStateRep;
import org.oilmod.api.rep.item.ItemStateRep;
import org.oilmod.api.rep.itemstack.ItemStackFactory;
import org.oilmod.api.rep.itemstack.ItemStackRep;

public interface ItemStateProvider {
    ItemStateRep getProvidedItemState();


    default ItemStackRep createStack(int amount) {
        return ItemStackFactory.INSTANCE.create(this.getProvidedItemState().getProvidedItem(), this.getProvidedItemState(), amount);
    }
}
