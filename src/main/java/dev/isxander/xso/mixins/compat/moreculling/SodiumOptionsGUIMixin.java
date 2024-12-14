package dev.isxander.xso.mixins.compat.moreculling;

import dev.isxander.xso.compat.MoreCullingCompat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Unique;

import net.caffeinemc.mods.sodium.client.gui.SodiumOptionsGUI;
import net.caffeinemc.mods.sodium.client.gui.options.OptionPage;

@Pseudo
@Mixin(value = SodiumOptionsGUI.class, priority = 2000)
public class SodiumOptionsGUIMixin implements MoreCullingCompat.MoreCullingPageHolder {
    @Unique
    private OptionPage moreCullingPage;

    @Override
    public OptionPage getMoreCullingPage() {
        return moreCullingPage;
    }
}
