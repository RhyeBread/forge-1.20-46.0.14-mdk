package net.rhyebread.deltatale.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.rhyebread.deltatale.DeltaTale;

public class ModTags {
    //Don't forget to make new classes for diff types
    public static class Entities {

        public static final TagKey<EntityType<?>> WEIRDER_ROUTE = tag("increase_weirdness");

        private static TagKey<EntityType<?>> tag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(DeltaTale.MOD_ID, name));
        }

    }

    public static class Items {
        public static final TagKey<Item> HAS_SHADOW_CRYSTAL = tag("has_shadow_crystal.json");
        public static final TagKey<Item> WEAPON_INCREASE_WEIRDNESS = tag("weapon_increase_weirdness");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(DeltaTale.MOD_ID, name));
        }
    }

    public static class Blocks{
        public static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(DeltaTale.MOD_ID, name));
        };

        public static final TagKey<Block> HOPE_FIELD_BLOCKS = tag("hope_field_blocks");


    }


}
