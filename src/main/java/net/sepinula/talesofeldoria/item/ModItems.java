package net.sepinula.talesofeldoria.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sepinula.talesofeldoria.TalesOfEldoria;
import net.sepinula.talesofeldoria.food.ModFoods;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TalesOfEldoria.MOD_ID);

    // Ores
    public static final DeferredItem<Item> VERDIGRIS = ITEMS.registerSimpleItem("verdigris");
    public static final DeferredItem<Item> RAW_VERDIGRIS = ITEMS.registerSimpleItem("raw_verdigris");
    public static final DeferredItem<Item> VERDIGRIS_INGOT = ITEMS.registerSimpleItem("verdigris_ingot");

    // Food
    public static final DeferredItem<Item> GOBLIN_EAR = ITEMS.registerItem("goblin_ear",
            properties -> new Item(properties.food(ModFoods.GOBLIN_EAR).food(ModFoods.GOBLIN_EAR, ModFoods.GOBLIN_EAR_CONSUMABLE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}