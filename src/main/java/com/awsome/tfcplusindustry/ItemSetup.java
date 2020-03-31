package com.awsome.tfcplusindustry;

import com.awsome.tfcplusindustry.Items.ItemGear;
import com.awsome.tfcplusindustry.api.ModItems;
import com.awsome.tfcplusindustry.core.ModTabs;
import com.dunk.tfc.Core.TFCTabs;

public class ItemSetup extends ModItems {
	public static void setup() {
		//Creative Tabs
		((TFCTabs) ModTabs.TFC_INDUSTRY).setTabIconItem(wroughtIronGear);
		
		//Gears
		wroughtIronGear = new ItemGear().setUnlocalizedName("Wrought Iron Gear");
	}
}