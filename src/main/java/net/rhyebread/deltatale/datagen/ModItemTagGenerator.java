package net.rhyebread.deltatale.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.rhyebread.deltatale.block.custom.ModBlocks;
import net.rhyebread.deltatale.item.ModItems;
import net.rhyebread.deltatale.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Items.HAS_SHADOW_CRYSTAL)
                .add(ModItems.DELTARUNE.get())
                .add(ModItems.RUDEAXE.get())
                .add(ModItems.DEVILSKNIFE.get())
                .add(ModItems.REDDEVILSKNIFE.get());
                //.add(ModItems..get())

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.HOPE_WOOD.get().asItem())
                .add(ModBlocks.HOPE_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_HOPE_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_HOPE_LOG.get().asItem());

        this.tag(ItemTags.LOGS)
                .add(ModBlocks.STRIPPED_HOPE_LOG.get().asItem())
                .add(ModBlocks.HOPE_LOG.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.HOPE_PLANKS.get().asItem());
                //.add(ModBlocks..get().asItem()
    }
}
