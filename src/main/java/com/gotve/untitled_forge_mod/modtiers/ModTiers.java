package com.gotve.untitled_forge_mod.modtiers;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ModTiers {
    public static final Tier YELLOW_TIER = new Tier() {
        @Override public int getUses() { return 350; }
        @Override public float getSpeed() { return 1.0f; } // mining speed
        @Override public float getAttackDamageBonus() { return 0.0f; }
        @Override public int getLevel() { return 0; }
        @Override public int getEnchantmentValue() { return 10; }
        @Override public Ingredient getRepairIngredient() { // used for defining material to repair with
            return Ingredient.EMPTY; // no repair item
        }
    };
}
