package com.bobigrenade.potioncore.effect;

import com.bobigrenade.potioncore.api.PotionCoreObjects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

public class TrueshotEffect extends MobEffect{
    
    public TrueshotEffect(MobEffectCategory category, int color) {
        super(category, color);
        addAttributeModifier(PotionCoreObjects.Attributes.PROJECTILE_DAMAGE.get(), "d5780f39-e134-4a79-9b39-8ce6d5d8eff5", 0.5D, AttributeModifier.Operation.ADDITION);
        addAttributeModifier(PotionCoreObjects.Attributes.PROJECTILE_SPEED.get(), "0e3e350e-5b80-4367-bcb4-b8ecd080781d", 0.5D, AttributeModifier.Operation.ADDITION);
    }
}
