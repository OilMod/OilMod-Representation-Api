package org.oilmod.api.rep.providers.minecraft;

import org.oilmod.api.rep.block.BlockRep;
import org.oilmod.api.rep.block.BlockStateRep;
import org.oilmod.api.rep.item.ItemRep;
import org.oilmod.api.rep.variant.Substitute;


public abstract class MinecraftBlockProvider {
    private static MinecraftBlockProvider instance;
    private static final Object MUTEX = new Object();
    private static final String CANNOT_INITIALISE_SINGLETON_TWICE = "Cannot initialise singleton twice!";

    public static void setInstance(MinecraftBlockProvider instance) {
        if (MinecraftBlockProvider.instance == null) {
            synchronized (MUTEX) {
                if (MinecraftBlockProvider.instance == null) {
                    MinecraftBlockProvider.instance = instance;
                    MinecraftBlockProvider.init();
                } else {
                    throw new IllegalStateException(CANNOT_INITIALISE_SINGLETON_TWICE);
                }
            }
        } else {
            throw new IllegalStateException(CANNOT_INITIALISE_SINGLETON_TWICE);
        }
    }

    public static MinecraftBlockProvider getInstance() {
        return instance;
    }
    protected abstract void apiInit(); //prepare stuff
    protected abstract void apiPostInit(); //register missing and so on
    protected abstract Substitute<BlockStateRep> getBlock(MinecraftBlock block);



    private static void init() {
        MinecraftBlockProvider helper = MinecraftBlockProvider.getInstance();
        helper.apiInit();
        MinecraftBlock.values(); //will force initialisation
        helper.apiPostInit();
    }

}
