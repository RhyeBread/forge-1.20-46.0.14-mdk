package net.rhyebread.deltatale.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rhyebread.deltatale.DeltaTale;
import net.rhyebread.deltatale.block.custom.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DeltaTale.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.HOPE_LOG);
        blockWithItem(ModBlocks.HOPE_WOOD);
        blockWithItem(ModBlocks.HOPE_PLANKS);
        blockWithItem(ModBlocks.STRIPPED_HOPE_LOG);
        blockWithItem(ModBlocks.STRIPPED_HOPE_WOOD);
        blockWithItem(ModBlocks.DREAMY_LEAVES);

        blockWithItem(ModBlocks.HOPE_FIELD_GRASS);
        blockWithItem(ModBlocks.HOPE_FIELD_DIRT);


        logBlock(((RotatedPillarBlock) ModBlocks.HOPE_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.HOPE_WOOD.get()), blockTexture(ModBlocks.HOPE_LOG.get()));

        //TODO Make stripped texture BEFORE reintroduction
        //axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_HOPE_LOG.get()), blockTexture(ModBlocks.STRIPPED_HOPE_LOG.get()),
        //        new ResourceLocation(DeltaTale.MOD_ID, "block/stripped_hope_log_top"));
        //axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_HOPE_WOOD.get()), blockTexture(ModBlocks.STRIPPED_HOPE_WOOD.get()),
        //        blockTexture(ModBlocks.STRIPPED_HOPE_LOG.get()));

        //TODO Make "Dreamy Leaves" texture!!!!
    }

    private  void leavesBlock(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(DeltaTale.MOD_ID + ":block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
