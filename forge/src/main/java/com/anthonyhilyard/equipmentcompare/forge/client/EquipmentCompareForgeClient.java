package com.anthonyhilyard.equipmentcompare.forge.client;

import com.anthonyhilyard.equipmentcompare.EquipmentCompare;

import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = EquipmentCompare.MODID, bus = Bus.MOD)
public class EquipmentCompareForgeClient
{
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void onClientSetup(FMLClientSetupEvent event)
	{
	}
}
