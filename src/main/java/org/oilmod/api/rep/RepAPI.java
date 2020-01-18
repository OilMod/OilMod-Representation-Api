package org.oilmod.api.rep;

import org.oilmod.api.rep.itemstack.ItemStackFactory;
import org.oilmod.api.rep.itemstack.state.DisplayName;
import org.oilmod.api.rep.itemstack.state.Durability;
import org.oilmod.api.rep.itemstack.state.Enchantments;
import org.oilmod.api.rep.itemstack.state.Inventory;
import org.oilmod.api.rep.providers.minecraft.MinecraftBlockProvider;
import org.oilmod.api.rep.providers.minecraft.MinecraftItem;
import org.oilmod.api.rep.providers.minecraft.MinecraftItemProvider;

public abstract class RepAPI {
    private boolean initialised;
    private MinecraftBlockProvider mcBlockProvider;
    private MinecraftItemProvider mcItemProvider;
    private Enchantments.EnchantmentHelper enchantmentHelper;
    private DisplayName.DisplayNameHelper displayNameHelper;
    private Durability.DurabilityHelper durabilityHelper;
    private Inventory.InventoryHelper inventoryHelper;


    protected abstract MinecraftBlockProvider createMCBlockProvider();
    protected abstract MinecraftItemProvider createMCItemProvider();
    protected abstract  Enchantments.EnchantmentHelper createEnchantmentHelper();
    protected abstract  DisplayName.DisplayNameHelper createDisplayNameHelper();
    protected abstract  Durability.DurabilityHelper createDurabilityHelper();
    protected abstract  Inventory.InventoryHelper createInventoryHelper();


    public MinecraftBlockProvider getMCBlockProvider() {
        return mcBlockProvider;
    }

    public MinecraftItemProvider getMCItemProvider() {
        return mcItemProvider;
    }

    public Enchantments.EnchantmentHelper getEnchantmentHelper() {
        return enchantmentHelper;
    }

    public Inventory.InventoryHelper getInventoryHelper() {
        return inventoryHelper;
    }

    public DisplayName.DisplayNameHelper getDisplayNameHelper() {
        return displayNameHelper;
    }

    public Durability.DurabilityHelper getDurabilityHelper() {
        return durabilityHelper;
    }

    public void init() {
        if (initialised) return;
        
        createAll();
        setAll();
        initAll();
        freezeAPI();
        
        initialised = true;
    }
    
    protected void createAll() {
        mcBlockProvider = createMCBlockProvider();
        mcItemProvider = createMCItemProvider();
        enchantmentHelper = createEnchantmentHelper();
        displayNameHelper = createDisplayNameHelper();
        durabilityHelper = createDurabilityHelper();
        inventoryHelper = createInventoryHelper();
    }


    protected void setAll() {
        MinecraftBlockProvider.setInstance(getMCBlockProvider());
        MinecraftItemProvider.setInstance(getMCItemProvider());
        Enchantments.RESOLVER.addImplementation(getEnchantmentHelper());
        DisplayName.RESOLVER.addImplementation(getDisplayNameHelper());
        Durability.RESOLVER.addImplementation(getDurabilityHelper());
        Inventory.RESOLVER.addImplementation(getInventoryHelper());
    }
    
    protected void initAll()  {
        //no itemStackFactory init currently maybe add
        MinecraftBlockProvider.init();
        MinecraftItemProvider.init();
    }

    protected void freezeAPI() {
        ItemStackFactory.STATE_COLLECTOR.freeze();
    }

    public static void installImplementation(RepAPI repAPI) {
        repAPI.init();
    }

    //todo add api-api to avoid inter api dependence from interfering with load order. _-> flexible load order
}
