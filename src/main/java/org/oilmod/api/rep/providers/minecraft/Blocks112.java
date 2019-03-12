package org.oilmod.api.rep.providers.minecraft;

import java.util.function.Function;

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
                    return prop("color", "light_gray");
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
                return r.wellSub(BIRCH_WOOD);
            case STRIPPED_BIRCH_WOOD:
                return r.wellSub(BIRCH_WOOD);
            case STRIPPED_DARK_OAK_WOOD:
                return r.wellSub(BIRCH_WOOD);
            case STRIPPED_JUNGLE_WOOD:
                return r.wellSub(BIRCH_WOOD);
            case STRIPPED_OAK_WOOD:
                return r.wellSub(BIRCH_WOOD);
            case STRIPPED_SPRUCE_WOOD:
                return r.wellSub(BIRCH_WOOD);
                
                
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


            case COBBLESTONE_SLAB:
            case DARK_PRISMARINE_SLAB:
            case BRICK_SLAB:
            case NETHER_BRICK_SLAB:
            case PETRIFIED_OAK_SLAB:
            case PRISMARINE_BRICK_SLAB:
            case PRISMARINE_SLAB:
            case PURPUR_SLAB:
            case QUARTZ_SLAB:
            case RED_SANDSTONE_SLAB:
            case SANDSTONE_SLAB:
            case STONE_BRICK_SLAB:
            case STONE_SLAB:


            case BRICK_STAIRS: //same
            case COBBLESTONE_STAIRS:
            case DARK_PRISMARINE_STAIRS:
            case NETHER_BRICK_STAIRS:
            case PRISMARINE_BRICK_STAIRS:
            case PRISMARINE_STAIRS:
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
            case LIGHT_GRAY_GLAZED_TERRACOTTA:
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
            case LIGHT_GRAY_SHULKER_BOX:
            case LIME_SHULKER_BOX:
            case MAGENTA_SHULKER_BOX:
            case ORANGE_SHULKER_BOX:
            case PINK_SHULKER_BOX:
            case PURPLE_SHULKER_BOX:
            case RED_SHULKER_BOX:
            case WHITE_SHULKER_BOX:
            case YELLOW_SHULKER_BOX:
            case SHULKER_BOX:



            case BLUE_ICE:
            case BLUE_ORCHID:
            case BROWN_MUSHROOM_BLOCK:
            case ORANGE_TULIP:
            case PINK_TULIP:
            case RED_TULIP:
            case WHITE_TULIP:
            case RED_MUSHROOM:
            case RED_MUSHROOM_BLOCK:
            case RED_NETHER_BRICKS:
            case RED_SAND:
            case RED_SANDSTONE:
            case ACTIVATOR_RAIL:
            case ALLIUM:
            case ANDESITE:
            case ANVIL:
            case ATTACHED_MELON_STEM:
            case ATTACHED_PUMPKIN_STEM:
            case AZURE_BLUET:
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
            case BRICKS:
            case BUBBLE_COLUMN:
            case CACTUS:
            case CAKE:
            case CARROTS:
            case CARVED_PUMPKIN:
            case CAULDRON:
            case CHAIN_COMMAND_BLOCK:
            case CHEST:
            case CHIPPED_ANVIL:
            case CHISELED_QUARTZ_BLOCK:
            case CHISELED_RED_SANDSTONE:
            case CHISELED_SANDSTONE:
            case CHISELED_STONE_BRICKS:
            case CHORUS_FLOWER:
            case CHORUS_PLANT:
            case CLAY:
            case COAL_BLOCK:
            case COAL_ORE:
            case COARSE_DIRT:
            case COBBLESTONE:
            case COBBLESTONE_WALL:
            case COBWEB:
            case COCOA:
            case COMMAND_BLOCK:
            case COMMAND_BLOCK_MINECART:
            case COMPARATOR:
            case CONDUIT:
            case CRACKED_STONE_BRICKS:
            case CRAFTING_TABLE:
            case CREEPER_HEAD:
            case CREEPER_WALL_HEAD:
            case CUT_RED_SANDSTONE:
            case CUT_SANDSTONE:
            case DAMAGED_ANVIL:
            case DANDELION:
            case DANDELION_YELLOW:
            case DARK_PRISMARINE:
            case DAYLIGHT_DETECTOR:
            case DEAD_BUSH:
            case DETECTOR_RAIL:
            case DIAMOND_BLOCK:
            case DIAMOND_ORE:
            case DIORITE:
            case DIRT:
            case DISPENSER:
            case DRAGON_HEAD:
            case DRAGON_WALL_HEAD:
            case DRIED_KELP_BLOCK:
            case DROPPER:
            case EMERALD_BLOCK:
            case EMERALD_ORE:
            case ENCHANTING_TABLE:
            case ENDER_CHEST:
            case END_PORTAL:
            case END_PORTAL_FRAME:
            case END_ROD:
            case END_STONE:
            case END_STONE_BRICKS:
            case FARMLAND:
            case FERN:
            case FIRE:
            case FLOWER_POT:
            case FROSTED_ICE:
            case FURNACE:
            case FURNACE_MINECART:
            case GLASS:
            case GLASS_PANE:
            case GLOWSTONE:
            case GOLD_BLOCK:
            case GOLD_ORE:
            case GRANITE:
            case GRASS:
            case GRASS_BLOCK:
            case GRASS_PATH:
            case GRAVEL:
            case HAY_BLOCK:
            case HOPPER:
            case ICE:
            case INFESTED_CHISELED_STONE_BRICKS:
            case INFESTED_COBBLESTONE:
            case INFESTED_CRACKED_STONE_BRICKS:
            case INFESTED_MOSSY_STONE_BRICKS:
            case INFESTED_STONE:
            case INFESTED_STONE_BRICKS:
            case IRON_BARS:
            case IRON_BLOCK:
            case IRON_DOOR:
            case IRON_ORE:
            case IRON_TRAPDOOR:
            case JACK_O_LANTERN:
            case JUKEBOX:
            case KELP:
            case KELP_PLANT:
            case LADDER:
            case LAPIS_BLOCK:
            case LAPIS_ORE:
            case LARGE_FERN:
            case LAVA:
            case LEVER:
            case LILAC:
            case LILY_PAD:
            case MAGMA_BLOCK:
            case MELON:
            case MELON_STEM:
            case MOSSY_COBBLESTONE:
            case MOSSY_COBBLESTONE_WALL:
            case MOSSY_STONE_BRICKS:
            case MOVING_PISTON:
            case MUSHROOM_STEM:
            case MUSHROOM_STEW:
            case MYCELIUM:
            case NETHERRACK:
            case NETHER_BRICKS:
            case NETHER_PORTAL:
            case NETHER_QUARTZ_ORE:
            case NETHER_WART:
            case NETHER_WART_BLOCK:
            case NOTE_BLOCK:
            case OBSERVER:
            case OBSIDIAN:
            case OXEYE_DAISY:
            case PACKED_ICE:
            case PEONY:
            case PISTON:
            case PISTON_HEAD:
            case PLAYER_HEAD:
            case PLAYER_WALL_HEAD:
            case PODZOL:
            case POLISHED_ANDESITE:
            case POLISHED_DIORITE:
            case POLISHED_GRANITE:
            case POPPY:
            case POTATOES:
            case POWERED_RAIL:
            case PRISMARINE:
            case PRISMARINE_BRICKS:
            case PUMPKIN:
            case PUMPKIN_STEM:
            case PURPUR_BLOCK:
            case PURPUR_PILLAR:
            case QUARTZ_BLOCK:
            case QUARTZ_PILLAR:
            case RAIL:
            case REDSTONE_BLOCK:
            case REDSTONE_LAMP:
            case REDSTONE_ORE:
            case REDSTONE_TORCH:
            case REDSTONE_WALL_TORCH:
            case REDSTONE_WIRE:
            case REPEATER:
            case REPEATING_COMMAND_BLOCK:
            case ROSE_BUSH:
            case ROSE_RED:
            case SAND:
            case SANDSTONE:
            case SEAGRASS:
            case SEA_LANTERN:
            case SEA_PICKLE:
            case SIGN:
            case SKELETON_SKULL:
            case SKELETON_WALL_SKULL:
            case SLIME_BLOCK:
            case SMOOTH_QUARTZ:
            case SMOOTH_RED_SANDSTONE:
            case SMOOTH_SANDSTONE:
            case SMOOTH_STONE:
            case SNOW:
            case SNOW_BLOCK:
            case SOUL_SAND:
            case SPAWNER:
            case SPONGE:
            case STICKY_PISTON:
            case STONE:
            case STONE_BRICKS:
            case STONE_BUTTON:
            case STRUCTURE_BLOCK:
            case STRUCTURE_VOID:
            case SUGAR_CANE:
            case SUNFLOWER:
            case TALL_GRASS:
            case TALL_SEAGRASS:
            case TERRACOTTA:
            case TNT:
            case TORCH:
            case TRAPPED_CHEST:
            case TRIPWIRE:
            case TRIPWIRE_HOOK:
            case TURTLE_EGG:
            case VINE:
            case WALL_SIGN:
            case WALL_TORCH:
            case WATER:
            case WET_SPONGE:
            case WHEAT:
            case WITHER_SKELETON_SKULL:
            case WITHER_SKELETON_WALL_SKULL:
            case ZOMBIE_HEAD:
            case ZOMBIE_WALL_HEAD:


            default:
                return m112(b);
        }
    }


    private static Req m112(MinecraftBlock b) {
        return new Req(b);
    }
}
