package com.bobigrenade.potioncore;

import com.bobigrenade.potioncore.effect.ModEffects;
import com.bobigrenade.potioncore.item.ModCreativeModeTabs;
import com.bobigrenade.potioncore.item.ModItems;
import com.bobigrenade.potioncore.potion.ModPotions;
import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PotionCore.MOD_ID)
public class PotionCore {

  // Define mod id in a common place for everything to reference
  public static final String MOD_ID = "potioncore";
  // Directly reference a slf4j logger
  private static final Logger LOGGER = LogUtils.getLogger();

  public PotionCore() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    LOGGER.info("I brewed all the potions, I want more!");

    ModItems.register(modEventBus);
    ModCreativeModeTabs.register(modEventBus);
    ModEffects.register(modEventBus);
    ModPotions.register(modEventBus);

    // Register the commonSetup method for mod loading
    modEventBus.addListener(this::commonSetup);

    // Register ourselves for server and other game events we are interested in
    MinecraftForge.EVENT_BUS.register(this);

    // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
  }

  private void commonSetup(final FMLCommonSetupEvent event) {}

  // You can use SubscribeEvent and let the Event Bus discover methods to call
  @SubscribeEvent
  public void onServerStarting(ServerStartingEvent event) {}

  // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
  @Mod.EventBusSubscriber(
    modid = MOD_ID,
    bus = Mod.EventBusSubscriber.Bus.MOD,
    value = Dist.CLIENT
  )
  public static class ClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {}
  }
}
