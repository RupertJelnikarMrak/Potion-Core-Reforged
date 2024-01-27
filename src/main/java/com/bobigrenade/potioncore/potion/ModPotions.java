package com.bobigrenade.potioncore.potion;

import com.bobigrenade.potioncore.PotionCore;
import com.bobigrenade.potioncore.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(
        ForgeRegistries.POTIONS,
        PotionCore.MOD_ID
    );

    // * Freeze potion
    public static final RegistryObject<Potion> FREEZE_POTION = POTIONS.register(
        "freeze_potion",
        () -> new Potion(new MobEffectInstance(ModEffects.FREEZE.get(), 200, 0))
    );

    // * Cure potion
    public static final RegistryObject<Potion> CURE_POTION = POTIONS.register(
        "cure_potion",
        () -> new Potion(new MobEffectInstance(ModEffects.CURE.get(), 0, 0))
    );

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
