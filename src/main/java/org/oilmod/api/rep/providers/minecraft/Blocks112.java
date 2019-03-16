package org.oilmod.api.rep.providers.minecraft;

import static org.oilmod.api.rep.providers.minecraft.MinecraftBlock.*;

public class Blocks112 {
    
    private static class Req extends MC112BlockReq{
        public Req(MinecraftBlock b) {
            super(b);
        }

        @Override
        public Req prop(String name, String value) {
            return (Req) super.prop(name, value);
        }

        @Override
        public Req key(String key) {
            return (Req) super.key(key);
        }

        public Req logKey(MinecraftBlock b) {
            switch (b) {
                case BIRCH_LEAVES:
                case JUNGLE_LEAVES:
                case OAK_LEAVES:
                case SPRUCE_LEAVES:
                    return key("leaves");
                case ACACIA_LEAVES:
                case DARK_OAK_LEAVES:
                    return key("leaves2");
                case BIRCH_LOG:
                case JUNGLE_LOG:
                case OAK_LOG:
                case SPRUCE_LOG:
                case BIRCH_WOOD:
                case OAK_WOOD:
                case SPRUCE_WOOD:
                case JUNGLE_WOOD:
                    return key("log");
                case ACACIA_LOG:
                case DARK_OAK_LOG:
                case ACACIA_WOOD:
                case DARK_OAK_WOOD:
                    return key("log2");
                case ACACIA_PLANKS:
                case BIRCH_PLANKS:
                case DARK_OAK_PLANKS:
                case JUNGLE_PLANKS:
                case OAK_PLANKS:
                case SPRUCE_PLANKS:
                    return key("planks");
                case ACACIA_SAPLING:
                case BIRCH_SAPLING:
                case DARK_OAK_SAPLING:
                case JUNGLE_SAPLING:
                case OAK_SAPLING:
                case SPRUCE_SAPLING:
                    return key("sapling");
                case ACACIA_SLAB:
                case BIRCH_SLAB:
                case DARK_OAK_SLAB:
                case JUNGLE_SLAB:
                case OAK_SLAB:
                case SPRUCE_SLAB:
                    return key("wooden_slab");
            }
            throw new IllegalStateException();
        }
        
        public Req logVar(MinecraftBlock b) {
            String name = "variant";
            switch (b) {
                case ACACIA_SAPLING:
                case BIRCH_SAPLING:
                case DARK_OAK_SAPLING:
                case JUNGLE_SAPLING:
                case OAK_SAPLING:
                case SPRUCE_SAPLING:
                    name = "type";
            }

            switch (b) {
                case BIRCH_LEAVES:
                case BIRCH_LOG:
                case BIRCH_WOOD:
                case BIRCH_PLANKS:
                case BIRCH_SAPLING:
                case BIRCH_SLAB:
                    return prop(name, "birch");
                case JUNGLE_LEAVES:
                case JUNGLE_LOG:
                case JUNGLE_WOOD:
                case JUNGLE_PLANKS:
                case JUNGLE_SAPLING:
                case JUNGLE_SLAB:
                    return prop(name, "jungle");
                case OAK_LEAVES:
                case OAK_LOG:
                case OAK_WOOD:
                case OAK_PLANKS:
                case OAK_SAPLING:
                case OAK_SLAB:
                    return prop(name, "oak");
                case SPRUCE_LEAVES:
                case SPRUCE_LOG:
                case SPRUCE_WOOD:
                case SPRUCE_PLANKS:
                case SPRUCE_SAPLING:
                case SPRUCE_SLAB:
                    return prop(name, "spruce");
                case ACACIA_LEAVES:
                case ACACIA_LOG:
                case ACACIA_WOOD:
                case ACACIA_PLANKS:
                case ACACIA_SAPLING:
                case ACACIA_SLAB:
                    return prop(name, "acacia");
                case DARK_OAK_LEAVES:
                case DARK_OAK_LOG:
                case DARK_OAK_WOOD:
                case DARK_OAK_PLANKS:
                case DARK_OAK_SAPLING:
                case DARK_OAK_SLAB:
                    return prop(name, "dark_oak");
            }
            throw new IllegalStateException();
        }

