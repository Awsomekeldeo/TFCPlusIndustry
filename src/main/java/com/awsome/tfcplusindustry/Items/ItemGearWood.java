package com.awsome.tfcplusindustry.Items;

import java.util.List;

import com.awsome.tfcplusindustry.Reference;
import com.awsome.tfcplusindustry.core.ModTabs;
import com.dunk.tfc.Items.ItemTerra;
import com.dunk.tfc.api.Constant.Global;
import com.dunk.tfc.api.Enums.EnumSize;
import com.dunk.tfc.api.Enums.EnumWeight;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemGearWood extends ItemTerra {
	
	public ItemGearWood() {
		super();
		this.hasSubtypes = true;
		this.setMaxDamage(0);
		setCreativeTab(ModTabs.TFC_INDUSTRY);
		this.metaNames = Global.WOOD_ALL.clone();
		this.setWeight(EnumWeight.MEDIUM);
		this.setSize(EnumSize.SMALL);
	}
	
	@Override
	public int getMetadata(int i) {
		return i;
	}
	
	private IIcon[] icons = new IIcon[Global.WOOD_ALL.length];
	
	@Override
	public IIcon getIconFromDamage(int meta)
	{
		return icons[meta];
	}
	
	@Override
	public void registerIcons(IIconRegister registerer) {
		for(int i = 0; i < Global.WOOD_ALL.length; i++) {
			icons[i] = registerer.registerIcon(Reference.MODID + ":" + "gears/wood/"+Global.WOOD_ALL[i]+" Gear");
		}
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for(int i = 0; i < Global.WOOD_ALL.length; i++) {
			list.add(new ItemStack(this,1,i));
		}
	}
}
