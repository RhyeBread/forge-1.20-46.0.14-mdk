package net.rhyebread.deltatale.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.rhyebread.deltatale.DeltaTale;
import net.rhyebread.deltatale.block.custom.ModBlocks;
import net.rhyebread.deltatale.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DeltaTale.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.HOPE_FIELD_BLOCKS)
                .add(ModBlocks.HOPE_FIELD_DIRT.get())
                .add(ModBlocks.HOPE_FIELD_GRASS.get())

                .add(ModBlocks.HOPE_LOG.get())
                .add(ModBlocks.HOPE_WOOD.get())
                .add(ModBlocks.HOPE_PLANKS.get())
                .add(ModBlocks.STRIPPED_HOPE_LOG.get())
                .add(ModBlocks.STRIPPED_HOPE_WOOD.get())

                .add(ModBlocks.DREAMY_LEAVES.get());
                //.add(ModBlocks..get())

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.HOPE_WOOD.get())
                .add(ModBlocks.HOPE_LOG.get())
                .add(ModBlocks.STRIPPED_HOPE_WOOD.get())
                .add(ModBlocks.STRIPPED_HOPE_LOG.get());

        this.tag(BlockTags.LOGS)
                .add(ModBlocks.HOPE_LOG.get())
                .add(ModBlocks.STRIPPED_HOPE_LOG.get());


        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.HOPE_PLANKS.get());

    }
}
