package net.sepinula.talesofeldoria;

import net.sepinula.talesofeldoria.block.ModBlocks;
import net.sepinula.talesofeldoria.creativemodetab.ModCreativeModeTabs;
import net.sepinula.talesofeldoria.item.ModItems;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(TalesOfEldoria.MOD_ID)
public class TalesOfEldoria {
    public static final String MOD_ID = "talesofeldoria";
    public static final Logger LOGGER = LogUtils.getLogger();

    public TalesOfEldoria(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Common setup initialized.");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Server starting.");
    }
}