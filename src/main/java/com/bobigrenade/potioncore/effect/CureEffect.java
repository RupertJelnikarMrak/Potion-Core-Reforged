package com.bobigrenade.potioncore.effect;

import java.util.Collection;
import javax.annotation.Nullable;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class CureEffect extends InstantenousMobEffect {

    public CureEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pEntity, int pAmplifier) {
        if (!pEntity.level().isClientSide()) {
            pEntity.getServer().execute(() -> clearNegativeEffects(pEntity));
        }
    }

    @Override
    public void applyInstantenousEffect(
        @Nullable Entity pSource,
        @Nullable Entity pIndirectSource,
        LivingEntity pLivingEntity,
        int pAmplifier,
        double pHealth
    ) {
        if (!pLivingEntity.level().isClientSide()) {
            pLivingEntity
                .getServer()
                .execute(() -> clearNegativeEffects(pLivingEntity));
        }
    }

    private void clearNegativeEffects(LivingEntity pEntity) {
        Collection<MobEffectInstance> effects = pEntity.getActiveEffects();

        for (MobEffectInstance effect : effects) {
            if (effect.getEffect().getCategory() == MobEffectCategory.HARMFUL) {
                pEntity.removeEffect(effect.getEffect());
            }
        }
    }
}
