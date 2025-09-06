package net.rhyebread.deltatale.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.rhyebread.deltatale.block.custom.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables(Set<Item> pExplosionResistant, FeatureFlagSet pEnabledFeatures) {
        super(pExplosionResistant, pEnabledFeatures);
    }

    public ModBlockLootTables(){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.HOPE_FIELD_DIRT.get());
        this.dropSelf(ModBlocks.HOPE_FIELD_GRASS.get());

        this.dropSelf(ModBlocks.HOPE_LOG.get());
        this.dropSelf(ModBlocks.HOPE_PLANKS.get());
        this.dropSelf(ModBlocks.HOPE_WOOD.get());

        this.dropSelf(ModBlocks.STRIPPED_HOPE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_HOPE_LOG.get());

        this.dropSelf(ModBlocks.DREAMY_LEAVES.get());
        //this.dropSelf(ModBlocks..get());
        //NEED SAPLINGS this.createLeavesDrops(ModBlocks.DREAMY_LEAVES, )

        // this.add(ModBlocks.SOME_ORE.get(),
        //      block -> createOreDrops(ModBlocks.SOME_ORE.get(), ModItems.RAW_ORE.get()))
    }

    // ORES
    // protected LootTable.Builder createOreDrops(Block pBlock, Item item){
    //      return createSilkTouchDispatchTable(pBlock,
    //          this.applyExplosionDecay(pBlock,
    //              LootItem.lootTableItem(Items.RAW_ORE)
    //                  .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 5.0f)))
    //                  .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))


    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
