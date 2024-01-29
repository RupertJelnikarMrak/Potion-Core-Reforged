package com.bobigrenade.potioncore.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraftforge.common.ForgeMod;

public class ReachEffect extends MobEffect {
    
    public ReachEffect(MobEffectCategory category, int color) {
        super(category, color);
        addAttributeModifier(ForgeMod.BLOCK_REACH.get(), "87bb8abf-312e-4a8d-9ca1-c2f9d24fb152", 1.0D, Operation.ADDITION);
        addAttributeModifier(ForgeMod.ENTITY_REACH.get(), "de7822fc-404c-4105-9221-ef382d3b3ad7", 1.0D, Operation.ADDITION);
    }
}
