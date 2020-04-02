package com.awsome.tfcplusindustry.Util;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;

public class TEUtils {
	//Immersive Engineering waterwheel flow code
	static int getEffectiveFlowDecay(IBlockAccess world, int x, int y, int z, Material mat)
	{
		if (world.getBlock(x, y, z).getMaterial() != mat)
			return -1;
		int l = world.getBlockMetadata(x, y, z);
		if (l >= 8)
			l = 0;
		return l;
	}
	
	public static Vec3 getFlowVector(World world, int x, int y, int z)
	{
		if(world.getBlock(x, y, z) instanceof BlockFluidBase)
			return ((BlockFluidBase)world.getBlock(x, y, z)).getFlowVector(world, x, y, z);
		else if( !(world.getBlock(x, y, z) instanceof BlockLiquid))
			return Vec3.createVectorHelper(0, 0, 0);

		BlockLiquid block = (BlockLiquid)world.getBlock(x, y, z);
		Vec3 vec3 = Vec3.createVectorHelper(0.0D, 0.0D, 0.0D);
		Material mat = block.getMaterial();
		int l = getEffectiveFlowDecay(world, x, y, z, mat);

		for (int i1 = 0; i1 < 4; ++i1)
		{
			int j1 = x;
			int k1 = z;

			if (i1 == 0)
				j1 = x - 1;
			if (i1 == 1)
				k1 = z - 1;
			if (i1 == 2)
				++j1;
			if (i1 == 3)
				++k1;
			int l1 = getEffectiveFlowDecay(world, j1, y, k1, mat);
			int i2;

			if (l1 < 0)
			{
				if (!world.getBlock(j1, y, k1).getMaterial().blocksMovement())
				{
					l1 = getEffectiveFlowDecay(world, j1, y - 1, k1, mat);

					if (l1 >= 0)
					{
						i2 = l1 - (l - 8);
						vec3 = vec3.addVector((double)((j1 - x) * i2), (double)((y - y) * i2), (double)((k1 - z) * i2));
					}
				}
			}
			else if (l1 >= 0)
			{
				i2 = l1 - l;
				vec3 = vec3.addVector((double)((j1 - x) * i2), (double)((y - y) * i2), (double)((k1 - z) * i2));
			}
		}

		if (world.getBlockMetadata(x, y, z) >= 8)
		{
			boolean flag = false;

			if (flag || block.isBlockSolid(world, x, y, z - 1, 2))
				flag = true;
			if (flag || block.isBlockSolid(world, x, y, z + 1, 3))
				flag = true;
			if (flag || block.isBlockSolid(world, x - 1, y, z, 4))
				flag = true;
			if (flag || block.isBlockSolid(world, x + 1, y, z, 5))
				flag = true;
			if (flag || block.isBlockSolid(world, x, y + 1, z - 1, 2))
				flag = true;
			if (flag || block.isBlockSolid(world, x, y + 1, z + 1, 3))
				flag = true;
			if (flag || block.isBlockSolid(world, x - 1, y + 1, z, 4))
				flag = true;
			if (flag || block.isBlockSolid(world, x + 1, y + 1, z, 5))
				flag = true;
			if (flag)
				vec3 = vec3.normalize().addVector(0.0D, -6.0D, 0.0D);
		}
		vec3 = vec3.normalize();
		return vec3;
	}
	
}