        public Req colVar(MinecraftBlock b) {
            switch (b) {
                case BLACK_CARPET:
                case BLACK_CONCRETE:
                case BLACK_CONCRETE_POWDER:
                case BLACK_STAINED_GLASS:
                case BLACK_STAINED_GLASS_PANE:
                case BLACK_TERRACOTTA:
                case BLACK_WOOL:
                    return prop("color", "black");
                case BLUE_CARPET:
                case BLUE_CONCRETE:
                case BLUE_CONCRETE_POWDER:
                case BLUE_STAINED_GLASS:
                case BLUE_STAINED_GLASS_PANE:
                case BLUE_TERRACOTTA:
                case BLUE_WOOL:
                    return prop("color", "blue");
                case BROWN_CARPET:
                case BROWN_CONCRETE:
                case BROWN_CONCRETE_POWDER:
                case BROWN_STAINED_GLASS:
                case BROWN_STAINED_GLASS_PANE:
                case BROWN_TERRACOTTA:
                case BROWN_WOOL:
                    return prop("color", "brown");
                case CYAN_CARPET:
                case CYAN_CONCRETE:
                case CYAN_CONCRETE_POWDER:
                case CYAN_STAINED_GLASS:
                case CYAN_STAINED_GLASS_PANE:
                case CYAN_TERRACOTTA:
                case CYAN_WOOL:
                    return prop("color", "cyan");
                case GRAY_CARPET:
                case GRAY_CONCRETE:
                case GRAY_CONCRETE_POWDER:
                case GRAY_STAINED_GLASS:
                case GRAY_STAINED_GLASS_PANE:
                case GRAY_TERRACOTTA:
                case GRAY_WOOL:
                    return prop("color", "gray");
                case GREEN_CARPET:
                case GREEN_CONCRETE:
                case GREEN_CONCRETE_POWDER:
                case GREEN_STAINED_GLASS:
                case GREEN_STAINED_GLASS_PANE:
                case GREEN_TERRACOTTA:
                case GREEN_WOOL:
                    return prop("color", "green");
                case LIGHT_BLUE_CARPET:
                case LIGHT_BLUE_CONCRETE:
                case LIGHT_BLUE_CONCRETE_POWDER:
                case LIGHT_BLUE_STAINED_GLASS:
                case LIGHT_BLUE_STAINED_GLASS_PANE:
                case LIGHT_BLUE_TERRACOTTA:
                case LIGHT_BLUE_WOOL:
                    return prop("color", "light_blue");
                case LIGHT_GRAY_CARPET:
                case LIGHT_GRAY_CONCRETE:
                case LIGHT_GRAY_CONCRETE_POWDER:
                case LIGHT_GRAY_STAINED_GLASS:
                case LIGHT_GRAY_STAINED_GLASS_PANE:
                case LIGHT_GRAY_TERRACOTTA:
                case LIGHT_GRAY_WOOL:
                    return prop("color", "silver");
                case LIME_CARPET:
                case LIME_CONCRETE:
                case LIME_CONCRETE_POWDER:
                case LIME_STAINED_GLASS:
                case LIME_STAINED_GLASS_PANE:
                case LIME_TERRACOTTA:
                case LIME_WOOL:
                    return prop("color", "lime");
                case MAGENTA_CARPET:
                case MAGENTA_CONCRETE:
                case MAGENTA_CONCRETE_POWDER:
                case MAGENTA_STAINED_GLASS:
                case MAGENTA_STAINED_GLASS_PANE:
                case MAGENTA_TERRACOTTA:
                case MAGENTA_WOOL:
                    return prop("color", "magenta");
                case ORANGE_CARPET:
                case ORANGE_CONCRETE:
                case ORANGE_CONCRETE_POWDER:
                case ORANGE_STAINED_GLASS:
                case ORANGE_STAINED_GLASS_PANE:
                case ORANGE_TERRACOTTA:
                case ORANGE_WOOL:
                    return prop("color", "orange");
                case PINK_CARPET:
                case PINK_CONCRETE:
                case PINK_CONCRETE_POWDER:
                case PINK_STAINED_GLASS:
                case PINK_STAINED_GLASS_PANE:
                case PINK_TERRACOTTA:
                case PINK_WOOL:
                    return prop("color", "pink");
                case PURPLE_CARPET:
                case PURPLE_CONCRETE:
                case PURPLE_CONCRETE_POWDER:
                case PURPLE_STAINED_GLASS:
                case PURPLE_STAINED_GLASS_PANE:
                case PURPLE_TERRACOTTA:
                case PURPLE_WOOL:
                    return prop("color", "purple");
                case RED_CARPET:
                case RED_CONCRETE:
                case RED_CONCRETE_POWDER:
                case RED_STAINED_GLASS:
                case RED_STAINED_GLASS_PANE:
                case RED_TERRACOTTA:
                case RED_WOOL:
                    return prop("color", "red");
                case WHITE_CARPET:
                case WHITE_CONCRETE:
                case WHITE_CONCRETE_POWDER:
                case WHITE_STAINED_GLASS:
                case WHITE_STAINED_GLASS_PANE:
                case WHITE_TERRACOTTA:
                case WHITE_WOOL:
                    return prop("color", "white");
                case YELLOW_CARPET:
                case YELLOW_CONCRETE:
                case YELLOW_CONCRETE_POWDER:
                case YELLOW_STAINED_GLASS:
                case YELLOW_STAINED_GLASS_PANE:
                case YELLOW_TERRACOTTA:
                case YELLOW_WOOL:
                    return prop("color", "yellow");
            }
            throw new IllegalStateException();
        }


