package com.anthonyhilyard.equipmentcompare.forge;

import com.anthonyhilyard.equipmentcompare.EquipmentCompare;
import com.anthonyhilyard.equipmentcompare.forge.client.EquipmentCompareForgeClient;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(EquipmentCompare.MODID)
public final class EquipmentCompareForge
{
	public EquipmentCompareForge()
	{
		// Run our common setup.
		EquipmentCompare.init();

		if (FMLEnvironment.dist == Dist.CLIENT)
		{
			MinecraftForge.EVENT_BUS.register(EquipmentCompareForgeClient.class);
		}

		ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> "ANY", (remote, isServer) -> true));
	}
}
