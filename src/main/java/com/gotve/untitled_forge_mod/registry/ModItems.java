package com.gotve.untitled_forge_mod.registry;

import com.gotve.untitled_forge_mod.UntitledForgeMod;
import com.gotve.untitled_forge_mod.items.AnimatedBall;
import com.gotve.untitled_forge_mod.items.YellowSword;
import com.gotve.untitled_forge_mod.modtiers.ModTiers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, UntitledForgeMod.MOD_ID);

    public static final RegistryObject<Item> ANIMATED_BALL = ITEMS.register("animated_ball", () ->
            new AnimatedBall(
                    new Item.Properties()
            )
    );

    public static final RegistryObject<Item> OAK_TABLE_ITEM = ITEMS.register("oak_table_item", () ->
            new BlockItem(
                    ModBlocks.OAK_TABLE.get(), new Item.Properties()
            )
    );

    public static final RegistryObject<Item> OAK_CHAIR_ITEM = ITEMS.register("oak_chair_item", () ->
            new BlockItem(
                    ModBlocks.OAK_CHAIR.get(), new Item.Properties()
            )
    );

    public static final RegistryObject<Item> YELLOW_SWORD = ITEMS.register("yellow_sword", () ->
            new YellowSword(
                    ModTiers.YELLOW_TIER,
                    1.0f,
                    1.0f,
                    new Item.Properties()
            )
    );

    public static final RegistryObject<Item> LUCKY_NUMBER_ITEM = ITEMS.register("lucky_number", () ->
            new BlockItem(
                    ModBlocks.LUCKY_NUMBER.get(), new Item.Properties()
            )
    );


    public static final DeferredRegister<Item> ITEMS_REG =
            DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");

    public static final RegistryObject<Item> IRON_SWORD = ITEMS_REG.register("iron_sword",
            () -> new SwordItem(ModTiers.COPPER_TIER, 3, -2.4f, new Item.Properties()));



    @SuppressWarnings("removal") // is used to ignore warnings
    public static void register(IEventBus bus) {
        ITEMS.register(bus);
        ITEMS_REG.register(bus);
    }
}
