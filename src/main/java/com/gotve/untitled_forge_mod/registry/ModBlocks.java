package com.gotve.untitled_forge_mod.registry;

import com.gotve.untitled_forge_mod.UntitledForgeMod;
import com.gotve.untitled_forge_mod.blocks.Table;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(Registries.BLOCK, UntitledForgeMod.MOD_ID);

    public static final RegistryObject<Block> OAK_TABLE = BLOCKS.register("oak_table", () ->
            new Table(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .requiresCorrectToolForDrops()
                    .strength(1.5f, 6.0f)
                    .noOcclusion()
            )
    );

    @SuppressWarnings("removal")
    public static void register() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
