package net.sepinula.talesofeldoria.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.sepinula.talesofeldoria.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    public ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        builder(NeoForgeDataMaps.FURNACE_FUELS)
                // Logs & Bark Wood (300 ticks = 1.5 smelts)
                .add(ModBlocks.VERDANT_LOG.getId(), new FurnaceFuel(300), false)
                .add(ModBlocks.VERDANT_STRIPPED_LOG.getId(), new FurnaceFuel(300), false)

                // Planks & Derivative Wood Blocks
                .add(ModBlocks.VERDANT_PLANK.getId(), new FurnaceFuel(300), false)
                .add(ModBlocks.VERDANT_STAIRS.getId(), new FurnaceFuel(300), false)
                .add(ModBlocks.VERDANT_FENCE.getId(), new FurnaceFuel(300), false)
                .add(ModBlocks.VERDANT_FENCE_GATE.getId(), new FurnaceFuel(300), false)
                .add(ModBlocks.VERDANT_DOOR.getId(), new FurnaceFuel(200), false)
                .add(ModBlocks.VERDANT_TRAPDOOR.getId(), new FurnaceFuel(300), false)
                .add(ModBlocks.VERDANT_PRESSURE_PLATE.getId(), new FurnaceFuel(300), false)
                .add(ModBlocks.VERDANT_BUTTON.getId(), new FurnaceFuel(100), false)

                // Slabs (150 ticks = 0.75 smelts)
                .add(ModBlocks.VERDANT_SLAB.getId(), new FurnaceFuel(150), false);
    }
}