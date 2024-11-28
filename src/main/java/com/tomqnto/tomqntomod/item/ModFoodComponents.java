package com.tomqnto.tomqntomod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import java.util.List;

public class ModFoodComponents {


    public static final FoodComponent GLOW_FOOD_COMPONENT =
            new FoodComponent.Builder().nutrition(10).saturationModifier(10).alwaysEdible().snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 10 * 20, 1), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 10 * 20, 2), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 10*20, 2), 1f)
            .build();

}
