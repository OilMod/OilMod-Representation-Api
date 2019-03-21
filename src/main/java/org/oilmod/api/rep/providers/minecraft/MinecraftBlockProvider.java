package org.oilmod.api.rep.providers.minecraft;

import org.apache.commons.lang3.Validate;
import org.oilmod.api.APIBase;
import org.oilmod.api.rep.block.BlockStateRep;
import org.oilmod.api.rep.variant.Substitute;


public abstract class MinecraftBlockProvider extends APIBase {
    private static MinecraftBlockProvider instance;
    private static final Object MUTEX = new Object();
    private static final String CANNOT_INITIALISE_SINGLETON_TWICE = "Cannot initialise singleton twice!";

    public static void setInstance(MinecraftBlockProvider instance) {
        if (MinecraftBlockProvider.instance == null) {
            synchronized (MUTEX) {
                if (MinecraftBlockProvider.instance == null) {
                    MinecraftBlockProvider.instance = instance;
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
    protected abstract Substitute<BlockStateRep> getBlock(MinecraftBlock block);



    private boolean initialised;
    public static void init() {
        MinecraftBlockProvider helper = MinecraftBlockProvider.getInstance();
        Validate.notNull(helper, "MinecraftBlockProvider not implemented or set");
        if (helper.initialised)return;
        helper.apiInit();
        MinecraftBlock.values(); //will force initialisation
        helper.apiPostInit();
        helper.initialised = true;
    }

}
