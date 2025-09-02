package net.rhyebread.deltatale.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.rhyebread.deltatale.DeltaTale;

import java.rmi.registry.Registry;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DeltaTale.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DELTATALE_TAB = CREATIVE_MODE_TABS.register("deltatale",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.WEIRDROUTE.get()))
                    .title(Component.translatable("creativetab.deltatale_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.WEIRDROUTE.get());
                        output.accept(ModItems.SNOWGRAVE.get());
                        output.accept(ModItems.SHADOW_CRYSTAL.get());
                        output.accept(ModItems.DELTARUNE.get());
                        output.accept(ModItems.RUDEAXE.get());
                        output.accept(ModItems.DEVILSKNIFE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
