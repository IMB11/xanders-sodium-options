package dev.isxander.xso.mixins.compat.iris;

import dev.isxander.xso.compat.IrisCompat;

import net.caffeinemc.mods.sodium.client.gui.SodiumOptionsGUI;
import net.caffeinemc.mods.sodium.client.gui.options.OptionPage;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Unique;

@Pseudo
@Mixin(value = SodiumOptionsGUI.class, priority = 2000)
public class SodiumOptionsGUIMixin implements IrisCompat.ShaderPageHolder {
    @Unique
    private OptionPage shaderPacks;

    @Override
    public OptionPage getShaderPage() {
        return shaderPacks;
    }
}
