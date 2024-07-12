package com.anthonyhilyard.equipmentcompare.neoforge;

import com.anthonyhilyard.equipmentcompare.EquipmentCompare;
import com.anthonyhilyard.equipmentcompare.neoforge.client.EquipmentCompareNeoForgeClient;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(EquipmentCompare.MODID)
public final class EquipmentCompareNeoForge
{
	public EquipmentCompareNeoForge(ModContainer container, IEventBus modBus)
	{
		// Run our common setup.
		EquipmentCompare.init();

		if (FMLEnvironment.dist == Dist.CLIENT)
		{
			modBus.register(EquipmentCompareNeoForgeClient.class);
		}
	}
}

