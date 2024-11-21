package dev.isxander.xso.mixins.compat.moreculling;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.gen.Accessor;

@Pseudo
@Mixin(targets = "ca.fxco.moreculling.config.sodium.FloatSliderControl")
public interface FloatSliderControlAccessor {
    @Accessor
    float getMin();

    @Accessor
    float getMax();

    @Accessor
    float getInterval();
}
