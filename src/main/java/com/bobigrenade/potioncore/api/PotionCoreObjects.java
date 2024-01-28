package com.bobigrenade.potioncore.api;

import com.bobigrenade.potioncore.PotionCore;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PotionCoreObjects {

    public static class Attributes {

        public static DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(
            Registries.ATTRIBUTE,
            PotionCore.MOD_ID
        );

        public static final RegistryObject<Attribute> ARROW_DAMAGE = ATTRIBUTES.register(
            "arrow_damage",
            () -> new RangedAttribute("generic.arrow_damage", 1.0D, 0.0D, 10.0D)
        );


    }
}
