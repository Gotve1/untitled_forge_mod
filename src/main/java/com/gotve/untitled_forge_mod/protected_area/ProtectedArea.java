package com.gotve.untitled_forge_mod.protected_area;

import com.gotve.untitled_forge_mod.UntitledForgeMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UntitledForgeMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ProtectedArea {

    public static final AABB SELECTED_AREA = new AABB(
            5 - 1, 56 - 1, 22 - 1,
            10 + 1, 60 + 1, 18 + 1
    );

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        if (event.phase != TickEvent.Phase.END) return;

        Player player = event.player;
        Level level = player.level();

        if (level.isClientSide) return;

        if (SELECTED_AREA.contains(player.position())) {
            player.sendSystemMessage(Component.literal("You're in protected area"));
        }
    }
}
