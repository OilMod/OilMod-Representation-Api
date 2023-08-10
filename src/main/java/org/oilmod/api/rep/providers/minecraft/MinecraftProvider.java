package org.oilmod.api.rep.providers.minecraft;

import org.oilmod.api.rep.block.BlockRep;
import org.oilmod.api.rep.item.ItemRep;

import java.util.EnumMap;

public class MinecraftProvider {
    //todo these are unused?! note later: because the enum instances itself contains the provided value, which is probably an architectual flaw
    private static final EnumMap<MinecraftBlock, BlockRep> blocks = new EnumMap<>(MinecraftBlock.class);
    private static final EnumMap<MinecraftItem, BlockRep> items = new EnumMap<>(MinecraftItem.class);

    //Backing implementation
    public static abstract class MinecraftProviderHelper {
        private static MinecraftProviderHelper instance;
        private static final Object MUTEX = new Object();
        private static final String CANNOT_INITIALISE_SINGLETON_TWICE = "Cannot initialise singleton twice!";

        public static void setInstance(MinecraftProviderHelper instance) {
            if (MinecraftProviderHelper.instance == null) {
                synchronized (MUTEX) {
                    if (MinecraftProviderHelper.instance == null) {
                        MinecraftProviderHelper.instance = instance;
                        MinecraftProvider.init();
                    } else {
                        throw new IllegalStateException(CANNOT_INITIALISE_SINGLETON_TWICE);
                    }
                }
            } else {
                throw new IllegalStateException(CANNOT_INITIALISE_SINGLETON_TWICE);
            }
        }

        public static MinecraftProviderHelper getInstance() {
            return instance;
        }
        protected abstract void apiInit(); //prepare stuff
        protected abstract void apiPostInit(); //register missing and so on
        protected abstract BlockRep getBlock(MinecraftBlock block);
        protected abstract ItemRep getItem(MinecraftItem item);
    }


    private static void init() {
        MinecraftProviderHelper helper = MinecraftProviderHelper.getInstance();
        helper.apiInit();
        //TODO

        helper.apiPostInit();
    }

}
