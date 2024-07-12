package com.anthonyhilyard.equipmentcompare.neoforge.compat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

public class CuriosHandler
{
	public static List<ItemStack> getCuriosMatchingSlot(LivingEntity player, ItemStack curio)
	{
		List<ItemStack> result = new ArrayList<ItemStack>();
		Set<String> tags = CuriosApi.getItemStackSlots(curio, true).keySet();

		if (tags.isEmpty())
		{
			return result;
		}

		Optional<IItemHandlerModifiable> allCurios = CuriosApi.getCuriosInventory(player).map(ICuriosItemHandler::getEquippedCurios);

		if (allCurios.isPresent())
		{
			for (int i = 0; i < allCurios.get().getSlots(); i++)
			{
				ItemStack itemStack = allCurios.get().getStackInSlot(i);

				// If this curio shares any tags with the input curio, add it.
				Set<String> itemTags = CuriosApi.getItemStackSlots(itemStack, true).keySet();
				Set<String> sharedTags = new HashSet<String>(tags);
				sharedTags.retainAll(itemTags);
				if (!sharedTags.isEmpty())
				{
					result.add(itemStack);
				}
			}
		}

		return result;
	}
}