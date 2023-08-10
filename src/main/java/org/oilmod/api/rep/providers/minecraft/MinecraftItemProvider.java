package org.oilmod.api.rep.providers.minecraft;

import org.apache.commons.lang3.Validate;
import org.oilmod.api.APIBase;
import org.oilmod.api.rep.block.BlockRep;
import org.oilmod.api.rep.item.ItemRep;
import org.oilmod.api.rep.item.ItemStateRep;
import org.oilmod.api.rep.variant.Substitute;


public abstract class MinecraftItemProvider extends APIBase {
    private static MinecraftItemProvider instance;
    private static final Object MUTEX = new Object();
    private static final String CANNOT_INITIALISE_SINGLETON_TWICE = "Cannot initialise singleton twice!";

    public static void setInstance(MinecraftItemProvider instance) {
        if (MinecraftItemProvider.instance == null) {
            synchronized (MUTEX) {
                if (MinecraftItemProvider.instance == null) {
                    MinecraftItemProvider.instance = instance;
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
    protected abstract Substitute<ItemStateRep> getItem(MinecraftItem item);


    private boolean initialised;
    public static void init() {
        MinecraftItemProvider helper = MinecraftItemProvider.getInstance();
        Validate.notNull(helper, "MinecraftItemProvider not implemented or set");
        if (helper.initialised)return;
        helper.apiInit();
        MinecraftItem.initAll(); //will force initialisation
        helper.apiPostInit();
        helper.initialised = true;
    }

}
