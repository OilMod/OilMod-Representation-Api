package org.oilmod.api.rep.inventory;

import org.oilmod.api.rep.block.BlockRep;
import org.oilmod.api.rep.block.BlockStateRep;
import org.oilmod.api.rep.item.BlockItemRep;
import org.oilmod.api.rep.item.ItemRep;
import org.oilmod.api.rep.item.ItemStateRep;
import org.oilmod.api.rep.itemstack.ItemStackFactory;
import org.oilmod.api.rep.itemstack.ItemStackRep;
import org.oilmod.api.rep.itemstack.state.Inventory;
import org.oilmod.api.rep.itemstack.state.ItemStackStateRep;
import org.oilmod.api.rep.states.implapi.StateCollector;
import org.oilmod.api.rep.stdimpl.itemstack.state.ItemStackStateImpl;
import org.oilmod.spi.mpi.SingleMPI;
import org.oilmod.spi.provider.ImplementationBase;

public abstract class InventoryFactory <Impl extends InventoryFactory<Impl>> extends ImplementationBase<InventoryFactory.InventoryFactoryMPI, InventoryFactory<?>, Impl> {

    public static class InventoryFactoryMPI extends SingleMPI<InventoryFactory.InventoryFactoryMPI, InventoryFactory<?>> {

        @Override
        protected void onSetProvider(InventoryFactory<?> provider) {
            INSTANCE = provider;
        }
    }

    public static StateCollector<ItemStackStateRep> STATE_COLLECTOR = new StateCollector<>();
    public static InventoryFactory INSTANCE;

    public abstract InventoryRep createHeadlessInventory(int size);
    public abstract InventoryRep createHeadlessInventory(int height, int width);

    //public abstract void resizeInventory(InventoryRep inv, int size);
    //public abstract void resizeInventory(InventoryRep inv, int height, int width);

    protected abstract MirrorSizedInventoryRep createFixedSizeMirrorer1d(InventoryRep inv);
    protected abstract MirrorSizedInventoryRep createFixedSizeMirrorer2d(InventoryRep inv);

}
