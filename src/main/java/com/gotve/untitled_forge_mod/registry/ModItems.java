package com.gotve.untitled_forge_mod.registry;

import net.minecraft.world.item.Item;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.gotve.untitled_forge_mod.UntitledForgeMod;
import com.gotve.untitled_forge_mod.modtiers.ModTiers;
import com.gotve.untitled_forge_mod.items.YellowSword;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, UntitledForgeMod.MOD_ID);

    public static final RegistryObject<Item> YELLOW_SWORD = ITEMS.register("yellow_sword", () ->
            new YellowSword(
                    ModTiers.YELLOW_TIER,
                    1.0f,
                    1.0f,
                    new Item.Properties()
            )
    );

    public static final RegistryObject<Item> ANIMATED_BALL = ITEMS.register("animated_ball", () ->
            new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> CUSTOM_MODEL_ITEM = ITEMS.register("custom_model_item", () ->
            new Item(new Item.Properties())
    );

    @SuppressWarnings("removal") // is used to ignore warnings
    public static void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
