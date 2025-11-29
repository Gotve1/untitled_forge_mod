package com.gotve.untitled_forge_mod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import com.gotve.untitled_forge_mod.registry.ModCreativeTabs;
import com.gotve.untitled_forge_mod.registry.ModItems;

@Mod(UntitledForgeMod.MOD_ID)
public class UntitledForgeMod {
    public static final String MOD_ID = "untitled_forge_mod";

    public UntitledForgeMod() {
        ModItems.register();
        ModCreativeTabs.register();
        MinecraftForge.EVENT_BUS.register(this);
    }
}
