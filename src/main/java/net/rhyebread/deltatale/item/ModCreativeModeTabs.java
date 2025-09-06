package net.rhyebread.deltatale.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.rhyebread.deltatale.DeltaTale;
import net.rhyebread.deltatale.block.custom.ModBlocks;

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
                        output.accept(ModItems.THORN_RING.get());
                        output.accept(ModItems.ICE_RING.get());
                        output.accept(ModItems.REDDEVILSKNIFE.get());

                        output.accept(ModBlocks.HOPE_FIELD_GRASS.get());
                        output.accept(ModBlocks.HOPE_FIELD_DIRT.get());

                        output.accept(ModBlocks.HOPE_LOG.get());
                        output.accept(ModBlocks.HOPE_WOOD.get());
                        output.accept(ModBlocks.HOPE_PLANKS.get());
                        output.accept(ModBlocks.STRIPPED_HOPE_LOG.get());
                        output.accept(ModBlocks.STRIPPED_HOPE_WOOD.get());

                        output.accept(ModBlocks.DREAMY_LEAVES.get());

                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
