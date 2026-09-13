package net.sepinula.talesofeldoria.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.sepinula.talesofeldoria.block.ModBlocks;
import net.sepinula.talesofeldoria.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    public ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        //Wood
        dropSelf(ModBlocks.VERDANT_LOG.get());
        dropSelf(ModBlocks.VERDANT_PLANK.get());
        dropSelf(ModBlocks.VERDANT_STRIPPED_LOG.get());


        //Ores
        dropSelf(ModBlocks.VERDIGRIS_BLOCK.get());
        dropSelf(ModBlocks.RAW_VERDIGRIS_BLOCK.get());

        add(ModBlocks.VERDIGRIS_ORE.get(),
                createOreDrop(ModBlocks.VERDIGRIS_ORE.get(), ModItems.RAW_VERDIGRIS.get()));
        add(ModBlocks.VERDIGRIS_DEEPSLATE_ORE.get(),
                createOreDrop(ModBlocks.VERDIGRIS_DEEPSLATE_ORE.get(), ModItems.RAW_VERDIGRIS.get()));

        add(ModBlocks.VERDIGRIS_NETHER_ORE.get(),
                createMultipleOreDrops(ModBlocks.VERDIGRIS_NETHER_ORE.get(), ModItems.RAW_VERDIGRIS.get(), 4, 7));
        add(ModBlocks.VERDIGRIS_END_ORE.get(),
                createMultipleOreDrops(ModBlocks.VERDIGRIS_END_ORE.get(), ModItems.RAW_VERDIGRIS.get(), 5, 9));

    }

    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block, this.applyExplosionDecay(block,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}