package com.awsome.tfcplusindustry.core;

import com.dunk.tfc.Core.TFCTabs;

import net.minecraft.creativetab.CreativeTabs;

public class ModTabs extends TFCTabs{
	
	public static final CreativeTabs TFC_INDUSTRY = new ModTabs("TFCIndustry");
			
	public ModTabs(String str) {
		super(str);
	}
	
	public ModTabs(String str, int icon) {
		super(str, icon);
	}
}
