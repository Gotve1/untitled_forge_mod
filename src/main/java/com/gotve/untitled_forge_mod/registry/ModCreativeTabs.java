package com.gotve.untitled_forge_mod.registry;

import com.gotve.untitled_forge_mod.UntitledForgeMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UntitledForgeMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB =
            TABS.register("example_tab", () -> CreativeModeTab.builder()
                    .title(Component.literal("Example Tab"))
                    .icon(() -> new ItemStack(ModItems.YELLOW_SWORD.get()))
                    .displayItems((params, output) -> {
                        // Items that appear inside your tab
                        output.accept(ModItems.YELLOW_SWORD.get());
                        output.accept(ModItems.ANIMATED_BALL.get());
                        output.accept(ModItems.CUSTOM_MODEL_ITEM.get());
                    })
                    .build()
            );

    @SuppressWarnings("removal") // is used to ignore warnings
    public static void register() {
        TABS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}