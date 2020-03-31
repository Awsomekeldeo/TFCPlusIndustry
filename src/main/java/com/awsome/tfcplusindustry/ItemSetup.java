package com.awsome.tfcplusindustry;

import com.awsome.tfcplusindustry.Items.ItemGear;
import com.awsome.tfcplusindustry.api.ModItems;
import com.awsome.tfcplusindustry.core.ModTabs;

public class ItemSetup extends ModItems {
	public static void setup() {
		//Gears
		wroughtIronGear = new ItemGear().setUnlocalizedName("Wrought Iron Gear");
		
		//Creative Tabs
		((ModTabs) ModTabs.TFC_INDUSTRY).setTabIconItem(wroughtIronGear);
		
		
		//Register stuff
		ModItems.registerItems();
	}
}