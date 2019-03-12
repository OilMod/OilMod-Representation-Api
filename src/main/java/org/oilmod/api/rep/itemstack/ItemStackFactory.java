package org.oilmod.api.rep.itemstack;

import org.oilmod.api.rep.block.BlockRep;
import org.oilmod.api.rep.block.BlockStateRep;
import org.oilmod.api.rep.item.BlockItemRep;
import org.oilmod.api.rep.item.ItemRep;
import org.oilmod.api.rep.item.ItemStateRep;

public abstract class ItemStackFactory {
    public static ItemStackFactory INSTANCE;

    public ItemStackRep create(ItemRep item) {
        return create(item, 1);
    }

    public ItemStackRep create(ItemRep item, int amount) {
        return create(item, item.getStandardState(), amount);
    }

    public ItemStackRep create(ItemRep item, ItemStateRep state) {
        return create(item, state, 1);
    }
    public ItemStackRep create(ItemRep item, ItemStateRep state, int amount) {
        return create(item, createStackState(item, state), amount);
    }


    public ItemStackRep create(BlockRep block) {
        return create(block, 1);
    }

    public ItemStackRep create(BlockRep block, int amount) {
        return create(block, block.getStandardState(), amount);
    }

    public ItemStackRep create(BlockRep block, BlockStateRep state) {
        return create(block, state, 1);
    }
    public ItemStackRep create(BlockRep block, BlockStateRep state, int amount) {
        return create(block.getItem(), createStackState(block.getItem(), state), amount);
    }

    public ItemStackRep create(ItemRep item, ItemStackStateRep state) {
        return create(item, state, 1);
    }


    public abstract ItemStackRep create(ItemRep item, ItemStackStateRep state, int amount);
    public abstract ItemStackStateRep createStackState(ItemRep item, ItemStateRep itemState);
    public abstract ItemStackStateRep createStackState(BlockItemRep item, BlockStateRep itemState);
}
