package net.rhyebread.deltatale.item;


import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rhyebread.deltatale.DeltaTale;
import net.rhyebread.deltatale.item.custom.DevilsKnifeItem;
import net.rhyebread.deltatale.item.custom.RudeAxeItem;
import net.rhyebread.deltatale.item.custom.Spade;

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

    public static final RegistryObject<Item> RUDEAXE = ITEMS.register("rude_axe",
            () -> new RudeAxeItem(new Properties().durability(200)));

    public static final RegistryObject<Item> RUDE_BUSTER_USE = ITEMS.register("rude_buster_use",
            () -> new RudeAxeItem(new Properties()));

    public static final RegistryObject<Item> SPADE = ITEMS.register("spade",
            () -> new DevilsKnifeItem(new Properties()));

    public static final RegistryObject<Item> HEART = ITEMS.register("heart",
            () -> new DevilsKnifeItem(new Properties()));

    public static final RegistryObject<Item> DEVILSKNIFE = ITEMS.register("devils_knife",
            () -> new DevilsKnifeItem(new Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
