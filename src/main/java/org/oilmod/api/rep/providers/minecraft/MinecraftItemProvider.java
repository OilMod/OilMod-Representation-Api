package org.oilmod.api.rep.providers.minecraft;

import org.oilmod.api.rep.block.BlockRep;
import org.oilmod.api.rep.item.ItemRep;


public abstract class MinecraftItemProvider {
    private static MinecraftItemProvider instance;
    private static final Object MUTEX = new Object();
    private static final String CANNOT_INITIALISE_SINGLETON_TWICE = "Cannot initialise singleton twice!";

    public static void setInstance(MinecraftItemProvider instance) {
        if (MinecraftItemProvider.instance == null) {
            synchronized (MUTEX) {
                if (MinecraftItemProvider.instance == null) {
                    MinecraftItemProvider.instance = instance;
                    MinecraftItemProvider.init();
                } else {
                    throw new IllegalStateException(CANNOT_INITIALISE_SINGLETON_TWICE);
                }
            }
        } else {
            throw new IllegalStateException(CANNOT_INITIALISE_SINGLETON_TWICE);
        }
    }

    public static MinecraftItemProvider getInstance() {
        return instance;
    }
    protected abstract void apiInit(); //prepare stuff
    protected abstract void apiPostInit(); //register missing and so on
    protected abstract ItemRep getItem(MinecraftItem item);




    private static void init() {
        MinecraftItemProvider helper = MinecraftItemProvider.getInstance();
        helper.apiInit();
        MinecraftItem.values(); //will force initialisation
        helper.apiPostInit();
    }

}