        public Req colKey(MinecraftBlock b) {
            switch (b) {
                case LIGHT_GRAY_CARPET:
                case GRAY_CARPET:
                case YELLOW_CARPET:
                case BROWN_CARPET:
                case GREEN_CARPET:
                case CYAN_CARPET:
                case PINK_CARPET:
                case BLACK_CARPET:
                case LIGHT_BLUE_CARPET:
                case BLUE_CARPET:
                case WHITE_CARPET:
                case LIME_CARPET:
                case PURPLE_CARPET:
                case ORANGE_CARPET:
                case RED_CARPET:
                case MAGENTA_CARPET:
                    return key("carpet");
                case LIGHT_GRAY_STAINED_GLASS:
                case GRAY_STAINED_GLASS:
                case YELLOW_STAINED_GLASS:
                case BROWN_STAINED_GLASS:
                case GREEN_STAINED_GLASS:
                case CYAN_STAINED_GLASS:
                case PINK_STAINED_GLASS:
                case BLACK_STAINED_GLASS:
                case LIGHT_BLUE_STAINED_GLASS:
                case BLUE_STAINED_GLASS:
                case WHITE_STAINED_GLASS:
                case LIME_STAINED_GLASS:
                case PURPLE_STAINED_GLASS:
                case ORANGE_STAINED_GLASS:
                case RED_STAINED_GLASS:
                case MAGENTA_STAINED_GLASS:
                    return key("stained_glass");
                case LIGHT_GRAY_CONCRETE_POWDER:
                case GRAY_CONCRETE_POWDER:
                case YELLOW_CONCRETE_POWDER:
                case BROWN_CONCRETE_POWDER:
                case GREEN_CONCRETE_POWDER:
                case CYAN_CONCRETE_POWDER:
                case PINK_CONCRETE_POWDER:
                case BLACK_CONCRETE_POWDER:
                case LIGHT_BLUE_CONCRETE_POWDER:
                case BLUE_CONCRETE_POWDER:
                case WHITE_CONCRETE_POWDER:
                case LIME_CONCRETE_POWDER:
                case PURPLE_CONCRETE_POWDER:
                case ORANGE_CONCRETE_POWDER:
                case RED_CONCRETE_POWDER:
                case MAGENTA_CONCRETE_POWDER:
                    return key("concrete_powder");
                case LIGHT_GRAY_WOOL:
                case GRAY_WOOL:
                case YELLOW_WOOL:
                case BROWN_WOOL:
                case GREEN_WOOL:
                case CYAN_WOOL:
                case PINK_WOOL:
                case BLACK_WOOL:
                case LIGHT_BLUE_WOOL:
                case BLUE_WOOL:
                case WHITE_WOOL:
                case LIME_WOOL:
                case PURPLE_WOOL:
                case ORANGE_WOOL:
                case RED_WOOL:
                case MAGENTA_WOOL:
                    return key("wool");
                case LIGHT_GRAY_CONCRETE:
                case GRAY_CONCRETE:
                case YELLOW_CONCRETE:
                case BROWN_CONCRETE:
                case GREEN_CONCRETE:
                case CYAN_CONCRETE:
                case PINK_CONCRETE:
                case BLACK_CONCRETE:
                case LIGHT_BLUE_CONCRETE:
                case BLUE_CONCRETE:
                case WHITE_CONCRETE:
                case LIME_CONCRETE:
                case PURPLE_CONCRETE:
                case ORANGE_CONCRETE:
                case RED_CONCRETE:
                case MAGENTA_CONCRETE:
                    return key("concrete");
                case LIGHT_GRAY_STAINED_GLASS_PANE:
                case GRAY_STAINED_GLASS_PANE:
                case YELLOW_STAINED_GLASS_PANE:
                case BROWN_STAINED_GLASS_PANE:
                case GREEN_STAINED_GLASS_PANE:
                case CYAN_STAINED_GLASS_PANE:
                case PINK_STAINED_GLASS_PANE:
                case BLACK_STAINED_GLASS_PANE:
                case LIGHT_BLUE_STAINED_GLASS_PANE:
                case BLUE_STAINED_GLASS_PANE:
                case WHITE_STAINED_GLASS_PANE:
                case LIME_STAINED_GLASS_PANE:
                case PURPLE_STAINED_GLASS_PANE:
                case ORANGE_STAINED_GLASS_PANE:
                case RED_STAINED_GLASS_PANE:
                case MAGENTA_STAINED_GLASS_PANE:
                    return key("stained_glass_pane");
                case LIGHT_GRAY_TERRACOTTA:
                case GRAY_TERRACOTTA:
                case YELLOW_TERRACOTTA:
                case BROWN_TERRACOTTA:
                case GREEN_TERRACOTTA:
                case CYAN_TERRACOTTA:
                case PINK_TERRACOTTA:
                case BLACK_TERRACOTTA:
                case LIGHT_BLUE_TERRACOTTA:
                case BLUE_TERRACOTTA:
                case WHITE_TERRACOTTA:
                case LIME_TERRACOTTA:
                case PURPLE_TERRACOTTA:
                case ORANGE_TERRACOTTA:
                case RED_TERRACOTTA:
                case MAGENTA_TERRACOTTA:
                    return key("stained_hardened_clay");
            }
            throw new IllegalStateException();
        }
    }
    public static BlockRequest getLinker(MinecraftBlock b) {
        Req r = m112(b);
        switch (b) {

            case OAK_BUTTON:
                return r.key("wooden_button");
            case ACACIA_BUTTON:
            case BIRCH_BUTTON:
            case DARK_OAK_BUTTON:
            case JUNGLE_BUTTON:
            case SPRUCE_BUTTON:
                return r.partially(OAK_BUTTON);
                
                
            case OAK_DOOR:
                return r.key("wooden_door");
            case ACACIA_DOOR:
            case BIRCH_DOOR:
            case DARK_OAK_DOOR:
            case JUNGLE_DOOR:
            case SPRUCE_DOOR:
                return r.partially(OAK_DOOR);
                
                
            case OAK_TRAPDOOR:
                return r.key("trapdoor");
            case ACACIA_TRAPDOOR:
            case BIRCH_TRAPDOOR:
            case DARK_OAK_TRAPDOOR:
            case JUNGLE_TRAPDOOR:
            case SPRUCE_TRAPDOOR:
                return r.partially(OAK_TRAPDOOR);
                
                
            case BIRCH_LEAVES:
            case JUNGLE_LEAVES:
            case OAK_LEAVES:
            case SPRUCE_LEAVES:
            case ACACIA_LEAVES:
            case DARK_OAK_LEAVES:
            case ACACIA_WOOD:
            case BIRCH_WOOD:
            case DARK_OAK_WOOD:
            case JUNGLE_WOOD:
            case OAK_WOOD:
            case SPRUCE_WOOD:
            case ACACIA_PLANKS:
            case BIRCH_PLANKS:
            case DARK_OAK_PLANKS:
            case JUNGLE_PLANKS:
            case OAK_PLANKS:
            case SPRUCE_PLANKS:
            case ACACIA_SAPLING:
            case BIRCH_SAPLING:
            case DARK_OAK_SAPLING:
            case JUNGLE_SAPLING:
            case OAK_SAPLING:
            case SPRUCE_SAPLING:
            case ACACIA_SLAB:
            case BIRCH_SLAB:
            case DARK_OAK_SLAB:
            case JUNGLE_SLAB:
            case OAK_SLAB:
            case SPRUCE_SLAB:
                return r.logKey(b).logVar(b);
            case STRIPPED_ACACIA_WOOD:
                return r.wellSub(ACACIA_WOOD);
            case STRIPPED_BIRCH_WOOD:
                return r.wellSub(BIRCH_WOOD);
            case STRIPPED_DARK_OAK_WOOD:
                return r.wellSub(DARK_OAK_WOOD);
            case STRIPPED_JUNGLE_WOOD:
                return r.wellSub(JUNGLE_WOOD);
            case STRIPPED_OAK_WOOD:
                return r.wellSub(OAK_WOOD);
            case STRIPPED_SPRUCE_WOOD:
                return r.wellSub(SPRUCE_WOOD);
                
                
            case BIRCH_LOG:
            case JUNGLE_LOG:
            case OAK_LOG:
            case SPRUCE_LOG:
            case ACACIA_LOG:
            case DARK_OAK_LOG:
                return r.logKey(b).logVar(b).prop("axis", "none");
            case STRIPPED_BIRCH_LOG:
                return r.wellSub(BIRCH_LOG);
            case STRIPPED_JUNGLE_LOG:
                return r.wellSub(JUNGLE_LOG);
            case STRIPPED_OAK_LOG:
                return r.wellSub(OAK_LOG);
            case STRIPPED_SPRUCE_LOG:
                return r.wellSub(SPRUCE_LOG);
            case STRIPPED_ACACIA_LOG:
                return r.wellSub(ACACIA_LOG);
            case STRIPPED_DARK_OAK_LOG:
                return r.wellSub(DARK_OAK_LOG);


            case RED_BED:
                return r.key("bed");
            case BLACK_BED:
            case BLUE_BED:
            case BROWN_BED:
            case CYAN_BED:
            case GRAY_BED:
            case GREEN_BED:
            case LIGHT_BLUE_BED:
            case LIGHT_GRAY_BED:
            case LIME_BED:
            case MAGENTA_BED:
            case ORANGE_BED:
            case PINK_BED:
            case PURPLE_BED:
            case WHITE_BED:
            case YELLOW_BED:
                return r.partially(RED_BED);
                
                
            case BLACK_CARPET:
            case BLACK_CONCRETE:
            case BLACK_CONCRETE_POWDER:
            case BLACK_STAINED_GLASS:
            case BLACK_STAINED_GLASS_PANE:
            case BLACK_TERRACOTTA:
            case BLACK_WOOL:
            case BLUE_CARPET:
            case BLUE_CONCRETE:
            case BLUE_CONCRETE_POWDER:
            case BLUE_STAINED_GLASS:
            case BLUE_STAINED_GLASS_PANE:
            case BLUE_TERRACOTTA:
            case BLUE_WOOL:
            case BROWN_CARPET:
            case BROWN_CONCRETE:
            case BROWN_CONCRETE_POWDER:
            case BROWN_STAINED_GLASS:
            case BROWN_STAINED_GLASS_PANE:
            case BROWN_TERRACOTTA:
            case BROWN_WOOL:
            case CYAN_CARPET:
            case CYAN_CONCRETE:
            case CYAN_CONCRETE_POWDER:
            case CYAN_STAINED_GLASS:
            case CYAN_STAINED_GLASS_PANE:
            case CYAN_TERRACOTTA:
            case CYAN_WOOL:
            case GRAY_CARPET:
            case GRAY_CONCRETE:
            case GRAY_CONCRETE_POWDER:
            case GRAY_STAINED_GLASS:
            case GRAY_STAINED_GLASS_PANE:
            case GRAY_TERRACOTTA:
            case GRAY_WOOL:
            case GREEN_CARPET:
            case GREEN_CONCRETE:
            case GREEN_CONCRETE_POWDER:
            case GREEN_STAINED_GLASS:
            case GREEN_STAINED_GLASS_PANE:
            case GREEN_TERRACOTTA:
            case GREEN_WOOL:
            case LIGHT_BLUE_CARPET:
            case LIGHT_BLUE_CONCRETE:
            case LIGHT_BLUE_CONCRETE_POWDER:
            case LIGHT_BLUE_STAINED_GLASS:
            case LIGHT_BLUE_STAINED_GLASS_PANE:
            case LIGHT_BLUE_TERRACOTTA:
            case LIGHT_BLUE_WOOL:
            case LIGHT_GRAY_CARPET:
            case LIGHT_GRAY_CONCRETE:
            case LIGHT_GRAY_CONCRETE_POWDER:
            case LIGHT_GRAY_STAINED_GLASS:
            case LIGHT_GRAY_STAINED_GLASS_PANE:
            case LIGHT_GRAY_TERRACOTTA:
            case LIGHT_GRAY_WOOL:
            case LIME_CARPET:
            case LIME_CONCRETE:
            case LIME_CONCRETE_POWDER:
            case LIME_STAINED_GLASS:
            case LIME_STAINED_GLASS_PANE:
            case LIME_TERRACOTTA:
            case LIME_WOOL:
            case MAGENTA_CARPET:
            case MAGENTA_CONCRETE:
            case MAGENTA_CONCRETE_POWDER:
            case MAGENTA_STAINED_GLASS:
            case MAGENTA_STAINED_GLASS_PANE:
            case MAGENTA_TERRACOTTA:
            case MAGENTA_WOOL:
            case ORANGE_CARPET:
            case ORANGE_CONCRETE:
            case ORANGE_CONCRETE_POWDER:
            case ORANGE_STAINED_GLASS:
            case ORANGE_STAINED_GLASS_PANE:
            case ORANGE_TERRACOTTA:
            case ORANGE_WOOL:
            case PINK_CARPET:
            case PINK_CONCRETE:
            case PINK_CONCRETE_POWDER:
            case PINK_STAINED_GLASS:
            case PINK_STAINED_GLASS_PANE:
            case PINK_TERRACOTTA:
            case PINK_WOOL:
            case PURPLE_CARPET:
            case PURPLE_CONCRETE:
            case PURPLE_CONCRETE_POWDER:
            case PURPLE_STAINED_GLASS:
            case PURPLE_STAINED_GLASS_PANE:
            case PURPLE_TERRACOTTA:
            case PURPLE_WOOL:
            case RED_CARPET:
            case RED_CONCRETE:
            case RED_CONCRETE_POWDER:
            case RED_STAINED_GLASS:
            case RED_STAINED_GLASS_PANE:
            case RED_TERRACOTTA:
            case RED_WOOL:
            case WHITE_CARPET:
            case WHITE_CONCRETE:
            case WHITE_CONCRETE_POWDER:
            case WHITE_STAINED_GLASS:
            case WHITE_STAINED_GLASS_PANE:
            case WHITE_TERRACOTTA:
            case WHITE_WOOL:
            case YELLOW_CARPET:
            case YELLOW_CONCRETE:
            case YELLOW_CONCRETE_POWDER:
            case YELLOW_STAINED_GLASS:
            case YELLOW_STAINED_GLASS_PANE:
            case YELLOW_TERRACOTTA:
            case YELLOW_WOOL:
                return r.colKey(b).colVar(b);


            case BLACK_BANNER:
            case BLUE_BANNER:
            case BROWN_BANNER:
            case CYAN_BANNER:
            case GRAY_BANNER:
            case GREEN_BANNER:
            case LIGHT_BLUE_BANNER:
            case LIGHT_GRAY_BANNER:
            case LIME_BANNER:
            case MAGENTA_BANNER:
            case ORANGE_BANNER:
            case PINK_BANNER:
            case PURPLE_BANNER:
            case RED_BANNER:
            case WHITE_BANNER:
            case YELLOW_BANNER:
                return r.key("standing_banner"); //todo nbt 

            case BLACK_WALL_BANNER:
            case BLUE_WALL_BANNER:
            case BROWN_WALL_BANNER:
            case CYAN_WALL_BANNER:
            case GRAY_WALL_BANNER:
            case GREEN_WALL_BANNER:
            case LIGHT_BLUE_WALL_BANNER:
            case LIGHT_GRAY_WALL_BANNER:
            case LIME_WALL_BANNER:
            case MAGENTA_WALL_BANNER:
            case ORANGE_WALL_BANNER:
            case PINK_WALL_BANNER:
            case PURPLE_WALL_BANNER:
            case RED_WALL_BANNER:
            case WHITE_WALL_BANNER:
            case YELLOW_WALL_BANNER:
                return r.key("wall_banner"); //todo nbt 


            case OAK_PRESSURE_PLATE:
                return r.key("wooden_pressure_plate");
            case ACACIA_PRESSURE_PLATE:
            case BIRCH_PRESSURE_PLATE:
            case DARK_OAK_PRESSURE_PLATE:
            case JUNGLE_PRESSURE_PLATE:
            case SPRUCE_PRESSURE_PLATE:
                return r.partially(OAK_PRESSURE_PLATE);


            case OAK_FENCE:
                return r.key("fence");
            case ACACIA_FENCE:
            case BIRCH_FENCE:
            case DARK_OAK_FENCE:
            case JUNGLE_FENCE:
            case NETHER_BRICK_FENCE:
            case SPRUCE_FENCE:
                return r.partially(OAK_PRESSURE_PLATE);

                
            case OAK_FENCE_GATE:
                return r.key("fence_gate");
            case ACACIA_FENCE_GATE:
            case BIRCH_FENCE_GATE:
            case DARK_OAK_FENCE_GATE:
            case JUNGLE_FENCE_GATE:
            case SPRUCE_FENCE_GATE:
                return r.partially(OAK_PRESSURE_PLATE);


            case POTTED_ACACIA_SAPLING:
            case POTTED_BIRCH_SAPLING:
            case POTTED_DARK_OAK_SAPLING:
            case POTTED_JUNGLE_SAPLING:
            case POTTED_OAK_SAPLING:
            case POTTED_SPRUCE_SAPLING:
            case POTTED_ALLIUM:
            case POTTED_AZURE_BLUET:
            case POTTED_BLUE_ORCHID:
            case POTTED_BROWN_MUSHROOM:
            case POTTED_CACTUS:
            case POTTED_DANDELION:
            case POTTED_DEAD_BUSH:
            case POTTED_FERN:
            case POTTED_ORANGE_TULIP:
            case POTTED_OXEYE_DAISY:
            case POTTED_PINK_TULIP:
            case POTTED_POPPY:
            case POTTED_RED_MUSHROOM:
            case POTTED_RED_TULIP:
            case POTTED_WHITE_TULIP:
                return r.key("flower_pot"); //todo nbt


            case BRAIN_CORAL:
            case BRAIN_CORAL_BLOCK:
            case BRAIN_CORAL_FAN:
            case BRAIN_CORAL_WALL_FAN:
            case BUBBLE_CORAL:
            case BUBBLE_CORAL_BLOCK:
            case BUBBLE_CORAL_FAN:
            case BUBBLE_CORAL_WALL_FAN:
            case DEAD_BRAIN_CORAL:
            case DEAD_BRAIN_CORAL_BLOCK:
            case DEAD_BRAIN_CORAL_FAN:
            case DEAD_BRAIN_CORAL_WALL_FAN:
            case DEAD_BUBBLE_CORAL:
            case DEAD_BUBBLE_CORAL_BLOCK:
            case DEAD_BUBBLE_CORAL_FAN:
            case DEAD_BUBBLE_CORAL_WALL_FAN:
            case DEAD_FIRE_CORAL:
            case DEAD_FIRE_CORAL_BLOCK:
            case DEAD_FIRE_CORAL_FAN:
            case DEAD_FIRE_CORAL_WALL_FAN:
            case DEAD_HORN_CORAL:
            case DEAD_HORN_CORAL_BLOCK:
            case DEAD_HORN_CORAL_FAN:
            case DEAD_HORN_CORAL_WALL_FAN:
            case DEAD_TUBE_CORAL:
            case DEAD_TUBE_CORAL_BLOCK:
            case DEAD_TUBE_CORAL_FAN:
            case DEAD_TUBE_CORAL_WALL_FAN:
            case FIRE_CORAL:
            case FIRE_CORAL_BLOCK:
            case FIRE_CORAL_FAN:
            case FIRE_CORAL_WALL_FAN:
            case HORN_CORAL:
            case HORN_CORAL_BLOCK:
            case HORN_CORAL_FAN:
            case HORN_CORAL_WALL_FAN:
            case TUBE_CORAL:
            case TUBE_CORAL_BLOCK:
            case TUBE_CORAL_FAN:
            case TUBE_CORAL_WALL_FAN:
                return r.unavailable(STONE);


            case CAVE_AIR:
            case VOID_AIR:
                return r.partially(AIR);



            case INFESTED_STONE:
                return r.key("monster_egg");
            case INFESTED_CHISELED_STONE_BRICKS:
                return r.key(INFESTED_STONE).variant("chiseled_brick");
            case INFESTED_COBBLESTONE:
                return r.key(INFESTED_STONE).variant("cobblestone");
            case INFESTED_CRACKED_STONE_BRICKS:
                return r.key(INFESTED_STONE).variant("cracked_brick");
            case INFESTED_MOSSY_STONE_BRICKS:
                return r.key(INFESTED_STONE).variant("mossy_brick");
            case INFESTED_STONE_BRICKS:
                return r.key(INFESTED_STONE).variant("stone_brick");


            case LIGHT_GRAY_GLAZED_TERRACOTTA: //special
                return r.key("silver_glazed_terracotta");
            case LIGHT_GRAY_SHULKER_BOX: //special
                return r.key("silver_shulker_box");

                
            case ANDESITE:
                return r.key(STONE).variant("andesite");
            case GRANITE:
                return r.key(STONE).variant("granite");
            case DIORITE:
                return r.key(STONE).variant("diorite");
            case POLISHED_ANDESITE:
                return r.key(STONE).variant("smooth_andesite");
            case POLISHED_DIORITE:
                return r.key(STONE).variant("smooth_diorite");
            case POLISHED_GRANITE:
                return r.key(STONE).variant("smooth_granite");
                
                
            case STONE_BRICKS:
                return r.key("stonebrick");
            case CHISELED_STONE_BRICKS:
                return r.key(STONE_BRICKS).variant("chiseled_stonebrick");
            case CRACKED_STONE_BRICKS:
                return r.key(STONE_BRICKS).variant("cracked_stonebrick");
            case MOSSY_STONE_BRICKS:
                return r.key(STONE_BRICKS).variant("mossy_stonebrick");


            case COARSE_DIRT:
                return r.key(DIRT).variant("coarse_dirt");
            case PODZOL:
                return r.key(DIRT).variant("podzol");
                

            case CHISELED_SANDSTONE:
                return r.key(SANDSTONE).prop("type", "chiseled_sandstone");
            case SMOOTH_SANDSTONE:
                return r.key(SANDSTONE).prop("type", "smooth_sandstone");
            case CUT_SANDSTONE:
                return r.wellSub(SMOOTH_SANDSTONE);


            case CHISELED_RED_SANDSTONE:
                return r.key(RED_SANDSTONE).prop("type", "chiseled_red_sandstone");
            case SMOOTH_RED_SANDSTONE:
                return r.key(RED_SANDSTONE).prop("type", "smooth_red_sandstone");
            case CUT_RED_SANDSTONE:
                return r.wellSub(SMOOTH_RED_SANDSTONE);

                
            case CHIPPED_ANVIL:
                return r.key(ANVIL).prop("damage", 1);
            case DAMAGED_ANVIL:
                return r.key(ANVIL).prop("damage", 2);
            case CHISELED_QUARTZ_BLOCK:
                return r.key(QUARTZ_BLOCK).variant("chiseled");
            case QUARTZ_PILLAR:
                return r.key(QUARTZ_BLOCK).variant("linesY");
            case SMOOTH_QUARTZ:
                return r.partially(QUARTZ_BLOCK);
                
                
            case WITHER_SKELETON_SKULL:
            case WITHER_SKELETON_WALL_SKULL:
            case ZOMBIE_HEAD:
            case ZOMBIE_WALL_HEAD:
            case CREEPER_HEAD:
            case CREEPER_WALL_HEAD:
            case SKELETON_SKULL:
            case SKELETON_WALL_SKULL:
            case DRAGON_HEAD:
            case DRAGON_WALL_HEAD:
            case PLAYER_HEAD:
            case PLAYER_WALL_HEAD:
                return r.key("skull"); //todo nbt


            case DANDELION:
                return r.key("yellow_flower");
            case PEONY:
            case POPPY:
                return r.key("red_flower");
            case OXEYE_DAISY:
                return r.key(POPPY).prop("type", "oxeye_daisy");
            case BLUE_ORCHID:
                return r.key(POPPY).prop("type", "blue_orchid");
            case ORANGE_TULIP:
                return r.key(POPPY).prop("type", "orange_tulip");
            case PINK_TULIP:
                return r.key(POPPY).prop("type", "pink_tulip");
            case RED_TULIP:
                return r.key(POPPY).prop("type", "red_tulip");
            case WHITE_TULIP:
                return r.key(POPPY).prop("type", "white_tulip");
            case ALLIUM:
                return r.key(POPPY).prop("type", "allium");
            case AZURE_BLUET:
                return r.key(POPPY).prop("type", "houstonia");


            case CARVED_PUMPKIN:
                return r.key(PUMPKIN);
            case JACK_O_LANTERN:
                return r.key("LIT_PUMPKIN");
            case ATTACHED_MELON_STEM:
                return r.wellSub(MELON_STEM); //if not facing up add way to represent that
            case ATTACHED_PUMPKIN_STEM:
                return r.wellSub(PUMPKIN_STEM); //if not facing up add way to represent that
            case MELON:
                return r.key("melon_block");


            case DARK_PRISMARINE:
                return r.key(PRISMARINE).variant("dark_prismarine");
            case PRISMARINE_BRICKS:
                return r.key(PRISMARINE).variant("prismarine_bricks");


            //various renames
            case BRICKS:
                return r.key("brick_block");
            case GRASS_BLOCK:
                return r.key("grass");
            case NOTE_BLOCK:
                return r.key("noteblock");
            case WET_SPONGE:
                return r.key(SPONGE).propTrue("WET");
            case TERRACOTTA:
                return r.key("hardened_clay");
            case SHULKER_BOX:
                return r.key(PURPLE_SHULKER_BOX);
            case BLUE_ICE:
                return r.wellSub(ICE);
            case RED_NETHER_BRICKS:
                return r.key("red_nether_brick");
            case END_STONE_BRICKS:
                return r.key("end_bricks");
            case MOSSY_COBBLESTONE_WALL:
                return r.key(COBBLESTONE_WALL).variant("mossy_cobblestone");
            case RED_SAND:
                return r.key(SAND).variant("red_sand");
            case DRIED_KELP_BLOCK:
                return r.badSub(HAY_BLOCK);
            case SUGAR_CANE:
                return r.key("reeds");
            case BUBBLE_COLUMN:
                return r.wellSub(WATER);
            case SPAWNER:
                return r.key("mob_spawner");
            case MAGMA_BLOCK:
                return r.key("magma");
            case NETHER_BRICKS:
                return r.key("nether_brick");
            case WALL_TORCH:
                return r.key("torch"); //consider different blockstates
            case COBWEB:
                return r.key("web");
            case SNOW:
                return r.key("snow_layer");
            case NETHER_QUARTZ_ORE:
                return r.key("quartz_ore");
            case COMPARATOR:
                return r.key("unpowered_comparator"); //todo allow m/n mapping (powered_comparator)
            case REPEATER:
                return r.key("unpowered_repeater"); //todo powered_repeater
            case SLIME_BLOCK:
                return r.key("slime");
            case SNOW_BLOCK:
                return r.key("snow");
            case REDSTONE_WALL_TORCH:
                return r.key("redstone_torch"); //todo unlit_redstone_torch
            case NETHER_PORTAL:
                return r.key("portal");
            case LILY_PAD:
                return r.key("waterlily");
            case COBBLESTONE_STAIRS:
                return r.key("stone_stairs ");
            case DARK_PRISMARINE_STAIRS:
            case PRISMARINE_BRICK_STAIRS:
            case PRISMARINE_STAIRS:
                return r.wellSub(PURPUR_STAIRS);
            
            
            case PURPUR_SLAB: //same
            case STONE_SLAB:

                
                
                

            case BRICK_STAIRS: //same
            case NETHER_BRICK_STAIRS:
            case PURPUR_STAIRS:
            case QUARTZ_STAIRS:
            case RED_SANDSTONE_STAIRS:
            case SANDSTONE_STAIRS:
            case STONE_BRICK_STAIRS:


            case ACACIA_STAIRS: //same
            case BIRCH_STAIRS:
            case DARK_OAK_STAIRS:
            case JUNGLE_STAIRS:
            case OAK_STAIRS:
            case SPRUCE_STAIRS:












            case AIR://same

            case BLACK_GLAZED_TERRACOTTA: //same
            case BLUE_GLAZED_TERRACOTTA:
            case BROWN_GLAZED_TERRACOTTA:
            case CYAN_GLAZED_TERRACOTTA:
            case GRAY_GLAZED_TERRACOTTA:
            case GREEN_GLAZED_TERRACOTTA:
            case LIGHT_BLUE_GLAZED_TERRACOTTA:
            case LIME_GLAZED_TERRACOTTA:
            case MAGENTA_GLAZED_TERRACOTTA:
            case ORANGE_GLAZED_TERRACOTTA:
            case PINK_GLAZED_TERRACOTTA:
            case PURPLE_GLAZED_TERRACOTTA:
            case RED_GLAZED_TERRACOTTA:
            case WHITE_GLAZED_TERRACOTTA:
            case YELLOW_GLAZED_TERRACOTTA:


            case BLACK_SHULKER_BOX: //same
            case BLUE_SHULKER_BOX:
            case BROWN_SHULKER_BOX:
            case CYAN_SHULKER_BOX:
            case GRAY_SHULKER_BOX:
            case GREEN_SHULKER_BOX:
            case LIGHT_BLUE_SHULKER_BOX:
            case LIME_SHULKER_BOX:
            case MAGENTA_SHULKER_BOX:
            case ORANGE_SHULKER_BOX:
            case PINK_SHULKER_BOX:
            case PURPLE_SHULKER_BOX:
            case RED_SHULKER_BOX:
            case WHITE_SHULKER_BOX:
            case YELLOW_SHULKER_BOX:



            case BROWN_MUSHROOM_BLOCK: //same
            case RED_MUSHROOM:
            case RED_MUSHROOM_BLOCK:
            case RED_SANDSTONE:
            case ACTIVATOR_RAIL:
            case ANVIL:
            case BARRIER:
            case BEACON:
            case BEDROCK:
            case BEETROOTS:
            case STONE_PRESSURE_PLATE:
            case HEAVY_WEIGHTED_PRESSURE_PLATE:
            case LIGHT_WEIGHTED_PRESSURE_PLATE:
            case BONE_BLOCK:
            case BOOKSHELF:
            case BREWING_STAND:
            case CACTUS:
            case CAKE:
            case CARROTS:
            case CAULDRON:
            case CHAIN_COMMAND_BLOCK:
            case CHEST:
            case CHORUS_FLOWER:
            case CHORUS_PLANT:
            case CLAY:
            case COAL_BLOCK:
            case COAL_ORE:
            case COBBLESTONE:
            case COBBLESTONE_WALL:
            case COCOA:
            case COMMAND_BLOCK:
            case CRAFTING_TABLE:
            case DAYLIGHT_DETECTOR:
            case DETECTOR_RAIL:
            case DIAMOND_BLOCK:
            case DIAMOND_ORE:
            case DIRT:
            case DISPENSER:
            case DROPPER:
            case EMERALD_BLOCK:
            case EMERALD_ORE:
            case ENCHANTING_TABLE:
            case ENDER_CHEST:
            case END_PORTAL:
            case END_PORTAL_FRAME:
            case END_ROD:
            case END_STONE:
            case FARMLAND:
            case FIRE:
            case FLOWER_POT:
            case FROSTED_ICE:
            case FURNACE:
            case GLASS:
            case GLASS_PANE:
            case GLOWSTONE:
            case GOLD_BLOCK:
            case GOLD_ORE:
            case GRASS:
            case GRASS_PATH:
            case GRAVEL:
            case HAY_BLOCK:
            case HOPPER:
            case ICE:
            case IRON_BARS:
            case IRON_BLOCK:
            case IRON_DOOR:
            case IRON_ORE:
            case IRON_TRAPDOOR:
            case JUKEBOX:
            case LADDER:
            case LAPIS_BLOCK:
            case LAPIS_ORE:
            case LAVA:
            case LEVER:
            case MELON_STEM:
            case MOSSY_COBBLESTONE:
            case MYCELIUM:
            case NETHERRACK:
            case NETHER_WART:
            case NETHER_WART_BLOCK:
            case OBSERVER:
            case OBSIDIAN:
            case PACKED_ICE:
            case PISTON:
            case PISTON_HEAD:
            case POTATOES:
            case PRISMARINE:
            case PUMPKIN:
            case PUMPKIN_STEM:
            case PURPUR_BLOCK:
            case PURPUR_PILLAR:
            case QUARTZ_BLOCK:
            case RAIL:
            case REDSTONE_BLOCK:
            case REDSTONE_LAMP:
            case REDSTONE_ORE:
            case REDSTONE_TORCH:
            case REDSTONE_WIRE:
            case REPEATING_COMMAND_BLOCK:
            case SAND:
            case SANDSTONE:
            case SEA_LANTERN:
            case SOUL_SAND:
            case SPONGE:
            case STICKY_PISTON:
            case STONE:
            case STONE_BUTTON:
            case STRUCTURE_BLOCK:
            case STRUCTURE_VOID:
            case TNT:
            case TORCH:
            case TRAPPED_CHEST:
            case TRIPWIRE:
            case TRIPWIRE_HOOK:
            case VINE:
            case WALL_SIGN:
            case WATER:
            case WHEAT:


            
                //differnt or new
            case COBBLESTONE_SLAB:
            case DARK_PRISMARINE_SLAB:
            case BRICK_SLAB:
            case NETHER_BRICK_SLAB:
            case PETRIFIED_OAK_SLAB:
            case PRISMARINE_BRICK_SLAB:
            case PRISMARINE_SLAB:
            case QUARTZ_SLAB:
            case RED_SANDSTONE_SLAB:
            case SANDSTONE_SLAB:
            case STONE_BRICK_SLAB:
                //return r.unavailable(Magma_cre) //allow item substitute
            case TURTLE_EGG: //allow item substitute
            case CONDUIT:
            case KELP:
            case KELP_PLANT:
            case MOVING_PISTON:
            case MUSHROOM_STEM:
            case SEAGRASS:
            case SEA_PICKLE:
            case SIGN:
            case SMOOTH_STONE:
            case POWERED_RAIL:
                
            case ROSE_BUSH:
            case SUNFLOWER:
            case TALL_GRASS:
            case TALL_SEAGRASS:
            case DEAD_BUSH:
            case LILAC:
            case FERN:
            case LARGE_FERN:




            default:
                return m112(b);
        }
    }


