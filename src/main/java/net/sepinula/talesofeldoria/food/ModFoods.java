package net.sepinula.talesofeldoria.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoods {
    public static final FoodProperties GOBLIN_EAR = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).alwaysEdible().build();

    public static final Consumable GOBLIN_EAR_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(5.0f)
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.NAUSEA, 400), 0.30f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.HUNGER, 400), 0.10f)).build();

}