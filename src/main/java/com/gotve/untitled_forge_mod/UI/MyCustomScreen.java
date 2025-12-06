package com.gotve.untitled_forge_mod.UI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class MyCustomScreen extends Screen {

    public MyCustomScreen() {
        super(Component.literal("My Custom GUI"));
    }

    @Override
    protected void init() {

        Player player = Minecraft.getInstance().player;

        super.init();
        int btnWidth = 100;
        int btnHeight = 20;
        this.addRenderableWidget(
                Button.builder(Component.literal("Is it works?"), (btn) -> {

                            if (player != null) {
                                player.sendSystemMessage(Component.literal("This button works"));
                            }

                            System.out.println("This button works");
                        })

                        .pos(this.width / 2 - 50, this.height / 2 - 10)
                        .size(btnWidth, btnHeight)
                        .build()
        );
    }

    @Override
    public void render(net.minecraft.client.gui.GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {

        this.renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTicks);
    }

    @Override // obviously used to make UI not to pause the game
    public boolean isPauseScreen() {
        return false;
    }
}
