package com.bobigrenade.potioncore.api;

import com.bobigrenade.potioncore.PotionCore;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(
    modid = PotionCore.MOD_ID,
    bus = Bus.FORGE
)
public class AttributesEventHandler {

    @SubscribeEvent
    public static void projectileShot(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof AbstractArrow projectile) {
            Level level = projectile.level();
            if (level.isClientSide || projectile.getPersistentData().getBoolean("potioncore.projectile.done")) return;
            if (projectile.getOwner() instanceof LivingEntity livingEntity) {
                projectile.setBaseDamage(projectile.getBaseDamage() * livingEntity.getAttributeValue(PotionCoreObjects.Attributes.PROJECTILE_DAMAGE.get()));
                projectile.setDeltaMovement(projectile.getDeltaMovement().scale(livingEntity.getAttributeValue(PotionCoreObjects.Attributes.PROJECTILE_SPEED.get())));
            }
            projectile.getPersistentData().putBoolean("potioncore.projectile.done", true);
        }
    }
}
