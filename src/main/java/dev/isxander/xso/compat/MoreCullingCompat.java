package dev.isxander.xso.compat;

import ca.fxco.moreculling.config.sodium.MoreCullingSodiumOptionImpl;
import ca.fxco.moreculling.utils.CacheUtils;
import dev.isxander.xso.SodiumBinding;
import dev.isxander.xso.mixins.compat.moreculling.MoreCullingSodiumOptionImplAccessor;
import dev.isxander.yacl3.api.ConfigCategory;

import net.caffeinemc.mods.sodium.client.gui.SodiumOptionsGUI;
import net.caffeinemc.mods.sodium.client.gui.options.Option;
import net.caffeinemc.mods.sodium.client.gui.options.OptionPage;
import net.caffeinemc.mods.sodium.client.gui.options.storage.OptionStorage;

import net.minecraft.text.Text;

public class MoreCullingCompat {
    public static <S, T> SodiumBinding<S, T> getBinding(Option<T> option) {
        if (option instanceof MoreCullingSodiumOptionImpl<?, ?> moreCullingOption) {
            return new SodiumBinding<>(((MoreCullingSodiumOptionImplAccessor<S, T>) moreCullingOption).getBinding(), (OptionStorage<S>) moreCullingOption.getStorage());
        } else {
            return new SodiumBinding<>(option);
        }
    }

    @SuppressWarnings({"unchecked"})
    public static <T> void addAvailableCheck(dev.isxander.yacl3.api.Option<T> yaclOption, Option<T> sodiumOption) {
        if (!(sodiumOption instanceof MoreCullingSodiumOptionImpl<?,?>))
            return;

        ((OptionHolder<T>) sodiumOption).holdOption(yaclOption);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> boolean convertControl(dev.isxander.yacl3.api.Option.Builder<T> yaclOption, Option<T> sodiumOption) {
        //? if <1.21.2 {
        /*if (sodiumOption.getControl() instanceof ca.fxco.moreculling.config.sodium.IntSliderControl sliderControl) {
            dev.isxander.xso.mixins.compat.moreculling.IntSliderControlAccessor accessor = (dev.isxander.xso.mixins.compat.moreculling.IntSliderControlAccessor) sliderControl;
            yaclOption.controller(opt -> (dev.isxander.yacl3.api.controller.ControllerBuilder<T>) dev.isxander.yacl3.api.controller.IntegerSliderControllerBuilder.create((dev.isxander.yacl3.api.Option<Integer>) opt).range(accessor.getMin(), accessor.getMax()).step(accessor.getInterval()));
            return true;
        }

        if (sodiumOption.getControl() instanceof ca.fxco.moreculling.config.sodium.FloatSliderControl sliderControl) {
            dev.isxander.xso.mixins.compat.moreculling.FloatSliderControlAccessor accessor = (dev.isxander.xso.mixins.compat.moreculling.FloatSliderControlAccessor) sliderControl;
            yaclOption.controller(opt -> (dev.isxander.yacl3.api.controller.ControllerBuilder<T>) dev.isxander.yacl3.api.controller.FloatSliderControllerBuilder.create((dev.isxander.yacl3.api.Option<Float>) opt).range(accessor.getMin(), accessor.getMax()).step(accessor.getInterval()));
            return true;
        }
        *///?}

        // Don't need to do anything with moreculling after 1.21.2

        return false;
    }

    public static void extendMoreCullingPage(SodiumOptionsGUI optionsGUI, OptionPage page, ConfigCategory.Builder builder) {
        MoreCullingPageHolder shaderPageHolder = (MoreCullingPageHolder) optionsGUI;
        if (shaderPageHolder.getMoreCullingPage() == page) {
            builder.option(dev.isxander.yacl3.api.ButtonOption.createBuilder()
                    .name(Text.translatable("moreculling.config.resetCache"))
                    .action((screen, button) -> CacheUtils.resetAllCache())
                    .build());
        }
    }

    public interface OptionHolder<T> {
        void holdOption(dev.isxander.yacl3.api.Option<T> option);
    }

    public interface MoreCullingPageHolder {
        OptionPage getMoreCullingPage();
    }
}
