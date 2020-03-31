package com.awsome.tfcplusindustry.api;

import com.awsome.tfcplusindustry.TFCPlusIndustry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
	public static Item wroughtIronGear;
	
	public static void registerItems() {
		TFCPlusIndustry.LOG.info("Registering Items");
		
		GameRegistry.registerItem(wroughtIronGear, wroughtIronGear.getUnlocalizedName());
	}
}
