package com.gotve.untitled_forge_mod;

import com.gotve.untitled_forge_mod.registry.ModBlocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import com.gotve.untitled_forge_mod.registry.ModCreativeTabs;
import com.gotve.untitled_forge_mod.registry.ModItems;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings("removal")
@Mod(UntitledForgeMod.MOD_ID)
public class UntitledForgeMod {

    public static final String MOD_ID = "untitled_forge_mod";

    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

    public UntitledForgeMod() {
        ModBlocks.register(bus);
        ModItems.register(bus);
        ModCreativeTabs.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
