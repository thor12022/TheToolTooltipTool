package main.customtools;

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
import main.customtools.client.gui.CreativeTabBaseMod;
import main.customtools.client.gui.GuiHandler;
import main.customtools.items.ItemCustomPick;
import main.customtools.proxies.CommonProxy;
import main.customtools.util.EventHandler;
import main.customtools.util.TextHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, dependencies = ModInformation.DEPEND)
public class CustomTools
{

   @SidedProxy(clientSide = ModInformation.CLIENTPROXY, serverSide = ModInformation.COMMONPROXY)
   public static CommonProxy proxy;

   public static CreativeTabs creativeTabCustomTools = new CreativeTabBaseMod(ModInformation.ID + ".creativeTab");
   public static Logger logger = LogManager.getLogger(ModInformation.NAME);
   public static Configuration config;
   public static Item[] pickaxes;
   
   @Mod.Instance
   public static CustomTools instance;

   @Mod.EventHandler
   public void preInit(FMLPreInitializationEvent event)
   {
      logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.preInit"));

      config = new Configuration(event.getSuggestedConfigurationFile());

      int toolCount = config.get("pickaxes", "pickaxeCount", 1, "Number of pickaxes added", 0, 32).getInt();
      
      pickaxes = new Item[32];
      
      String name, texture;
      int harvestLevel, maxUses, enchantability;
      float efficiency, damage;
      
      for( int count = 0; count < toolCount; ++count)
      {
         name = config.get("pickaxes.pickaxe"+count, "name", "Custom Pickaxe", "Displayed name of Pickaxe").getString();
         texture = config.get("pickaxes.pickaxe"+count, "texture", "customtools:customPickaxe", "Texture name of pickaxe").getString();
         
         harvestLevel = config.get("pickaxes.pickaxe"+count, "harvestLevel", 0, "Harvest Level of Pickaxe; 3=DIAMOND, 2=IRON, 1=STONE, 0=WOOD/GOLD", 0, 16).getInt();
         maxUses = config.get("pickaxes.pickaxe"+count, "maxUses", -1, "Max uses of Pickaxe; wood=59, stone=131, iron=250, diamond=1561, gold=32").getInt();
         enchantability = config.get("pickaxes.pickaxe"+count, "enchantability", 32, "Enchantability of pickaxe; Diamond=??, Iron=??, Stone=??, Wood=??, Gold=??").getInt();
         
         efficiency = (float)config.get("pickaxes.pickaxe"+count, "efficiency", 3.0f, "Efficiency of pickaxe").getDouble();
         damage = config.get("pickaxes.pickaxe"+count, "damage", 1, "Damage against entities").getInt();
         
         Item.ToolMaterial toolMaterial = EnumHelper.addToolMaterial("customPickaxe"+count, harvestLevel, maxUses, efficiency, damage, enchantability);
         pickaxes[count] = new ItemCustomPick(toolMaterial, name, texture);
         GameRegistry.registerItem(pickaxes[count], "customPickaxe"+count);
      }
      
      MinecraftForge.EVENT_BUS.register(new EventHandler());
      NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

   }

   @Mod.EventHandler
   public void init(FMLInitializationEvent event)
   {
      logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.init"));
      config.save();
   }

   @Mod.EventHandler
   public void postInit(FMLPostInitializationEvent event)
   {
      logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.postInit"));
   }
}
