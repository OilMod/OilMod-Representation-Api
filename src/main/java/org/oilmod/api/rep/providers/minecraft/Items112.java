package org.oilmod.api.rep.providers.minecraft;

public class Items112 {
    private static class Req extends MC112ItemReq {
        public Req(MinecraftItem b) {
            super(b);
        }

        @Override
        public Req data(int d) {
            return (Req) super.data(d);
        }

        public Req colour(MinecraftItem i) {
            key("dye");
            int data = 0;

            switch (i) {
                case BONE_MEAL:
                case ORANGE_DYE: data++;
                case MAGENTA_DYE: data++;
                case LIGHT_BLUE_DYE: data++;
                case DANDELION_YELLOW: data++;
                case LIME_DYE: data++;
                case PINK_DYE: data++;
                case GRAY_DYE: data++;
                case CYAN_DYE: data++;
                case LIGHT_GRAY_DYE: data++;
                case PURPLE_DYE: data++;
                case LAPIS_LAZULI: data++;
                case COCOA_BEANS: data++;
                case CACTUS_GREEN: data++;
                case ROSE_RED: data++;
                case INK_SAC: data++;
                break;
                default:
                    throw new IllegalStateException(i.toString());
            }
            data(data);


            return this;
        }
    }

    public static MC112ItemReq getLinker(MinecraftItem i) {
        Req r = new Req(i);
        
        switch (i) {

            case BAT_SPAWN_EGG:
            case BLAZE_SPAWN_EGG:
            case CAVE_SPIDER_SPAWN_EGG:
            case CHICKEN_SPAWN_EGG:
            case COD_SPAWN_EGG:
            case COW_SPAWN_EGG:
            case CREEPER_SPAWN_EGG:
            case DOLPHIN_SPAWN_EGG:
            case DONKEY_SPAWN_EGG:
            case DROWNED_SPAWN_EGG:
            case ELDER_GUARDIAN_SPAWN_EGG:
            case ENDERMAN_SPAWN_EGG:
            case ENDERMITE_SPAWN_EGG:
            case EVOKER_SPAWN_EGG:
            case GHAST_SPAWN_EGG:
            case GUARDIAN_SPAWN_EGG:
            case HORSE_SPAWN_EGG:
            case HUSK_SPAWN_EGG:
            case LLAMA_SPAWN_EGG:
            case MAGMA_CUBE_SPAWN_EGG:
            case MOOSHROOM_SPAWN_EGG:
            case MULE_SPAWN_EGG:
            case OCELOT_SPAWN_EGG:
            case PARROT_SPAWN_EGG:
            case PHANTOM_SPAWN_EGG:
            case PIG_SPAWN_EGG:
            case POLAR_BEAR_SPAWN_EGG:
            case PUFFERFISH_SPAWN_EGG:
            case RABBIT_SPAWN_EGG:
            case SALMON_SPAWN_EGG:
            case SHEEP_SPAWN_EGG:
            case SHULKER_SPAWN_EGG:
            case SILVERFISH_SPAWN_EGG:
            case SKELETON_HORSE_SPAWN_EGG:
            case SKELETON_SPAWN_EGG:
            case SLIME_SPAWN_EGG:
            case SPIDER_SPAWN_EGG:
            case SQUID_SPAWN_EGG:
            case STRAY_SPAWN_EGG:
            case TROPICAL_FISH_SPAWN_EGG:
            case TURTLE_SPAWN_EGG:
            case VEX_SPAWN_EGG:
            case VILLAGER_SPAWN_EGG:
            case VINDICATOR_SPAWN_EGG:
            case WITCH_SPAWN_EGG:
            case WITHER_SKELETON_SPAWN_EGG:
            case WOLF_SPAWN_EGG:
            case ZOMBIE_HORSE_SPAWN_EGG:
            case ZOMBIE_PIGMAN_SPAWN_EGG:
            case ZOMBIE_SPAWN_EGG:
            case ZOMBIE_VILLAGER_SPAWN_EGG:
                return r.key("spawn_egg"); //todo nbt

            case INK_SAC:
            case LAPIS_LAZULI:
            case LIGHT_BLUE_DYE:
            case LIGHT_GRAY_DYE:
            case LIME_DYE:
            case DANDELION_YELLOW:
            case ROSE_RED:
            case BONE_MEAL:
            case CACTUS_GREEN:
            case COCOA_BEANS:
            case CYAN_DYE:
            case GRAY_DYE:
            case MAGENTA_DYE:
            case ORANGE_DYE:
            case PINK_DYE:
            case PURPLE_DYE:
                return r.colour(i);



            case CHARCOAL:
            case COD:
            case COD_BUCKET:
            case COOKED_COD:
            case COOKED_SALMON:
            case DEBUG_STICK:
            case DRIED_KELP:
            case ENCHANTED_GOLDEN_APPLE:
            case END_GATEWAY:
            case FIREWORK_ROCKET:
            case FIREWORK_STAR:
            case GLISTERING_MELON_SLICE:
            case HEART_OF_THE_SEA:
            case MELON_SLICE:
            case MUSIC_DISC_:
            case MUSIC_DISC_3:
            case MUSIC_DISC_BLOCKS:
            case MUSIC_DISC_CAT:
            case MUSIC_DISC_CHIRP:
            case MUSIC_DISC_FAR:
            case MUSIC_DISC_MALL:
            case MUSIC_DISC_MELLOHI:
            case MUSIC_DISC_STAL:
            case MUSIC_DISC_STRAD:
            case MUSIC_DISC_WAIT:
            case MUSIC_DISC_WARD:
            case NAUTILUS_SHELL:
            case OAK_BOAT:
            case PHANTOM_MEMBRANE:
            case POPPED_CHORUS_FRUIT:
            case PUFFERFISH:
            case PUFFERFISH_BUCKET:
            case SALMON:
            case SALMON_BUCKET:
            case SCUTE:
            case TRIDENT:
            case TROPICAL_FISH:
            case TROPICAL_FISH_BUCKET:
            case TURTLE_HELMET:

            case ACACIA_BOAT: //same
            case COMMAND_BLOCK_MINECART:
            case FURNACE_MINECART:
            case MUSHROOM_STEW:
            case APPLE:
            case ARMOR_STAND:
            case ARROW:
            case BAKED_POTATO:
            case BEEF:
            case BEETROOT:
            case BEETROOT_SEEDS:
            case BEETROOT_SOUP:
            case BIRCH_BOAT:
            case BLAZE_POWDER:
            case BLAZE_ROD:
            case BONE:
            case BOOK:
            case BOW:
            case BOWL:
            case BREAD:
            case BRICK:
            case BROWN_MUSHROOM:
            case BUCKET:
            case CARROT:
            case CARROT_ON_A_STICK:
            case CHAINMAIL_BOOTS:
            case CHAINMAIL_CHESTPLATE:
            case CHAINMAIL_HELMET:
            case CHAINMAIL_LEGGINGS:
            case CHEST_MINECART:
            case CHICKEN:
            case CHORUS_FRUIT:
            case CLAY_BALL:
            case CLOCK:
            case COAL:
            case COMPASS:
            case COOKED_BEEF:
            case COOKED_CHICKEN:
            case COOKED_MUTTON:
            case COOKED_PORKCHOP:
            case COOKED_RABBIT:
            case COOKIE:
            case DARK_OAK_BOAT:
            case DIAMOND:
            case DIAMOND_AXE:
            case DIAMOND_BOOTS:
            case DIAMOND_CHESTPLATE:
            case DIAMOND_HELMET:
            case DIAMOND_HOE:
            case DIAMOND_HORSE_ARMOR:
            case DIAMOND_LEGGINGS:
            case DIAMOND_PICKAXE:
            case DIAMOND_SHOVEL:
            case DIAMOND_SWORD:
            case DRAGON_BREATH:
            case DRAGON_EGG:
            case EGG:
            case ELYTRA:
            case EMERALD:
            case ENCHANTED_BOOK:
            case ENDER_EYE:
            case ENDER_PEARL:
            case END_CRYSTAL:
            case EXPERIENCE_BOTTLE:
            case FEATHER:
            case FERMENTED_SPIDER_EYE:
            case FILLED_MAP:
            case FIRE_CHARGE:
            case FISHING_ROD:
            case FLINT:
            case FLINT_AND_STEEL:
            case GHAST_TEAR:
            case GLASS_BOTTLE:
            case GLOWSTONE_DUST:
            case GOLDEN_APPLE:
            case GOLDEN_AXE:
            case GOLDEN_BOOTS:
            case GOLDEN_CARROT:
            case GOLDEN_CHESTPLATE:
            case GOLDEN_HELMET:
            case GOLDEN_HOE:
            case GOLDEN_HORSE_ARMOR:
            case GOLDEN_LEGGINGS:
            case GOLDEN_PICKAXE:
            case GOLDEN_SHOVEL:
            case GOLDEN_SWORD:
            case GOLD_INGOT:
            case GOLD_NUGGET:
            case GUNPOWDER:
            case HOPPER_MINECART:
            case IRON_AXE:
            case IRON_BOOTS:
            case IRON_CHESTPLATE:
            case IRON_HELMET:
            case IRON_HOE:
            case IRON_HORSE_ARMOR:
            case IRON_INGOT:
            case IRON_LEGGINGS:
            case IRON_NUGGET:
            case IRON_PICKAXE:
            case IRON_SHOVEL:
            case IRON_SWORD:
            case ITEM_FRAME:
            case JUNGLE_BOAT:
            case KNOWLEDGE_BOOK:
            case LAVA_BUCKET:
            case LEAD:
            case LEATHER:
            case LEATHER_BOOTS:
            case LEATHER_CHESTPLATE:
            case LEATHER_HELMET:
            case LEATHER_LEGGINGS:
            case LINGERING_POTION:
            case MAGMA_CREAM:
            case MAP:
            case MELON_SEEDS:
            case MILK_BUCKET:
            case MINECART:
            case MUTTON:
            case NAME_TAG:
            case NETHER_BRICK:
            case NETHER_STAR:
            case PAINTING:
            case PAPER:
            case POISONOUS_POTATO:
            case PORKCHOP:
            case POTATO:
            case POTION:
            case PRISMARINE_CRYSTALS:
            case PRISMARINE_SHARD:
            case PUMPKIN_PIE:
            case PUMPKIN_SEEDS:
            case QUARTZ:
            case RABBIT:
            case RABBIT_FOOT:
            case RABBIT_HIDE:
            case RABBIT_STEW:
            case REDSTONE:
            case ROTTEN_FLESH:
            case SADDLE:
            case SHEARS:
            case SHIELD:
            case SHULKER_SHELL:
            case SLIME_BALL:
            case SNOWBALL:
            case SPECTRAL_ARROW:
            case SPIDER_EYE:
            case SPLASH_POTION:
            case SPRUCE_BOAT:
            case STICK:
            case STONE_AXE:
            case STONE_HOE:
            case STONE_PICKAXE:
            case STONE_SHOVEL:
            case STONE_SWORD:
            case STRING:
            case SUGAR:
            case TIPPED_ARROW:
            case TNT_MINECART:
            case TOTEM_OF_UNDYING:
            case WATER_BUCKET:
            case WHEAT_SEEDS:
            case WOODEN_AXE:
            case WOODEN_HOE:
            case WOODEN_PICKAXE:
            case WOODEN_SHOVEL:
            case WOODEN_SWORD:
            case WRITABLE_BOOK:
            case WRITTEN_BOOK:
                return r;
        }
        
        throw new IllegalStateException("Did not return mapping for " + i.toString());
    }
}
