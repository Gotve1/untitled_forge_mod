package com.gotve.untitled_forge_mod.items;

import com.gotve.untitled_forge_mod.UntitledForgeMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

import static com.gotve.untitled_forge_mod.UntitledForgeMod.MOD_ID;

@Mod.EventBusSubscriber(modid = UntitledForgeMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Carrot {

    private static ItemStack hoveredItem = ItemStack.EMPTY;

    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {

        if (event.getEntity() == null) return;

        if (event.getItemStack().is(Items.CARROT)) {
            event.getEntity().sendSystemMessage(
                    Component.literal("You have pressed right click.")
            );
        }
    }

    @SubscribeEvent
    public static void onRenderScreen(ScreenEvent.Render.Post event) {
        Screen screen = event.getScreen();

        if (screen instanceof AbstractContainerScreen<?> container) {
            Slot slot = container.getSlotUnderMouse();
            if (slot != null && slot.hasItem()) {
                hoveredItem = slot.getItem();
            } else {
                hoveredItem = ItemStack.EMPTY;
            }
        }
    }

    @SubscribeEvent
    public static void onKeyPress(InputEvent.Key event) {
        if (event.getAction() != GLFW.GLFW_PRESS)
            return;

        if (event.getKey() == GLFW.GLFW_KEY_W) {

            if (!hoveredItem.isEmpty()) {

                Player player = Minecraft.getInstance().player;
                if (player != null) {
                    player.sendSystemMessage(
                            Component.literal(
                                    """
                                    "W" was pressed
                                    """)
                    );
                }
            }
        }
    }
}
