package com.anthonyhilyard.equipmentcompare.fabric;

import com.anthonyhilyard.equipmentcompare.EquipmentCompare;

import net.fabricmc.api.ModInitializer;

public final class EquipmentCompareFabric implements ModInitializer
{
	@Override
	public void onInitialize()
	{
		// Run our common setup.
		EquipmentCompare.init();
	}
}
