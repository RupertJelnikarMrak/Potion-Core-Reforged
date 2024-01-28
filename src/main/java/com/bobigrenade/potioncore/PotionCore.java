package com.bobigrenade.potioncore;

import com.bobigrenade.potioncore.api.PotionCoreObjects;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PotionCore.MOD_ID)
public class PotionCore {

    public static final String MOD_ID = "potioncore";

    private static final Logger LOGGER = LogUtils.getLogger();

    public PotionCore() {
        LOGGER.info("I brewed all the potions, I want more!");

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        PotionCoreObjects.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
