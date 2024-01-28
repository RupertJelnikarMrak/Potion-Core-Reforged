package com.bobigrenade.potioncore.api;

import com.bobigrenade.potioncore.PotionCore;
import com.bobigrenade.potioncore.effect.CureEffect;
import com.bobigrenade.potioncore.effect.FreezeEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/*
 * Here are all objects that are registered by this mod, so you can call them from here.
 */

public class PotionCoreObjects {

    public static class Attributes {

        public static DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(
            Registries.ATTRIBUTE,
            PotionCore.MOD_ID
        );

        /*
         * Arrow Damage
         */
        public static final RegistryObject<Attribute> ARROW_DAMAGE = ATTRIBUTES.register(
            "arrow_damage",
            () ->
                new RangedAttribute(
                    "potioncore:arrow_damage",
                    1.0D,
                    0.0D,
                    10.0D
                )
        );

        public static void register(IEventBus eventBus) {
            ATTRIBUTES.register(eventBus);
        }
    }

    public static class MobEffects {

        public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(
            ForgeRegistries.MOB_EFFECTS,
            PotionCore.MOD_ID
        );

        /*
         * Freeze
         */
        public static final RegistryObject<MobEffect> FREEZE = MOB_EFFECTS.register(
            "freeze",
            () -> new FreezeEffect(MobEffectCategory.HARMFUL, 3124687)
        );

        /*
         * Cure
         */
        public static final RegistryObject<MobEffect> CURE = MOB_EFFECTS.register(
            "cure",
            () -> new CureEffect(MobEffectCategory.BENEFICIAL, 16777215)
        );

        public static void register(IEventBus eventBus) {
            MOB_EFFECTS.register(eventBus);
        }
    }

    public static class Potions {

        public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(
            ForgeRegistries.POTIONS,
            PotionCore.MOD_ID
        );

        /*
         * Freeze potion
         */
        public static final RegistryObject<Potion> FREEZE_POTION = POTIONS.register(
            "freeze_potion",
            () ->
                new Potion(
                    new MobEffectInstance(MobEffects.FREEZE.get(), 200, 0)
                )
        );

        /*
         * Cure potion
         */
        public static final RegistryObject<Potion> CURE_POTION = POTIONS.register(
            "cure_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.CURE.get(), 0, 0))
        );

        public static void register(IEventBus eventBus) {
            POTIONS.register(eventBus);
        }
    }

    public static class CreativeModeTabs {

        public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB,
            PotionCore.MOD_ID
        );

        public static final RegistryObject<CreativeModeTab> POTIONCORE_TAB = CREATIVE_MODE_TABS.register(
            "potioncore_tab",
            () ->
                CreativeModeTab
                    .builder()
                    .icon(() -> getPotionTabIcon())
                    .title(Component.translatable("creativetab.potioncore"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(
                            PotionUtils.setPotion(
                                new ItemStack(Items.POTION),
                                Potions.CURE_POTION.get()
                            )
                        );
                        pOutput.accept(
                            PotionUtils.setPotion(
                                new ItemStack(Items.POTION),
                                Potions.FREEZE_POTION.get()
                            )
                        );
                    })
                    .build()
        );

        public static void register(IEventBus eventBus) {
            CREATIVE_MODE_TABS.register(eventBus);
        }

        private static ItemStack getPotionTabIcon() {
            return PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.CURE_POTION.get());
        }
    }

    public static void register(IEventBus eventBus) {
        Attributes.register(eventBus);
        MobEffects.register(eventBus);
        Potions.register(eventBus);
        CreativeModeTabs.register(eventBus);
    }
}
