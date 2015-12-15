package main.thetooltooltiptool;

/*
 * Check all the classes for (hopefully) detailed descriptions of what it does. There will also be tidbits of comments throughout the codebase.
 * If you wish to add a description to a class, or extend/change an existing one, submit a PR with your changes.
 */

import java.io.File;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.SideOnly;
import main.thetooltooltiptool.proxies.CommonProxy;
import main.thetooltooltiptool.util.EventHandler;
import main.thetooltooltiptool.util.TextHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, dependencies = ModInformation.DEPEND)
public class TheToolTooltipTool
{

   @SidedProxy(clientSide = ModInformation.CLIENTPROXY, serverSide = ModInformation.COMMONPROXY)
   public static CommonProxy proxy;

   public static Logger logger = LogManager.getLogger(ModInformation.NAME);
   public static Configuration config;
   public static Item[] pickaxes;
   public static Item[] axes;
   public static Item[] shovels;
   
   @Mod.Instance
   public static TheToolTooltipTool instance;

   @Mod.EventHandler
   public void preInit(FMLPreInitializationEvent event)
   {
      if(event.getSide().isClient())
      {
    	  MinecraftForge.EVENT_BUS.register(new EventHandler());
    	  logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.preInit"));
      }
      else
      {
    	  logger.warn(TextHelper.localize("warn." + ModInformation.ID + ".console.load.preInitServer"));
      }
   }
}
