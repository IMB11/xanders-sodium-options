package dev.isxander.xso.mixins;

import net.caffeinemc.mods.sodium.client.gui.options.control.ControlValueFormatter;
import net.caffeinemc.mods.sodium.client.gui.options.control.DynamicMaxSliderControl;
import net.caffeinemc.mods.sodium.client.gui.options.control.SliderControl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.function.IntSupplier;

@Mixin(DynamicMaxSliderControl.class)
public interface DynamicMaxSliderControlAccessor {
    @Accessor
    int getMin();

    @Accessor
    IntSupplier getMax();

    @Accessor
    int getInterval();

    @Accessor
    ControlValueFormatter getMode();
}
