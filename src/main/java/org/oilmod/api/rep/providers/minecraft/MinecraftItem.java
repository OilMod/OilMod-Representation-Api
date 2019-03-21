package org.oilmod.api.rep.providers.minecraft;

import org.apache.commons.lang3.Validate;
import org.oilmod.api.rep.block.BlockStateRep;
import org.oilmod.api.rep.item.ItemStateRep;
import org.oilmod.api.rep.providers.RequestEnum;
import org.oilmod.api.rep.variant.Availability;
import org.oilmod.api.rep.variant.Substitute;

import java.util.function.Function;

public enum MinecraftItem implements RequestEnum<MinecraftItem, ItemRequest> {

    //<editor-fold desc="Enum Declaration" defaultstate="collapsed">
    ACACIA_BOAT,
    COMMAND_BLOCK_MINECART,
    DANDELION_YELLOW,
    FURNACE_MINECART,
    MUSHROOM_STEW,
    ROSE_RED,
    APPLE,
    ARMOR_STAND,
    ARROW,
    BAKED_POTATO,
    BAT_SPAWN_EGG,
    BEEF,
    BEETROOT,
    BEETROOT_SEEDS,
    BEETROOT_SOUP,
    BIRCH_BOAT,
    BLAZE_POWDER,
    BLAZE_ROD,
    BLAZE_SPAWN_EGG,
    BONE,
    BONE_MEAL,
    BOOK,
    BOW,
    BOWL,
    BREAD,
    BRICK,
    BROWN_MUSHROOM,
    BUCKET,
    CACTUS_GREEN,
    CARROT,
    CARROT_ON_A_STICK,
    CAVE_SPIDER_SPAWN_EGG,
    CHAINMAIL_BOOTS,
    CHAINMAIL_CHESTPLATE,
    CHAINMAIL_HELMET,
    CHAINMAIL_LEGGINGS,
    CHARCOAL,
    CHEST_MINECART,
    CHICKEN,
    CHICKEN_SPAWN_EGG,
    CHORUS_FRUIT,
    CLAY_BALL,
    CLOCK,
    COAL,
    COCOA_BEANS,
    COD,
    COD_BUCKET,
    COD_SPAWN_EGG,
    COMPASS,
    COOKED_BEEF,
    COOKED_CHICKEN,
    COOKED_COD,
    COOKED_MUTTON,
    COOKED_PORKCHOP,
    COOKED_RABBIT,
    COOKED_SALMON,
    COOKIE,
    COW_SPAWN_EGG,
    CREEPER_SPAWN_EGG,
    CYAN_DYE,
    DARK_OAK_BOAT,
    DEBUG_STICK,
    DIAMOND,
    DIAMOND_AXE,
    DIAMOND_BOOTS,
    DIAMOND_CHESTPLATE,
    DIAMOND_HELMET,
    DIAMOND_HOE,
    DIAMOND_HORSE_ARMOR,
    DIAMOND_LEGGINGS,
    DIAMOND_PICKAXE,
    DIAMOND_SHOVEL,
    DIAMOND_SWORD,
    DOLPHIN_SPAWN_EGG,
    DONKEY_SPAWN_EGG,
    DRAGON_BREATH,
    DRAGON_EGG,
    DRIED_KELP,
    DROWNED_SPAWN_EGG,
    EGG,
    ELDER_GUARDIAN_SPAWN_EGG,
    ELYTRA,
    EMERALD,
    ENCHANTED_BOOK,
    ENCHANTED_GOLDEN_APPLE,
    ENDERMAN_SPAWN_EGG,
    ENDERMITE_SPAWN_EGG,
    ENDER_EYE,
    ENDER_PEARL,
    END_CRYSTAL,
    END_GATEWAY,
    EVOKER_SPAWN_EGG,
    EXPERIENCE_BOTTLE,
    FEATHER,
    FERMENTED_SPIDER_EYE,
    FILLED_MAP,
    FIREWORK_ROCKET,
    FIREWORK_STAR,
    FIRE_CHARGE,
    FISHING_ROD,
    FLINT,
    FLINT_AND_STEEL,
    GHAST_SPAWN_EGG,
    GHAST_TEAR,
    GLASS_BOTTLE,
    GLISTERING_MELON_SLICE,
    GLOWSTONE_DUST,
    GOLDEN_APPLE,
    GOLDEN_AXE,
    GOLDEN_BOOTS,
    GOLDEN_CARROT,
    GOLDEN_CHESTPLATE,
    GOLDEN_HELMET,
    GOLDEN_HOE,
    GOLDEN_HORSE_ARMOR,
    GOLDEN_LEGGINGS,
    GOLDEN_PICKAXE,
    GOLDEN_SHOVEL,
    GOLDEN_SWORD,
    GOLD_INGOT,
    GOLD_NUGGET,
    GRAY_DYE,
    GUARDIAN_SPAWN_EGG,
    GUNPOWDER,
    HEART_OF_THE_SEA,
    HOPPER_MINECART,
    HORSE_SPAWN_EGG,
    HUSK_SPAWN_EGG,
    INK_SAC,
    IRON_AXE,
    IRON_BOOTS,
    IRON_CHESTPLATE,
    IRON_HELMET,
    IRON_HOE,
    IRON_HORSE_ARMOR,
    IRON_INGOT,
    IRON_LEGGINGS,
    IRON_NUGGET,
    IRON_PICKAXE,
    IRON_SHOVEL,
    IRON_SWORD,
    ITEM_FRAME,
    JUNGLE_BOAT,
    KNOWLEDGE_BOOK,
    LAPIS_LAZULI,
    LAVA_BUCKET,
    LEAD,
    LEATHER,
    LEATHER_BOOTS,
    LEATHER_CHESTPLATE,
    LEATHER_HELMET,
    LEATHER_LEGGINGS,
    LIGHT_BLUE_DYE,
    LIGHT_GRAY_DYE,
    LIME_DYE,
    LINGERING_POTION,
    LLAMA_SPAWN_EGG,
    MAGENTA_DYE,
    MAGMA_CREAM,
    MAGMA_CUBE_SPAWN_EGG,
    MAP,
    MELON_SEEDS,
    MELON_SLICE,
    MILK_BUCKET,
    MINECART,
    MOOSHROOM_SPAWN_EGG,
    MULE_SPAWN_EGG,
    MUSIC_DISC_,
    MUSIC_DISC_3,
    MUSIC_DISC_BLOCKS,
    MUSIC_DISC_CAT,
    MUSIC_DISC_CHIRP,
    MUSIC_DISC_FAR,
    MUSIC_DISC_MALL,
    MUSIC_DISC_MELLOHI,
    MUSIC_DISC_STAL,
    MUSIC_DISC_STRAD,
    MUSIC_DISC_WAIT,
    MUSIC_DISC_WARD,
    MUTTON,
    NAME_TAG,
    NAUTILUS_SHELL,
    NETHER_BRICK,
    NETHER_STAR,
    OAK_BOAT,
    OCELOT_SPAWN_EGG,
    ORANGE_DYE,
    PAINTING,
    PAPER,
    PARROT_SPAWN_EGG,
    PHANTOM_MEMBRANE,
    PHANTOM_SPAWN_EGG,
    PIG_SPAWN_EGG,
    PINK_DYE,
    POISONOUS_POTATO,
    POLAR_BEAR_SPAWN_EGG,
    POPPED_CHORUS_FRUIT,
    PORKCHOP,
    POTATO,
    POTION,
    PRISMARINE_CRYSTALS,
    PRISMARINE_SHARD,
    PUFFERFISH,
    PUFFERFISH_BUCKET,
    PUFFERFISH_SPAWN_EGG,
    PUMPKIN_PIE,
    PUMPKIN_SEEDS,
    PURPLE_DYE,
    QUARTZ,
    RABBIT,
    RABBIT_FOOT,
    RABBIT_HIDE,
    RABBIT_SPAWN_EGG,
    RABBIT_STEW,
    REDSTONE,
    ROTTEN_FLESH,
    SADDLE,
    SALMON,
    SALMON_BUCKET,
    SALMON_SPAWN_EGG,
    SCUTE,
    SHEARS,
    SHEEP_SPAWN_EGG,
    SHIELD,
    SHULKER_SHELL,
    SHULKER_SPAWN_EGG,
    SILVERFISH_SPAWN_EGG,
    SKELETON_HORSE_SPAWN_EGG,
    SKELETON_SPAWN_EGG,
    SLIME_BALL,
    SLIME_SPAWN_EGG,
    SNOWBALL,
    SPECTRAL_ARROW,
    SPIDER_EYE,
    SPIDER_SPAWN_EGG,
    SPLASH_POTION,
    SPRUCE_BOAT,
    SQUID_SPAWN_EGG,
    STICK,
    STONE_AXE,
    STONE_HOE,
    STONE_PICKAXE,
    STONE_SHOVEL,
    STONE_SWORD,
    STRAY_SPAWN_EGG,
    STRING,
    SUGAR,
    TIPPED_ARROW,
    TNT_MINECART,
    TOTEM_OF_UNDYING,
    TRIDENT,
    TROPICAL_FISH,
    TROPICAL_FISH_BUCKET,
    TROPICAL_FISH_SPAWN_EGG,
    TURTLE_HELMET,
    TURTLE_SPAWN_EGG,
    VEX_SPAWN_EGG,
    VILLAGER_SPAWN_EGG,
    VINDICATOR_SPAWN_EGG,
    WATER_BUCKET,
    WHEAT_SEEDS,
    WITCH_SPAWN_EGG,
    WITHER_SKELETON_SPAWN_EGG,
    WOLF_SPAWN_EGG,
    WOODEN_AXE,
    WOODEN_HOE,
    WOODEN_PICKAXE,
    WOODEN_SHOVEL,
    WOODEN_SWORD,
    WRITABLE_BOOK,
    WRITTEN_BOOK,
    ZOMBIE_HORSE_SPAWN_EGG,
    ZOMBIE_PIGMAN_SPAWN_EGG,
    ZOMBIE_SPAWN_EGG,
    ZOMBIE_VILLAGER_SPAWN_EGG;
    //</editor-fold>

