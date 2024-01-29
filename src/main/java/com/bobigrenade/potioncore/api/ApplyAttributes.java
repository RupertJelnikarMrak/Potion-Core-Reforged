package com.bobigrenade.potioncore.api;

import com.bobigrenade.potioncore.PotionCore;

import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
    modid = PotionCore.MOD_ID,
    bus = Mod.EventBusSubscriber.Bus.MOD
)
public class ApplyAttributes {
        @SubscribeEvent
    public static void applyAttributes(EntityAttributeModificationEvent event)
    {
        event.getTypes().forEach(type -> {
            event.add(type, PotionCoreObjects.Attributes.PROJECTILE_DAMAGE.get());
            event.add(type, PotionCoreObjects.Attributes.PROJECTILE_SPEED.get());
        });
    }
}
