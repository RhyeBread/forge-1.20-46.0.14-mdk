package net.rhyebread.deltatale.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.rhyebread.deltatale.DeltaTale;
import net.rhyebread.deltatale.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DeltaTale.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.DELTARUNE);
        simpleItem(ModItems.SHADOW_CRYSTAL);
        simpleItem(ModItems.ICE_RING);
        simpleItem(ModItems.THORN_RING);
        simpleItem(ModItems.SNOWGRAVE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DeltaTale.MOD_ID, "item/" + item.getId().getPath()));
    }
}
