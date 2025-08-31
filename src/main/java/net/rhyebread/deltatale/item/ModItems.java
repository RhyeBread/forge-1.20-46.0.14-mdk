package net.rhyebread.deltatale.item;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rhyebread.deltatale.DeltaTale;
import net.rhyebread.deltatale.item.custom.ModToolTiers;
import net.rhyebread.deltatale.item.custom.WeirdRouteItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DeltaTale.MOD_ID);

    public static final RegistryObject<Item> WEIRDROUTE = ITEMS.register("weirdroute",
            () -> new SwordItem(Tiers.IRON, 6, -2.4F, (new Item.Properties().durability(100))));

    public static final RegistryObject<Item> SHADOW_CRYSTAL = ITEMS.register("shadow_crystal",
            () -> new Item(new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> SNOWGRAVE = ITEMS.register("snowgrave",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DELTARUNE = ITEMS.register("deltarune",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> RUDE_AXE = ITEMS.register("rude_axe",
            () -> new AxeItem(Tiers.DIAMOND, 6, 1, new Item.Properties().durability(200)));

    public static final RegistryObject<Item> RUDE_BUSTER_USE = ITEMS.register("rude_buster_use",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
