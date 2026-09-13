package net.sepinula.talesofeldoria.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import net.sepinula.talesofeldoria.TalesOfEldoria;
import net.sepinula.talesofeldoria.block.ModBlocks;
import net.sepinula.talesofeldoria.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output,
                               CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TalesOfEldoria.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.LOGS_THAT_BURN)
                .add(ResourceKey.create(Registries.ITEM, ModBlocks.VERDANT_LOG.getId()))
                .add(ResourceKey.create(Registries.ITEM, ModBlocks.VERDANT_STRIPPED_LOG.getId()));

        tag(ItemTags.PLANKS)
                .add(ResourceKey.create(Registries.ITEM, ModBlocks.VERDANT_PLANK.getId()));

        tag(ItemTags.WOODEN_STAIRS)
                .add(ResourceKey.create(Registries.ITEM, ModBlocks.VERDANT_STAIRS.getId()));

        tag(ItemTags.WOODEN_SLABS)
                .add(ResourceKey.create(Registries.ITEM, ModBlocks.VERDANT_SLAB.getId()));

        tag(ItemTags.WOODEN_FENCES)
                .add(ResourceKey.create(Registries.ITEM, ModBlocks.VERDANT_FENCE.getId()));

        tag(ItemTags.FENCE_GATES)
                .add(ResourceKey.create(Registries.ITEM, ModBlocks.VERDANT_FENCE_GATE.getId()));

        tag(ItemTags.WOODEN_DOORS)
                .add(ResourceKey.create(Registries.ITEM, ModBlocks.VERDANT_DOOR.getId()));

        tag(ItemTags.WOODEN_TRAPDOORS)
                .add(ResourceKey.create(Registries.ITEM, ModBlocks.VERDANT_TRAPDOOR.getId()));

        tag(ItemTags.WOODEN_BUTTONS)
                .add(ResourceKey.create(Registries.ITEM, ModBlocks.VERDANT_BUTTON.getId()));

        tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ResourceKey.create(Registries.ITEM, ModBlocks.VERDANT_PRESSURE_PLATE.getId()));

        tag(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(ModItems.VERDIGRIS_INGOT.getKey());
    }
}