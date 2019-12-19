package org.oilmod.api.rep.providers.minecraft;

import org.apache.commons.lang3.Validate;
import org.oilmod.api.rep.block.BlockStateRep;
import org.oilmod.api.rep.providers.BlockStateProvider;
import org.oilmod.api.rep.providers.RequestEnum;
import org.oilmod.api.rep.variant.Availability;
import org.oilmod.api.rep.variant.Substitute;

import java.util.function.Function;

public enum MinecraftBlock implements RequestEnum<MinecraftBlock, BlockRequest>, BlockStateProvider {


    //<editor-fold desc="Enum Declaration" defaultstate="collapsed">
    ACACIA_BUTTON, //Switch
    ACACIA_DOOR, //Door
    ACACIA_FENCE, //Fence
    ACACIA_FENCE_GATE, //Gate
    ACACIA_LEAVES, //Leaves
    ACACIA_LOG, //Orientable<
    ACACIA_PLANKS,
    ACACIA_PRESSURE_PLATE, //Powerable
    ACACIA_SAPLING, //Sapling
    ACACIA_SLAB, //Slab
    ACACIA_STAIRS, //Stairs
    ACACIA_TRAPDOOR, //TrapDoor
    ACACIA_WOOD, //Orientable
    ACTIVATOR_RAIL, //RedstoneRail
    AIR,
    ALLIUM,
    ANDESITE,
    ANVIL, //Directional
    ATTACHED_MELON_STEM, //Directional
    ATTACHED_PUMPKIN_STEM, //Directional
    AZURE_BLUET,
    BARRIER,
    BEACON,
    BEDROCK,
    BEETROOTS, //Ageable
    BIRCH_BUTTON, //Switch
    BIRCH_DOOR, //Door
    BIRCH_FENCE, //Fence
    BIRCH_FENCE_GATE, //Gate
    BIRCH_LEAVES, //Leaves
    BIRCH_LOG, //Orientable
    BIRCH_PLANKS,
    BIRCH_PRESSURE_PLATE, //Powerable
    BIRCH_SAPLING, //Sapling
    BIRCH_SLAB, //Slab
    BIRCH_STAIRS, //Stairs
    BIRCH_TRAPDOOR, //TrapDoor
    BIRCH_WOOD, //Orientable
    BLACK_BANNER, //Rotatable
    BLACK_BED, //Bed
    BLACK_CARPET,
    BLACK_CONCRETE,
    BLACK_CONCRETE_POWDER,
    BLACK_GLAZED_TERRACOTTA, //Directional
    BLACK_SHULKER_BOX, //Directional
    BLACK_STAINED_GLASS,
    BLACK_STAINED_GLASS_PANE, //GlassPane
    BLACK_TERRACOTTA,
    BLACK_WALL_BANNER, //Directional
    BLACK_WOOL,
    BLUE_BANNER, //Rotatable
    BLUE_BED, //Bed
    BLUE_CARPET,
    BLUE_CONCRETE,
    BLUE_CONCRETE_POWDER,
    BLUE_GLAZED_TERRACOTTA, //Directional
    BLUE_ICE,
    BLUE_ORCHID,
    BLUE_SHULKER_BOX, //Directional
    BLUE_STAINED_GLASS,
    BLUE_STAINED_GLASS_PANE, //GlassPane
    BLUE_TERRACOTTA,
    BLUE_WALL_BANNER, //Directional
    BLUE_WOOL,
    BONE_BLOCK, //Orientable
    BOOKSHELF,
    BRAIN_CORAL, //Waterlogged
    BRAIN_CORAL_BLOCK,
    BRAIN_CORAL_FAN, //Waterlogged
    BRAIN_CORAL_WALL_FAN, //CoralWallFan
    BREWING_STAND, //BrewingStand
    BRICKS,
    BRICK_SLAB, //Slab
    BRICK_STAIRS, //Stairs
    BROWN_BANNER, //Rotatable
    BROWN_BED, //Bed
    BROWN_CARPET,
    BROWN_CONCRETE,
    BROWN_CONCRETE_POWDER,
    BROWN_GLAZED_TERRACOTTA, //Directional
    BROWN_MUSHROOM_BLOCK, //MultipleFacing
    BROWN_MUSHROOM,
    BROWN_SHULKER_BOX, //Directional
    BROWN_STAINED_GLASS,
    BROWN_STAINED_GLASS_PANE, //GlassPane
    BROWN_TERRACOTTA,
    BROWN_WALL_BANNER, //Directional
    BROWN_WOOL,
    BUBBLE_COLUMN, //BubbleColumn
    BUBBLE_CORAL, //Waterlogged
    BUBBLE_CORAL_BLOCK,
    BUBBLE_CORAL_FAN, //Waterlogged
    BUBBLE_CORAL_WALL_FAN, //CoralWallFan
    CACTUS, //Ageable
    CAKE, //Cake
    CARROTS, //Ageable
    CARVED_PUMPKIN, //Directional
    CAULDRON, //Levelled
    CAVE_AIR,
    CHAIN_COMMAND_BLOCK, //CommandBlock
    CHEST, //Chest
    CHIPPED_ANVIL, //Directional
    CHISELED_QUARTZ_BLOCK,
    CHISELED_RED_SANDSTONE,
    CHISELED_SANDSTONE,
    CHISELED_STONE_BRICKS,
    CHORUS_FLOWER, //Ageable
    CHORUS_PLANT, //MultipleFacing
    CLAY,
    COAL_BLOCK,
    COAL_ORE,
    COARSE_DIRT,
    COBBLESTONE,
    COBBLESTONE_SLAB, //Slab
    COBBLESTONE_STAIRS, //Stairs
    COBBLESTONE_WALL, //Fence
    COBWEB,
    COCOA, //Cocoa
    COMMAND_BLOCK, //CommandBlock
    COMPARATOR, //Comparator
    CONDUIT, //Waterlogged
    CRACKED_STONE_BRICKS,
    CRAFTING_TABLE,
    CREEPER_HEAD, //Rotatable
    CREEPER_WALL_HEAD, //Directional
    CUT_RED_SANDSTONE,
    CUT_SANDSTONE,
    CYAN_BANNER, //Rotatable
    CYAN_BED, //Bed
    CYAN_CARPET,
    CYAN_CONCRETE,
    CYAN_CONCRETE_POWDER,
    CYAN_GLAZED_TERRACOTTA, //Directional
    CYAN_SHULKER_BOX, //Directional
    CYAN_STAINED_GLASS,
    CYAN_STAINED_GLASS_PANE, //GlassPane
    CYAN_TERRACOTTA,
    CYAN_WALL_BANNER, //Directional
    CYAN_WOOL,
    DAMAGED_ANVIL, //Directional
    DANDELION,
    DARK_OAK_BUTTON, //Switch
    DARK_OAK_DOOR, //Door
    DARK_OAK_FENCE, //Fence
    DARK_OAK_FENCE_GATE, //Gate
    DARK_OAK_LEAVES, //Leaves
    DARK_OAK_LOG, //Orientable
    DARK_OAK_PLANKS,
    DARK_OAK_PRESSURE_PLATE, //Powerable
    DARK_OAK_SAPLING, //Sapling
    DARK_OAK_SLAB, //Slab
    DARK_OAK_STAIRS, //Stairs
    DARK_OAK_TRAPDOOR, //TrapDoor
    DARK_OAK_WOOD, //Orientable
    DARK_PRISMARINE,
    DARK_PRISMARINE_SLAB, //Slab
    DARK_PRISMARINE_STAIRS, //Stairs
    DAYLIGHT_DETECTOR, //DaylightDetector
    DEAD_BRAIN_CORAL, //Waterlogged
    DEAD_BRAIN_CORAL_BLOCK,
    DEAD_BRAIN_CORAL_FAN, //Waterlogged
    DEAD_BRAIN_CORAL_WALL_FAN, //CoralWallFan
    DEAD_BUBBLE_CORAL, //Waterlogged
    DEAD_BUBBLE_CORAL_BLOCK,
    DEAD_BUBBLE_CORAL_FAN, //Waterlogged
    DEAD_BUBBLE_CORAL_WALL_FAN, //CoralWallFan
    DEAD_BUSH,
    DEAD_FIRE_CORAL, //Waterlogged
    DEAD_FIRE_CORAL_BLOCK,
    DEAD_FIRE_CORAL_FAN, //Waterlogged
    DEAD_FIRE_CORAL_WALL_FAN, //CoralWallFan
    DEAD_HORN_CORAL, //Waterlogged
    DEAD_HORN_CORAL_BLOCK,
    DEAD_HORN_CORAL_FAN, //Waterlogged
    DEAD_HORN_CORAL_WALL_FAN, //CoralWallFan
    DEAD_TUBE_CORAL, //Waterlogged
    DEAD_TUBE_CORAL_BLOCK,
    DEAD_TUBE_CORAL_FAN, //Waterlogged
    DEAD_TUBE_CORAL_WALL_FAN, //CoralWallFan
    DETECTOR_RAIL, //RedstoneRail
    DIAMOND_BLOCK,
    DIAMOND_ORE,
    DIORITE,
    DIRT,
    DISPENSER, //Dispenser
    DRAGON_EGG,
    DRAGON_HEAD, //Rotatable
    DRAGON_WALL_HEAD, //Directional
    DRIED_KELP_BLOCK,
    DROPPER, //Dispenser
    EMERALD_BLOCK,
    EMERALD_ORE,
    ENCHANTING_TABLE,
    ENDER_CHEST, //EnderChest
    END_GATEWAY,
    END_PORTAL,
    END_PORTAL_FRAME, //EndPortalFrame
    END_ROD, //Directional
    END_STONE,
    END_STONE_BRICKS,
    FARMLAND, //Farmland
    FERN,
    FIRE, //Fire
    FIRE_CORAL, //Waterlogged
    FIRE_CORAL_BLOCK,
    FIRE_CORAL_FAN, //Waterlogged
    FIRE_CORAL_WALL_FAN, //CoralWallFan
    FLOWER_POT,
    FROSTED_ICE, //Ageable
    FURNACE, //Furnace
    GLASS,
    GLASS_PANE, //GlassPane
    GLOWSTONE,
    GOLD_BLOCK,
    GOLD_ORE,
    GRANITE,
    GRASS,
    GRASS_BLOCK, //Snowable
    GRASS_PATH,
    GRAVEL,
    GRAY_BANNER, //Rotatable
    GRAY_BED, //Bed
    GRAY_CARPET,
    GRAY_CONCRETE,
    GRAY_CONCRETE_POWDER,
    GRAY_GLAZED_TERRACOTTA, //Directional
    GRAY_SHULKER_BOX, //Directional
    GRAY_STAINED_GLASS,
    GRAY_STAINED_GLASS_PANE, //GlassPane
    GRAY_TERRACOTTA,
    GRAY_WALL_BANNER, //Directional
    GRAY_WOOL,
    GREEN_BANNER, //Rotatable
    GREEN_BED, //Bed
    GREEN_CARPET,
    GREEN_CONCRETE,
    GREEN_CONCRETE_POWDER,
    GREEN_GLAZED_TERRACOTTA, //Directional
    GREEN_SHULKER_BOX, //Directional
    GREEN_STAINED_GLASS,
    GREEN_STAINED_GLASS_PANE, //GlassPane
    GREEN_TERRACOTTA,
    GREEN_WALL_BANNER, //Directional
    GREEN_WOOL,
    HAY_BLOCK, //Orientable
    HEAVY_WEIGHTED_PRESSURE_PLATE, //AnaloguePowerable
    HOPPER, //Hopper
    HORN_CORAL, //Waterlogged
    HORN_CORAL_BLOCK,
    HORN_CORAL_FAN, //Waterlogged
    HORN_CORAL_WALL_FAN, //CoralWallFan
    ICE,
    INFESTED_CHISELED_STONE_BRICKS,
    INFESTED_COBBLESTONE,
    INFESTED_CRACKED_STONE_BRICKS,
    INFESTED_MOSSY_STONE_BRICKS,
    INFESTED_STONE,
    INFESTED_STONE_BRICKS,
    IRON_BARS, //Fence
    IRON_BLOCK,
    IRON_DOOR, //Door
    IRON_ORE,
    IRON_TRAPDOOR, //TrapDoor
    JACK_O_LANTERN, //Directional
    JUKEBOX, //Jukebox
    JUNGLE_BUTTON, //Switch
    JUNGLE_DOOR, //Door
    JUNGLE_FENCE, //Fence
    JUNGLE_FENCE_GATE, //Gate
    JUNGLE_LEAVES, //Leaves
    JUNGLE_LOG, //Orientable
    JUNGLE_PLANKS,
    JUNGLE_PRESSURE_PLATE, //Powerable
    JUNGLE_SAPLING, //Sapling
    JUNGLE_SLAB, //Slab
    JUNGLE_STAIRS, //Stairs
    JUNGLE_TRAPDOOR, //TrapDoor
    JUNGLE_WOOD, //Orientable
    KELP, //Ageable
    KELP_PLANT,
    LADDER, //Ladder
    LAPIS_BLOCK,
    LAPIS_ORE,
    LARGE_FERN, //Bisected
    LAVA, //Levelled
    LEVER, //Switch
    LIGHT_BLUE_BANNER, //Rotatable
    LIGHT_BLUE_BED, //Bed
    LIGHT_BLUE_CARPET,
    LIGHT_BLUE_CONCRETE,
    LIGHT_BLUE_CONCRETE_POWDER,
    LIGHT_BLUE_GLAZED_TERRACOTTA, //Directional
    LIGHT_BLUE_SHULKER_BOX, //Directional
    LIGHT_BLUE_STAINED_GLASS,
    LIGHT_BLUE_STAINED_GLASS_PANE, //GlassPane
    LIGHT_BLUE_TERRACOTTA,
    LIGHT_BLUE_WALL_BANNER, //Directional
    LIGHT_BLUE_WOOL,
    LIGHT_GRAY_BANNER, //Rotatable
    LIGHT_GRAY_BED, //Bed
    LIGHT_GRAY_CARPET,
    LIGHT_GRAY_CONCRETE,
    LIGHT_GRAY_CONCRETE_POWDER,
    LIGHT_GRAY_GLAZED_TERRACOTTA, //Directional
    LIGHT_GRAY_SHULKER_BOX, //Directional
    LIGHT_GRAY_STAINED_GLASS,
    LIGHT_GRAY_STAINED_GLASS_PANE, //GlassPane
    LIGHT_GRAY_TERRACOTTA,
    LIGHT_GRAY_WALL_BANNER, //Directional
    LIGHT_GRAY_WOOL,
    LIGHT_WEIGHTED_PRESSURE_PLATE, //AnaloguePowerable
    LILAC, //Bisected
    LILY_PAD,
    LIME_BANNER, //Rotatable
    LIME_BED, //Bed
    LIME_CARPET,
    LIME_CONCRETE,
    LIME_CONCRETE_POWDER,
    LIME_GLAZED_TERRACOTTA, //Directional
    LIME_SHULKER_BOX, //Directional
    LIME_STAINED_GLASS,
    LIME_STAINED_GLASS_PANE, //GlassPane
    LIME_TERRACOTTA,
    LIME_WALL_BANNER, //Directional
    LIME_WOOL,
    MAGENTA_BANNER, //Rotatable
    MAGENTA_BED, //Bed
    MAGENTA_CARPET,
    MAGENTA_CONCRETE,
    MAGENTA_CONCRETE_POWDER,
    MAGENTA_GLAZED_TERRACOTTA, //Directional
    MAGENTA_SHULKER_BOX, //Directional
    MAGENTA_STAINED_GLASS,
    MAGENTA_STAINED_GLASS_PANE, //GlassPane
    MAGENTA_TERRACOTTA,
    MAGENTA_WALL_BANNER, //Directional
    MAGENTA_WOOL,
    MAGMA_BLOCK,
    MELON,
    MELON_STEM, //Ageable
    MOSSY_COBBLESTONE, //MultipleFacing
    MOSSY_COBBLESTONE_WALL, //Fence
    MOSSY_STONE_BRICKS,
    MOVING_PISTON, //TechnicalPiston
    MUSHROOM_STEM, //MultipleFacing
    MYCELIUM, //Snowable
    NETHERRACK,
    NETHER_BRICKS,
    NETHER_BRICK_FENCE, //Fence
    NETHER_BRICK_SLAB, //Slab
    NETHER_BRICK_STAIRS, //Stairs
    NETHER_PORTAL, //Orientable
    NETHER_QUARTZ_ORE,
    NETHER_WART, //Ageable
    NETHER_WART_BLOCK,
    NOTE_BLOCK, //NoteBlock
    OAK_BUTTON, //Switch
    OAK_DOOR, //Door
    OAK_FENCE, //Fence
    OAK_FENCE_GATE, //Gate
    OAK_LEAVES, //Leaves
    OAK_LOG, //Orientable
    OAK_PLANKS,
    OAK_PRESSURE_PLATE, //Powerable
    OAK_SAPLING, //Sapling
    OAK_SLAB, //Slab
    OAK_STAIRS, //Stairs
    OAK_TRAPDOOR, //TrapDoor
    OAK_WOOD, //Orientable
    OBSERVER, //Observer
    OBSIDIAN,
    ORANGE_BANNER, //Rotatable
    ORANGE_BED, //Bed
    ORANGE_CARPET,
    ORANGE_CONCRETE,
    ORANGE_CONCRETE_POWDER,
    ORANGE_GLAZED_TERRACOTTA, //Directional
    ORANGE_SHULKER_BOX, //Directional
    ORANGE_STAINED_GLASS,
    ORANGE_STAINED_GLASS_PANE, //GlassPane
    ORANGE_TERRACOTTA,
    ORANGE_TULIP,
    ORANGE_WALL_BANNER, //Directional
    ORANGE_WOOL,
    OXEYE_DAISY,
    PACKED_ICE,
    PEONY, //Bisected
    PETRIFIED_OAK_SLAB, //Slab
    PINK_BANNER, //Rotatable
    PINK_BED, //Bed
    PINK_CARPET,
    PINK_CONCRETE,
    PINK_CONCRETE_POWDER,
    PINK_GLAZED_TERRACOTTA, //Directional
    PINK_SHULKER_BOX, //Directional
    PINK_STAINED_GLASS,
    PINK_STAINED_GLASS_PANE, //GlassPane
    PINK_TERRACOTTA,
    PINK_TULIP,
    PINK_WALL_BANNER, //Directional
    PINK_WOOL,
    PISTON, //Piston
    PISTON_HEAD, //PistonHead
    PLAYER_HEAD, //Rotatable
    PLAYER_WALL_HEAD, //Directional
    PODZOL, //Snowable
    POLISHED_ANDESITE,
    POLISHED_DIORITE,
    POLISHED_GRANITE,
    POPPY,
    POTATOES, //Ageable
    POTTED_ACACIA_SAPLING,
    POTTED_ALLIUM,
    POTTED_AZURE_BLUET,
    POTTED_BIRCH_SAPLING,
    POTTED_BLUE_ORCHID,
    POTTED_BROWN_MUSHROOM,
    POTTED_CACTUS,
    POTTED_DANDELION,
    POTTED_DARK_OAK_SAPLING,
    POTTED_DEAD_BUSH,
    POTTED_FERN,
    POTTED_JUNGLE_SAPLING,
    POTTED_OAK_SAPLING,
    POTTED_ORANGE_TULIP,
    POTTED_OXEYE_DAISY,
    POTTED_PINK_TULIP,
    POTTED_POPPY,
    POTTED_RED_MUSHROOM,
    POTTED_RED_TULIP,
    POTTED_SPRUCE_SAPLING,
    POTTED_WHITE_TULIP,
    POWERED_RAIL, //RedstoneRail
    PRISMARINE,
    PRISMARINE_BRICKS,
    PRISMARINE_BRICK_SLAB, //Slab
    PRISMARINE_BRICK_STAIRS, //Stairs
    PRISMARINE_SLAB, //Slab
    PRISMARINE_STAIRS, //Stairs
    PUMPKIN,
    PUMPKIN_STEM, //Ageable
    PURPLE_BANNER, //Rotatable
    PURPLE_BED, //Bed
    PURPLE_CARPET,
    PURPLE_CONCRETE,
    PURPLE_CONCRETE_POWDER,
    PURPLE_GLAZED_TERRACOTTA, //Directional
    PURPLE_SHULKER_BOX, //Directional
    PURPLE_STAINED_GLASS,
    PURPLE_STAINED_GLASS_PANE, //GlassPane
    PURPLE_TERRACOTTA,
    PURPLE_WALL_BANNER, //Directional
    PURPLE_WOOL,
    PURPUR_BLOCK,
    PURPUR_PILLAR, //Orientable
    PURPUR_SLAB, //Slab
    PURPUR_STAIRS, //Stairs
    QUARTZ_BLOCK,
    QUARTZ_PILLAR, //Orientable
    QUARTZ_SLAB, //Slab
    QUARTZ_STAIRS, //Stairs
    RAIL, //Rail
    REDSTONE_BLOCK,
    REDSTONE_LAMP, //Lightable
    REDSTONE_ORE, //Lightable
    REDSTONE_TORCH, //Lightable
    REDSTONE_WALL_TORCH, //RedstoneWallTorch
    REDSTONE_WIRE, //RedstoneWire
    RED_BANNER, //Rotatable
    RED_BED, //Bed
    RED_CARPET,
    RED_CONCRETE,
    RED_CONCRETE_POWDER,
    RED_GLAZED_TERRACOTTA, //Directional
    RED_MUSHROOM,
    RED_MUSHROOM_BLOCK, //MultipleFacing
    RED_NETHER_BRICKS,
    RED_SAND,
    RED_SANDSTONE,
    RED_SANDSTONE_SLAB, //Slab
    RED_SANDSTONE_STAIRS, //Stairs
    RED_SHULKER_BOX, //Directional
    RED_STAINED_GLASS,
    RED_STAINED_GLASS_PANE, //GlassPane
    RED_TERRACOTTA,
    RED_TULIP,
    RED_WALL_BANNER, //Directional
    RED_WOOL,
    REPEATER, //Repeater
    REPEATING_COMMAND_BLOCK, //CommandBlock
    ROSE_BUSH, //Bisected
    SAND,
    SANDSTONE,
    SANDSTONE_SLAB, //Slab
    SANDSTONE_STAIRS, //Stairs
    SEAGRASS,
    SEA_LANTERN,
    SEA_PICKLE, //SeaPickle
    SHULKER_BOX, //Directional
    SIGN, //Sign
    SKELETON_SKULL, //Rotatable
    SKELETON_WALL_SKULL, //Directional
    SLIME_BLOCK,
    SMOOTH_QUARTZ,
    SMOOTH_RED_SANDSTONE,
    SMOOTH_SANDSTONE,
    SMOOTH_STONE,
    SNOW, //Snow
    SNOW_BLOCK,
    SOUL_SAND,
    SPAWNER,
    SPONGE,
    SPRUCE_BUTTON, //Switch
    SPRUCE_DOOR, //Door
    SPRUCE_FENCE, //Fence
    SPRUCE_FENCE_GATE, //Gate
    SPRUCE_LEAVES, //Leaves
    SPRUCE_LOG, //Orientable
    SPRUCE_PLANKS,
    SPRUCE_PRESSURE_PLATE, //Powerable
    SPRUCE_SAPLING, //Sapling
    SPRUCE_SLAB, //Slab
    SPRUCE_STAIRS, //Stairs
    SPRUCE_TRAPDOOR, //TrapDoor
    SPRUCE_WOOD, //Orientable
    STICKY_PISTON, //Piston
    STONE,
    STONE_BRICKS,
    STONE_BRICK_SLAB, //Slab
    STONE_BRICK_STAIRS, //Stairs
    STONE_BUTTON, //Switch
    STONE_PRESSURE_PLATE, //Powerable
    STONE_SLAB, //Slab
    STRIPPED_ACACIA_LOG, //Orientable
    STRIPPED_ACACIA_WOOD, //Orientable
    STRIPPED_BIRCH_LOG, //Orientable
    STRIPPED_BIRCH_WOOD, //Orientable
    STRIPPED_DARK_OAK_LOG, //Orientable
    STRIPPED_DARK_OAK_WOOD, //Orientable
    STRIPPED_JUNGLE_LOG, //Orientable
    STRIPPED_JUNGLE_WOOD, //Orientable
    STRIPPED_OAK_LOG, //Orientable
    STRIPPED_OAK_WOOD, //Orientable
    STRIPPED_SPRUCE_LOG, //Orientable
    STRIPPED_SPRUCE_WOOD, //Orientable
    STRUCTURE_BLOCK, //StructureBlock
    STRUCTURE_VOID,
    SUGAR_CANE, //Ageable
    SUNFLOWER, //Bisected
    TALL_GRASS, //Bisected
    TALL_SEAGRASS, //Bisected
    TERRACOTTA,
    TNT, //TNT
    TORCH,
    TRAPPED_CHEST, //Chest
    TRIPWIRE, //Tripwire
    TRIPWIRE_HOOK, //TripwireHook
    TUBE_CORAL, //Waterlogged
    TUBE_CORAL_BLOCK,
    TUBE_CORAL_FAN, //Waterlogged
    TUBE_CORAL_WALL_FAN, //CoralWallFan
    TURTLE_EGG, //TurtleEgg
    VINE, //MultipleFacing
    VOID_AIR,
    WALL_SIGN, //WallSign
    WALL_TORCH, //Directional
    WATER, //Levelled
    WET_SPONGE,
    WHEAT, //Ageable
    WHITE_BANNER, //Rotatable
    WHITE_BED, //Bed
    WHITE_CARPET,
    WHITE_CONCRETE,
    WHITE_CONCRETE_POWDER,
    WHITE_GLAZED_TERRACOTTA, //Directional
    WHITE_SHULKER_BOX, //Directional
    WHITE_STAINED_GLASS,
    WHITE_STAINED_GLASS_PANE, //GlassPane
    WHITE_TERRACOTTA,
    WHITE_TULIP,
    WHITE_WALL_BANNER, //Directional
    WHITE_WOOL,
    WITHER_SKELETON_SKULL, //Rotatable
    WITHER_SKELETON_WALL_SKULL, //Directional
    YELLOW_BANNER, //Rotatable
    YELLOW_BED, //Bed
    YELLOW_CARPET,
    YELLOW_CONCRETE,
    YELLOW_CONCRETE_POWDER,
    YELLOW_GLAZED_TERRACOTTA, //Directional
    YELLOW_SHULKER_BOX, //Directional
    YELLOW_STAINED_GLASS,
    YELLOW_STAINED_GLASS_PANE, //GlassPane
    YELLOW_TERRACOTTA,
    YELLOW_WALL_BANNER, //Directional
    YELLOW_WOOL,
    ZOMBIE_HEAD, //Rotatable
    ZOMBIE_WALL_HEAD; //Directional
    //</editor-fold>

