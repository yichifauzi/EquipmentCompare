package com.anthonyhilyard.equipmentcompare.fabric.mixin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import mezz.jei.fabric.platform.RenderHelper;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Surrogate;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.anthonyhilyard.equipmentcompare.EquipmentCompare;
import com.mojang.datafixers.util.Either;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;

@Mixin(RenderHelper.class)
public class JustEnoughItemsRenderHelperMixin
{
	@Unique
	Method setTooltipStack = null;

	// For JEI versions prior to 19.5.
	@Surrogate
	private void setTooltipStack(Screen screen,
		GuiGraphics graphics,
		List<Component> textComponents,
		Optional<TooltipComponent> tooltipComponent,
		int x, int y,
		Font font,
		ItemStack itemStack, CallbackInfo info)
	{
		if (setTooltipStack == null)
		{
			try
			{
				setTooltipStack = GuiGraphics.class.getDeclaredMethod("setTooltipStack", ItemStack.class);
			}
			catch (Exception e)
			{
				EquipmentCompare.LOGGER.error(ExceptionUtils.getStackTrace(e));
			}
		}

		if (setTooltipStack != null)
		{
			try { setTooltipStack.invoke(graphics, itemStack); }
			catch (IllegalAccessException | InvocationTargetException e) {}
		}
	}

	@Inject(method = "renderTooltip(Lnet/minecraft/client/gui/GuiGraphics;Ljava/util/List;IILnet/minecraft/client/gui/Font;Lnet/minecraft/world/item/ItemStack;)V",
			at = @At(value = "HEAD"), require = 0)
	private void setTooltipStack(GuiGraphics graphics,
		List<Either<FormattedText, TooltipComponent>> elements,
		int x, int y,
		Font font,
		ItemStack itemStack,
		CallbackInfo info)
	{
		if (setTooltipStack == null)
		{
			try
			{
				setTooltipStack = GuiGraphics.class.getDeclaredMethod("setTooltipStack", ItemStack.class);
			}
			catch (Exception e)
			{
				EquipmentCompare.LOGGER.error(ExceptionUtils.getStackTrace(e));
			}
		}

		try { setTooltipStack.invoke(graphics, itemStack); }
		catch (IllegalAccessException | InvocationTargetException e) {}
	}
}
