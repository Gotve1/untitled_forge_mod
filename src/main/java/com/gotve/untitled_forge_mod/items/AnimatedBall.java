package com.gotve.untitled_forge_mod.items;

import com.gotve.untitled_forge_mod.UntitledForgeMod;
import com.gotve.untitled_forge_mod.registry.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

import java.util.List;

@Mod.EventBusSubscriber(modid = UntitledForgeMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AnimatedBall extends Item {

    public static int barProgress = 0;
    public static int maxProgress = 20;

    public AnimatedBall(Properties p_41383_) {
        super(p_41383_);
    }

    @SubscribeEvent
    public static void onKeyPress(InputEvent.Key event) {

        if (event.getKey() == GLFW.GLFW_KEY_W) {

            if (event.getAction() == GLFW.GLFW_PRESS) {
                barProgress = 0;
            }

            if (event.getAction() == GLFW.GLFW_REPEAT) {

                if (barProgress < maxProgress) {
                    barProgress++;
                }
            }
        }
    }

    @SubscribeEvent
    public static void onKeyRelease(InputEvent.Key event) {
        if (event.getAction() == GLFW.GLFW_KEY_W && event.getAction() == GLFW.GLFW_RELEASE) {
            barProgress = 0;
        }
    }

    @SubscribeEvent // use ItemTooltipEvent only if needed dynamic descriptions e.g animations in descriptions
    public static void onItemTooltip(ItemTooltipEvent event) {

        ItemStack stack = event.getItemStack();

        if (!stack.is(ModItems.ANIMATED_BALL.get())) return;

        int barPercentage = 20;
        int filled = (int)((barProgress / (float)maxProgress) * barPercentage);

        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < barPercentage; i++) {
            bar.append(i < filled ? "|" : "");
        }
        bar.append("]");

        List<Component> tooltip = event.getToolTip();
        tooltip.add(Component.literal("Press [W] to charge"));
        tooltip.add(Component.literal(bar.toString()));
    }
}