    private final InitState<MinecraftBlock, BlockRequest> initState;
    private MC112BlockReq mc112;
    private MC113BlockReq mc113;
    private static final MinecraftBlockProvider provider;
    private BlockStateRep value;
    private Availability availability;

    MinecraftBlock() {
        Function<MinecraftBlock, BlockRequest> mc112 = Blocks112::getLinker;
        Function<MinecraftBlock, BlockRequest> mc113 = Blocks113::getLinker;

        //noinspection unchecked
        initState = new InitState<>(this, mc112, mc113);
    }

    static {
        Validate.notNull(provider = MinecraftBlockProvider.getInstance(), "Please set MinecraftBlockProvider before accessing any blocks");
        for (MinecraftBlock block:values()) {
            block.initState.init();
        }
    }

    public MC112BlockReq getMc112() {
        return mc112;
    }

    public MC113BlockReq getMc113() {
        return mc113;
    }

    @Override
    public InitState<MinecraftBlock, BlockRequest> getInitState() {
        return initState;
    }

    @Override
    public void saveRequest(BlockRequest request) {
        if (request instanceof MC112BlockReq) {
            mc112 = (MC112BlockReq) request;
        } else if (request instanceof MC113BlockReq) {
            mc113 = (MC113BlockReq) request;
        }
    }

    public Availability getAvailability() {
        return availability;
    }

    public BlockStateRep get() {
        return value;
    }

    @Override
    public void init() {
        Substitute<BlockStateRep> sub = provider.getBlock(this);
        value = sub.value;
        availability = sub.availability;
    }

    @Override
    public BlockStateRep getProvidedBlockState() {
        return get();
    }
}
