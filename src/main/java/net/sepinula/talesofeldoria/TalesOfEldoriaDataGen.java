package net.sepinula.talesofeldoria;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.sepinula.talesofeldoria.datagen.ModBlockLootTableProvider;
import net.sepinula.talesofeldoria.datagen.ModBlockTagsProvider;
import net.sepinula.talesofeldoria.datagen.ModModelProvider;
import net.sepinula.talesofeldoria.datagen.ModRecipeProvider;

import java.util.Collections;
import java.util.List;

@EventBusSubscriber(modid = TalesOfEldoria.MOD_ID)
public class TalesOfEldoriaDataGen {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new ModModelProvider(packOutput));
        generator.addProvider(true, new ModBlockTagsProvider(packOutput, lookupProvider));
        generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));


        generator.addProvider(true, new ModRecipeProvider.Runner(packOutput, lookupProvider));


    }
}