    private static Req m112(MinecraftBlock b) {
        return new Req(b);
    }

    /*TODO:
    * No block with name {minecraft:allium} found, got {minecraft:air} instead
No block with name {minecraft:attached_melon_stem} found, got {minecraft:air} instead
No block with name {minecraft:attached_pumpkin_stem} found, got {minecraft:air} instead
No block with name {minecraft:azure_bluet} found, got {minecraft:air} instead
No block with name {minecraft:blue_orchid} found, got {minecraft:air} instead
No block with name {minecraft:brick_slab} found, got {minecraft:air} instead
No block with name {minecraft:cobblestone_slab} found, got {minecraft:air} instead
No block with name {minecraft:cobblestone_stairs} found, got {minecraft:air} instead
No block with name {minecraft:command_block_minecart} found, got {minecraft:air} instead
No block with name {minecraft:conduit} found, got {minecraft:air} instead
No block with name {minecraft:dandelion} found, got {minecraft:air} instead
No block with name {minecraft:dandelion_yellow} found, got {minecraft:air} instead
No block with name {minecraft:dark_prismarine} found, got {minecraft:air} instead
No block with name {minecraft:dark_prismarine_slab} found, got {minecraft:air} instead
No block with name {minecraft:dark_prismarine_stairs} found, got {minecraft:air} instead
No block with name {minecraft:dead_bush} found, got {minecraft:air} instead
No block with name {minecraft:fern} found, got {minecraft:air} instead
No block with name {minecraft:furnace_minecart} found, got {minecraft:air} instead
No block with name {minecraft:kelp} found, got {minecraft:air} instead
No block with name {minecraft:kelp_plant} found, got {minecraft:air} instead
No block with name {minecraft:large_fern} found, got {minecraft:air} instead
No block with name {minecraft:lilac} found, got {minecraft:air} instead
No block with name {minecraft:lily_pad} found, got {minecraft:air} instead
No block with name {minecraft:melon} found, got {minecraft:air} instead
No block with name {minecraft:moving_piston} found, got {minecraft:air} instead
No block with name {minecraft:mushroom_stem} found, got {minecraft:air} instead
No block with name {minecraft:mushroom_stew} found, got {minecraft:air} instead
No block with name {minecraft:nether_brick_slab} found, got {minecraft:air} instead
No block with name {minecraft:orange_tulip} found, got {minecraft:air} instead
No block with name {minecraft:oxeye_daisy} found, got {minecraft:air} instead
No block with name {minecraft:peony} found, got {minecraft:air} instead
No block with name {minecraft:petrified_oak_slab} found, got {minecraft:air} instead
No block with name {minecraft:pink_tulip} found, got {minecraft:air} instead
No block with name {minecraft:poppy} found, got {minecraft:air} instead
No block with name {minecraft:powered_rail} found, got {minecraft:air} instead
No block with name {minecraft:prismarine_bricks} found, got {minecraft:air} instead
No block with name {minecraft:prismarine_brick_slab} found, got {minecraft:air} instead
No block with name {minecraft:prismarine_brick_stairs} found, got {minecraft:air} instead
No block with name {minecraft:prismarine_slab} found, got {minecraft:air} instead
No block with name {minecraft:prismarine_stairs} found, got {minecraft:air} instead
Missing value {linesY} for property {variant} for block {minecraft:quartz_block}
No block with name {minecraft:quartz_slab} found, got {minecraft:air} instead
No block with name {minecraft:red_sandstone_slab} found, got {minecraft:air} instead
No block with name {minecraft:red_tulip} found, got {minecraft:air} instead
No block with name {minecraft:rose_bush} found, got {minecraft:air} instead
No block with name {minecraft:rose_red} found, got {minecraft:air} instead
No block with name {minecraft:sandstone_slab} found, got {minecraft:air} instead
No block with name {minecraft:seagrass} found, got {minecraft:air} instead
No block with name {minecraft:sea_pickle} found, got {minecraft:air} instead
No block with name {minecraft:sign} found, got {minecraft:air} instead
No block with name {minecraft:smooth_stone} found, got {minecraft:air} instead
No block with name {minecraft:stone_brick_slab} found, got {minecraft:air} instead
No block with name {minecraft:sunflower} found, got {minecraft:air} instead
No block with name {minecraft:tall_grass} found, got {minecraft:air} instead
No block with name {minecraft:tall_seagrass} found, got {minecraft:air} instead
No block with name {minecraft:turtle_egg} found, got {minecraft:air} instead
null
No block with name {minecraft:white_tulip} found, got {minecraft:air} instead*/
}
