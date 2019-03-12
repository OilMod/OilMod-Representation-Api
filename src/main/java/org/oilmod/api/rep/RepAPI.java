package org.oilmod.api.rep;

import org.oilmod.api.rep.itemstack.ItemStackFactory;
import org.oilmod.api.rep.providers.minecraft.MinecraftBlockProvider;
import org.oilmod.api.rep.providers.minecraft.MinecraftItem;
import org.oilmod.api.rep.providers.minecraft.MinecraftItemProvider;

public abstract class RepAPI {
    private boolean initialised;
    private  ItemStackFactory itemStackFactory;
    private MinecraftBlockProvider mcBlockProvider;
    private MinecraftItemProvider mcItemProvider;


    protected abstract ItemStackFactory createItemStackFactory();
    protected abstract MinecraftBlockProvider createMCBlockProvider();
    protected abstract MinecraftItemProvider createMCItemProvider();


    public ItemStackFactory getItemStackFactory() {
        return itemStackFactory;
    }

    public MinecraftBlockProvider getMCBlockProvider() {
        return mcBlockProvider;
    }

    public MinecraftItemProvider getMCItemProvider() {
        return mcItemProvider;
    }

    public void init() {
        if (initialised) return;
        
        createAll();
        setAll();
        initAll();
        
        initialised = true;
    }
    
    protected void createAll() {
        itemStackFactory = createItemStackFactory();
        mcBlockProvider = createMCBlockProvider();
        mcItemProvider = createMCItemProvider();
    }


    protected void setAll() {
        ItemStackFactory.INSTANCE = getItemStackFactory();
        MinecraftBlockProvider.setInstance(getMCBlockProvider());
        MinecraftItemProvider.setInstance(getMCItemProvider());
    }
    
    protected void initAll()  {
        //no itemStackFactory init currently maybe add
        MinecraftBlockProvider.init();
        MinecraftItemProvider.init();
    }

    public static void installImplementation(RepAPI repAPI) {
        repAPI.init();
    }

    //todo add api-api to avoid inter api dependence from interfering with load order. _-> flexible load order
}
