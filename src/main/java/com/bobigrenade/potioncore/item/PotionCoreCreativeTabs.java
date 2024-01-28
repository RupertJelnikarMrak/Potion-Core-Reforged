package com.bobigrenade.potioncore.item;

import com.bobigrenade.potioncore.PotionCore;
import com.bobigrenade.potioncore.potion.PotionCorePotions;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PotionCoreCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
        Registries.CREATIVE_MODE_TAB,
        PotionCore.MOD_ID
    );

    public static final RegistryObject<CreativeModeTab> POTIONCORE_TAB = CREATIVE_MODE_TABS.register(
        "potioncore_tab",
        () ->
            CreativeModeTab
                .builder()
                .icon(() -> new ItemStack(PotionCoreItems.SAPPHIRE.get()))
                .title(Component.translatable("creativetab.potioncore"))
                .displayItems((pParameters, pOutput) -> {
                    pOutput.accept(PotionCoreItems.SAPPHIRE.get());
                    pOutput.accept(PotionCoreItems.RAW_SAPPHIRE.get());
                    pOutput.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionCorePotions.CURE_POTION.get()));
                    pOutput.accept(PotionUtils.setPotion(new ItemStack(Items.POTION), PotionCorePotions.FREEZE_POTION.get()));
                })
                .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
