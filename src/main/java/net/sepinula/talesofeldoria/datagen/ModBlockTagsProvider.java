package net.sepinula.talesofeldoria.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.sepinula.talesofeldoria.TalesOfEldoria;
import net.sepinula.talesofeldoria.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TalesOfEldoria.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRK(ModBlocks.VERDIGRIS_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.RAW_VERDIGRIS_BLOCK.get()))
                .add(ModBlocks.getRK(ModBlocks.VERDIGRIS_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.VERDIGRIS_DEEPSLATE_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.VERDIGRIS_NETHER_ORE.get()))
                .add(ModBlocks.getRK(ModBlocks.VERDIGRIS_END_ORE.get()));

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.getRK(ModBlocks.VERDIGRIS_DEEPSLATE_ORE.get()));
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.getRK(ModBlocks.VERDIGRIS_NETHER_ORE.get()));
        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.getRK(ModBlocks.VERDIGRIS_END_ORE.get()));
    }
}