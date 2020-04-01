package com.awsome.tfcplusindustry.Items;

import java.util.List;

import com.awsome.tfcplusindustry.Reference;
import com.awsome.tfcplusindustry.api.Enums.EnumGearSize;
import com.awsome.tfcplusindustry.core.ModTabs;
import com.dunk.tfc.Core.Metal.MetalRegistry;
import com.dunk.tfc.Items.ItemTerra;
import com.dunk.tfc.TileEntities.TEAnvil;
import com.dunk.tfc.api.Metal;
import com.dunk.tfc.api.TFC_ItemHeat;
import com.dunk.tfc.api.Enums.EnumSize;
import com.dunk.tfc.api.Enums.EnumWeight;
import com.dunk.tfc.api.Interfaces.ISmeltable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemGearMetal extends ItemTerra implements ISmeltable {
	
	private EnumSize size = EnumSize.SMALL;
	private EnumGearSize gearSize = EnumGearSize.SMALL;
	private String metal;
	private short metalAmount;
	private boolean smeltable = true;
	
	
	public ItemGearMetal()
	{
		super();
		setCreativeTab(ModTabs.TFC_INDUSTRY);
		this.setFolder("gears/");
		metalAmount = 400;
	}

	public ItemGearMetal(boolean canSmelt)
	{
		this();
		smeltable = canSmelt;
	}

	public ItemTerra setMetal(String m, int amt)
	{
		metal = m;
		metalAmount = (short) amt;
		return this;
	}

	@Override
	public void registerIcons(IIconRegister registerer)
	{
		this.itemIcon = registerer.registerIcon(Reference.MODID + ":" + textureFolder+this.getUnlocalizedName().replace("item.", "").replace("Weak ", "").replace("HC ", ""));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}

	@Override
	public EnumSize getSize(ItemStack is)
	{
		return size;
	}

	@Override
	public EnumWeight getWeight(ItemStack is)
	{
		return EnumWeight.MEDIUM;
	}

	@Override
	public ItemGearMetal setSize(EnumSize s)
	{
		size = s;
		return this;
	}
	
	public ItemGearMetal setGearSize(EnumGearSize s) {
		gearSize = s;
		return this;
	}
	
	public EnumGearSize getGearSize(ItemStack is) {
		return gearSize;
	}

	public void addCreativeItems(List<ItemStack> list)
	{
		list.add(new ItemStack(this));
	}
	
	@Override
	public Metal getMetalType(ItemStack is) 
	{
		if(metal == null) 
		{
			return MetalRegistry.instance.getMetalFromItem(this);
		} 
		else 
		{
			return MetalRegistry.instance.getMetalFromString(metal);
		}
	}
	
	@Override
	public short getMetalReturnAmount(ItemStack is) {
		// TODO Auto-generated method stub
		return metalAmount;
	}

	@Override
	public boolean isSmeltable(ItemStack is) 
	{
		// TODO Auto-generated method stub
		return smeltable;
	}

	@Override
	public EnumTier getSmeltTier(ItemStack is) {
		// TODO Auto-generated method stub
		return EnumTier.TierI;
	}
	
	@Override
	public int getItemStackLimit(ItemStack is)
	{
		if (is.hasTagCompound())
		{
			NBTTagCompound tag = is.getTagCompound();
			if (TFC_ItemHeat.hasTemp(is) || tag.hasKey(TEAnvil.ITEM_CRAFTING_VALUE_TAG) || tag.hasKey(TEAnvil.ITEM_CRAFTING_RULE_1_TAG))
			{
				return 1;
			}
		}

		return super.getItemStackLimit(is);
	}
}