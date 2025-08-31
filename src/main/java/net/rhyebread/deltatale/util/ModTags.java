package net.rhyebread.deltatale.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.rhyebread.deltatale.DeltaTale;

public class ModTags {
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
}
