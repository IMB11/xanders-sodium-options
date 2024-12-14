package dev.isxander.xso.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.caffeinemc.mods.sodium.client.gui.options.control.CyclingControl;
@Mixin(CyclingControl.class)
public interface CyclingControlAccessor<T extends Enum<T>> {
    @Accessor
    T[] getAllowedValues();
}
