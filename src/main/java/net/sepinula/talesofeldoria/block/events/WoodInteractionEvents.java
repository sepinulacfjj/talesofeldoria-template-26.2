package net.sepinula.talesofeldoria.block.events;

import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.sepinula.talesofeldoria.TalesOfEldoria;
import net.sepinula.talesofeldoria.block.ModBlocks;

@EventBusSubscriber(modid = TalesOfEldoria.MOD_ID)
public class WoodInteractionEvents {

    @SubscribeEvent
    public static void onToolModification(BlockEvent.BlockToolModificationEvent event) {
        // Check if the tool action is AXE_STRIP
        if (event.getItemAbility() == ItemAbilities.AXE_STRIP) {
            BlockState state = event.getState();

            if (state.is(ModBlocks.VERDANT_LOG.get())) {
                // Preserve rotation when stripping
                event.setFinalState(ModBlocks.VERDANT_STRIPPED_LOG.get()
                        .withPropertiesOf(state));
            }
        }
    }
}