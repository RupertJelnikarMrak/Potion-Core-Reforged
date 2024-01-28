package com.bobigrenade.potioncore.effect;

import com.bobigrenade.potioncore.PotionCore;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PotionCoreEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(
        ForgeRegistries.MOB_EFFECTS,
        PotionCore.MOD_ID
    );

    public static final RegistryObject<MobEffect> FREEZE = MOB_EFFECTS.register(
        "freeze",
        () -> new FreezeEffect(MobEffectCategory.HARMFUL, 3124687)
    );

    public static final RegistryObject<MobEffect> CURE = MOB_EFFECTS.register(
        "cure",
        () -> new CureEffect(MobEffectCategory.BENEFICIAL, 16777215)
    );

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
