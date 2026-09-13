package net.sepinula.talesofeldoria.block;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sepinula.talesofeldoria.TalesOfEldoria;
import net.sepinula.talesofeldoria.item.ModItems;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(TalesOfEldoria.MOD_ID);

    // Wood
    public static final DeferredBlock<Block> VERDANT_LOG = registerBlock("verdant_log", properties -> new RotatedPillarBlock(properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> VERDANT_STRIPPED_LOG = registerBlock("verdant_stripped_log", properties -> new RotatedPillarBlock(properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> VERDANT_PLANK = registerBlock("verdant_plank", properties -> new Block(properties.strength(2.0f, 3.0f).sound(SoundType.WOOD)));


    // Ore Blocks
    public static final DeferredBlock<Block> VERDIGRIS_BLOCK = registerBlock("verdigris_block", properties -> new Block(properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    //Overworld Ores
    public static final DeferredBlock<Block> VERDIGRIS_ORE = registerBlock("verdigris_ore", properties -> new DropExperienceBlock(UniformInt.of(2, 4), properties.strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> VERDIGRIS_DEEPSLATE_ORE = registerBlock("verdigris_deepslate_ore", properties -> new DropExperienceBlock(UniformInt.of(3, 5), properties.strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> RAW_VERDIGRIS_BLOCK = registerBlock("raw_verdigris_block", properties -> new Block(properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    //Other Dimension Ores
    public static final DeferredBlock<Block> VERDIGRIS_NETHER_ORE = registerBlock("verdigris_nether_ore", (properties) -> new DropExperienceBlock(UniformInt.of(1, 5), properties.strength(3f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> VERDIGRIS_END_ORE = registerBlock("verdigris_end_ore", (properties) -> new DropExperienceBlock(UniformInt.of(5, 9), properties.strength(7f).requiresCorrectToolForDrops()));



    public static ResourceKey<Block> getRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function, Component... components) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn, components);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block, Component... components) {
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()) {
            @Override
            public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                for(var component : components) {
                    builder.accept(component);
                }
                super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
            }
        });
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}