package com.anthonyhilyard.equipmentcompare.compat;

import com.anthonyhilyard.legendarytooltips.config.LegendaryTooltipsConfig;

public class LegendaryTooltipsHandler
{
	public static boolean getCenteredTitle()
	{
		return LegendaryTooltipsConfig.getInstance().centeredTitle.get();
	}

	public static boolean getEnforceMinimumWidth()
	{
		return LegendaryTooltipsConfig.getInstance().enforceMinimumWidth.get();
	}
}
