package net.sepinula.talesofeldoria.creativemodetab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sepinula.talesofeldoria.TalesOfEldoria;
import net.sepinula.talesofeldoria.block.ModBlocks;
import net.sepinula.talesofeldoria.food.ModFoods;
import net.sepinula.talesofeldoria.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TalesOfEldoria.MOD_ID);

    public static final Supplier<CreativeModeTab> TALES_OF_ELDORIA_TAB = CREATIVE_MODE_TABS.register("tales_of_eldoria_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.VERDIGRIS.get()))
                    .title(Component.translatable("creativetab.talesofeldoria.tales_of_eldoria"))
                    .withTabsBefore(CreativeModeTabs.INGREDIENTS)
                    .displayItems((itemDisplayParameters, output) -> {

                        //Items
                        output.accept(ModItems.VERDIGRIS);
                        output.accept(ModItems.RAW_VERDIGRIS);
                        output.accept(ModItems.VERDIGRIS_INGOT);

                        //Blocks
                        output.accept(ModBlocks.VERDIGRIS_BLOCK);
                        output.accept(ModBlocks.RAW_VERDIGRIS_BLOCK);
                        output.accept(ModBlocks.VERDIGRIS_DEEPSLATE_ORE);
                        output.accept(ModBlocks.VERDIGRIS_END_ORE);
                        output.accept(ModBlocks.VERDIGRIS_ORE);
                        output.accept(ModBlocks.VERDIGRIS_NETHER_ORE);
                        output.accept(ModBlocks.VERDANT_LOG);
                        output.accept(ModBlocks.VERDANT_PLANK);
                        output.accept(ModBlocks.VERDANT_STRIPPED_LOG);

                        //Foods
                        output.accept(ModItems.GOBLIN_EAR);


                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}