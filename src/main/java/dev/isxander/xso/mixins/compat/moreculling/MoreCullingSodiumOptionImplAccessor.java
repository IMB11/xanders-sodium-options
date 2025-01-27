package dev.isxander.xso.mixins.compat.moreculling;

import ca.fxco.moreculling.config.sodium.MoreCullingSodiumOptionImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.caffeinemc.mods.sodium.client.gui.options.binding.OptionBinding;

@Pseudo
@Mixin(MoreCullingSodiumOptionImpl.class)
public interface MoreCullingSodiumOptionImplAccessor<S, T> {
    @Accessor
    OptionBinding<S, T> getBinding();
}
