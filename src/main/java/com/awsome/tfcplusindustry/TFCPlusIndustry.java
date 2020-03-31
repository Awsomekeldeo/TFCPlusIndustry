package com.awsome.tfcplusindustry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.awsome.tfcplusindustry.api.Constant.ModGlobals;
import com.dunk.tfc.api.SkillsManager;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, dependencies = Reference.MOD_DEPS)
public class TFCPlusIndustry {
	public static final Logger LOG = LogManager.getLogger(Reference.MOD_NAME);
	
	@Instance(Reference.MODID)
	public static TFCPlusIndustry instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static CommonProxy proxy;
	
	public TFCPlusIndustry() {
		
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		SkillsManager.instance.registerSkill(ModGlobals.SKILL_CHEMISTRY, 100);
		
		ItemSetup.setup();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
