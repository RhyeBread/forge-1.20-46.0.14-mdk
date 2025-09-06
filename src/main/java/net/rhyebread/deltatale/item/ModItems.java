package net.rhyebread.deltatale.item;


import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rhyebread.deltatale.DeltaTale;
import net.rhyebread.deltatale.item.custom.*;

import static net.minecraft.world.item.Item.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DeltaTale.MOD_ID);

    public static final RegistryObject<Item> WEIRDROUTE = ITEMS.register("weirdroute",
            () -> new SwordItem(Tiers.IRON, 6, -2.4F, (new Properties().durability(100))));

    public static final RegistryObject<Item> SHADOW_CRYSTAL = ITEMS.register("shadow_crystal",
            () -> new Item(new Properties().stacksTo(64)));

    public static final RegistryObject<Item> SNOWGRAVE = ITEMS.register("snowgrave",
            () -> new Item(new Properties()));

    public static final RegistryObject<Item> DELTARUNE = ITEMS.register("deltarune",
            () -> new Item(new Properties().stacksTo(1)));

    public static final RegistryObject<AxeItem> RUDEAXE = ITEMS.register("rude_axe",
            () -> new RudeAxeItem(Tiers.DIAMOND, 8, -2.4f, (new Properties().durability(100))));

    public static final RegistryObject<Item> RUDE_BUSTER_USE = ITEMS.register("rude_buster_use",
            () -> new RudeAxeItem(Tiers.DIAMOND, 8, -2.4f, (new Properties().durability(100))));

    public static final RegistryObject<Item> SPADE = ITEMS.register("spade",
            () -> new DevilsKnifeItem(new Properties()));

    public static final RegistryObject<Item> HEART = ITEMS.register("heart",
            () -> new DevilsKnifeItem(new Properties()));

    public static final RegistryObject<Item> DEVILSKNIFE = ITEMS.register("devils_knife",
            () -> new DevilsKnifeItem(new Properties()));

    public static final RegistryObject<Item> THORN_RING = ITEMS.register("thorn_ring",
            () -> new ThornRingItem(new Properties()));

    public static final RegistryObject<Item> ICE_RING = ITEMS.register("ice_ring",
            () -> new IceRingItem(new Properties()));

    public static final RegistryObject<HoeItem> REDDEVILSKNIFE = ITEMS.register("red_devils_knife",
            () -> new RedDevilsKnifeItem(Tiers.DIAMOND, 8, -2.4f, (new Properties().durability(100))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
