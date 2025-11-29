package com.gotve.untitled_forge_mod.items;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.state.BlockState;

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
}
