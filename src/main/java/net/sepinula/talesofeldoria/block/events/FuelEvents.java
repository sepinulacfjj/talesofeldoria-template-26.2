package net.sepinula.talesofeldoria.block.events;

import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.sepinula.talesofeldoria.TalesOfEldoria;
import net.sepinula.talesofeldoria.block.ModBlocks;

@EventBusSubscriber(modid = TalesOfEldoria.MOD_ID)
public class FuelEvents {

    @SubscribeEvent
    public static void onFurnaceFuelBurnTime(FurnaceFuelBurnTimeEvent event) {
        ItemStack itemStack = event.getItemStack();

        // 300 ticks = 1.5 items smelted (Vanilla Log value)
        if (itemStack.is(ModBlocks.VERDANT_LOG.get().asItem()) ||
                itemStack.is(ModBlocks.VERDANT_STRIPPED_LOG.get().asItem())) {
            event.setBurnTime(300);
        }

        // 300 ticks = 1.5 items smelted (Vanilla Plank value)
        if (itemStack.is(ModBlocks.VERDANT_PLANK.get().asItem())) {
            event.setBurnTime(300);
        }
    }
}