package com.gotve.untitled_forge_mod.items;

import com.gotve.untitled_forge_mod.registry.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;

public class YellowSword extends SwordItem {

    public YellowSword(Tier tier, float attackDamage, float attackSpeed, Properties properties) {
        super(tier, (int) attackDamage, attackSpeed, properties);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return 1.0f; // picking up time
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return false; // disable digging
    }

    @Override // use appendHoverText() only if needed static tooltips without animations
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        //tooltip.add(Component.literal("This is yellow sword"));

        if (!stack.is(ModItems.YELLOW_SWORD.get())) return;

        if (Screen.hasShiftDown()) {
            tooltip.add(Component.literal("This is description of Yellow sword"));
        } else {
            tooltip.add(Component.literal("Hold [Shift] for description"));
        }
    }
}
