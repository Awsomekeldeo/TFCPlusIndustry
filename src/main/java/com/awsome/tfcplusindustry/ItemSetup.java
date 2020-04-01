package com.awsome.tfcplusindustry;

import com.awsome.tfcplusindustry.Items.ItemGearMetal;
import com.awsome.tfcplusindustry.Items.ItemGearWood;
import com.awsome.tfcplusindustry.api.ModItems;
import com.awsome.tfcplusindustry.core.ModTabs;

public class ItemSetup extends ModItems {
	public static void setup() {
		//Gears
		wroughtIronGear = new ItemGearMetal().setUnlocalizedName("Wrought Iron Gear");
		woodGear = new ItemGearWood().setUnlocalizedName("WoodGear");
		
		//Creative Tabs
		((ModTabs) ModTabs.TFC_INDUSTRY).setTabIconItem(wroughtIronGear);
		
		
		//Register stuff
		ModItems.registerItems();
	}
}