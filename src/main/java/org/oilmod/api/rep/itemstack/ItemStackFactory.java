package org.oilmod.api.rep.itemstack;

import org.oilmod.api.rep.block.BlockRep;
import org.oilmod.api.rep.block.BlockStateRep;
import org.oilmod.api.rep.item.BlockItemRep;
import org.oilmod.api.rep.item.ItemRep;
import org.oilmod.api.rep.item.ItemStateRep;
import org.oilmod.api.rep.itemstack.state.ItemStackStateRep;
import org.oilmod.api.rep.states.implapi.StateCollector;
import org.oilmod.api.rep.stdimpl.itemstack.state.ItemStackStateImpl;
import org.oilmod.spi.mpi.SingleMPI;
import org.oilmod.spi.provider.ImplementationBase;

public final class ItemStackFactory {
    public static Provider<?> getProvider() {
        return MPI.INSTANCE.getProvider();
    }

    public static StateCollector<ItemStackStateRep> getStateCollector() {
        return getProvider().STATE_COLLECTOR;
    }
    //this should use the MPI, also make methods static
    
    public static class MPI extends SingleMPI<MPI, Provider<?>> {
        private static MPI INSTANCE;

        @Override
        public void allDepResolved() {
            INSTANCE = this;
        }
    }


    public static abstract class Provider<Impl extends Provider<Impl>> extends ImplementationBase<MPI, Provider<?>, Impl> {

        private StateCollector<ItemStackStateRep> STATE_COLLECTOR = createStateCollector();

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

        public ItemStackStateRep cloneStackState(ItemStackStateRep state) {
            return new ItemStackStateImpl(state);
        }

        public abstract ItemStackRep create(ItemRep item, ItemStackStateRep state, int amount);
        public abstract ItemStackRep empty();
        public abstract ItemStackStateRep createStackState(ItemRep item, ItemStateRep itemState);
        public abstract ItemStackStateRep createStackState(BlockItemRep item, BlockStateRep itemState);
        protected abstract StateCollector<ItemStackStateRep> createStateCollector();
    }

    public static ItemStackRep create(ItemRep item) {
        return getProvider().create(item);
    }

    public static ItemStackRep create(ItemRep item, int amount) {
        return getProvider().create(item, amount);
    }

    public static ItemStackRep create(ItemRep item, ItemStateRep state) {
        return getProvider().create(item, state);
    }
    public static ItemStackRep create(ItemRep item, ItemStateRep state, int amount) {
        return getProvider().create(item, state, amount);
    }

    public static ItemStackRep create(BlockRep block) {
        return getProvider().create(block);
    }

    public static ItemStackRep create(BlockRep block, int amount) {
        return getProvider().create(block, amount);
    }

    public static ItemStackRep create(BlockRep block, BlockStateRep state) {
        return getProvider().create(block, state);
    }
    public static ItemStackRep create(BlockRep block, BlockStateRep state, int amount) {
        return getProvider().create(block, state, amount);
    }

    public static ItemStackRep create(ItemRep item, ItemStackStateRep state) {
        return getProvider().create(item, state);
    }

    public static ItemStackRep create(ItemRep item, ItemStackStateRep state, int amount) {
        return getProvider().create(item, state, amount);
    }

    public static ItemStackRep empty() {
        return getProvider().empty();
    }

    public static ItemStackStateRep createStackState(ItemRep item, ItemStateRep itemState) {
        return getProvider().createStackState(item, itemState);
    }

    public static ItemStackStateRep createStackState(BlockItemRep item, BlockStateRep itemState) {
        return getProvider().createStackState(item, itemState);
    }

    public static ItemStackStateRep cloneStackState(ItemStackStateRep state) {
        return getProvider().cloneStackState(state);
    }

}
