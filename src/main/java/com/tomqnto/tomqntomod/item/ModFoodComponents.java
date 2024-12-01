package com.tomqnto.tomqntomod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import java.util.List;

public class ModFoodComponents {

    public static final FoodComponent LUMINOUS_APPLE = new FoodComponent.Builder()
            .nutrition(4).saturationModifier(1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 300), 1.0f)
            .build();

}
