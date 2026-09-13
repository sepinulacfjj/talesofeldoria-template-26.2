package net.sepinula.talesofeldoria.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sepinula.talesofeldoria.TalesOfEldoria;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TalesOfEldoria.MOD_ID);

    public static final DeferredItem<Item> VERDIGRIS = ITEMS.registerSimpleItem("verdigris");
    public static final DeferredItem<Item> RAW_VERDIGRIS = ITEMS.registerSimpleItem("raw_verdigris");
    public static final DeferredItem<Item> VERDIGRIS_INGOT = ITEMS.registerSimpleItem("verdigris_ingot");


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