    private final InitState<MinecraftItem, ItemRequest> initState;
    private MC112ItemReq mc112;
    private MC113ItemReq mc113;
    private static final MinecraftItemProvider provider;
    private ItemStateRep value;
    private Availability availability;

    MinecraftItem() {
        Function<MinecraftItem, ItemRequest> mc112 = Items112::getLinker;
        Function<MinecraftItem, ItemRequest> mc113 = Items113::getLinker;

        //noinspection unchecked
        initState = new InitState<>(this, mc112, mc113);
    }

    static {
        Validate.notNull(provider = MinecraftItemProvider.getInstance(), "Please set MinecraftItemProvider before accessing any items");
        for (MinecraftItem item:values()) {
            item.initState.init();
        }
    }

    public MC112ItemReq getMc112() {
        return mc112;
    }

    public MC113ItemReq getMc113() {
        return mc113;
    }

    @Override
    public InitState<MinecraftItem, ItemRequest> getInitState() {
        return initState;
    }

    @Override
    public void saveRequest(ItemRequest request) {
        if (request instanceof MC112ItemReq) {
            mc112 = (MC112ItemReq) request;
        } else if (request instanceof MC113ItemReq) {
            mc113 = (MC113ItemReq) request;
        }
    }

    public Availability getAvailability() {
        return availability;
    }

    public ItemStateRep get() {
        return value;
    }

    @Override
    public void init() {
        Substitute<ItemStateRep> sub = provider.getItem(this);
        value = sub.value;
        availability = sub.availability;
    }
}
