package net.sepinula.talesofeldoria.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.sepinula.talesofeldoria.TalesOfEldoria;
import net.sepinula.talesofeldoria.block.ModBlocks;
import net.sepinula.talesofeldoria.item.ModItems;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, TalesOfEldoria.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        // Items
        itemModels.generateFlatItem(ModItems.VERDIGRIS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_VERDIGRIS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.VERDIGRIS_INGOT.get(), ModelTemplates.FLAT_ITEM);

        // Foods
        itemModels.generateFlatItem(ModItems.GOBLIN_EAR.get(), ModelTemplates.FLAT_ITEM);



        // Blocks
        blockModels.createTrivialCube(ModBlocks.VERDIGRIS_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.RAW_VERDIGRIS_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.VERDIGRIS_ORE.get());
        blockModels.createTrivialCube(ModBlocks.VERDIGRIS_DEEPSLATE_ORE.get());
        blockModels.createTrivialCube(ModBlocks.VERDIGRIS_NETHER_ORE.get());
        blockModels.createTrivialCube(ModBlocks.VERDIGRIS_END_ORE.get());


    }
}