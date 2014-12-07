package main.customtools;

/*
 * Creation and usage of the config file.
 */

import main.customtools.items.ItemBase;
import main.customtools.items.ItemCustomPick;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler
{

   public static Configuration config;

   // Sections to add to the config
   public static String sectionName = "Tools";

   // Options in the config
   //public static boolean exampleOption;

   public static void init(File file)
   {
      config = new Configuration(file);
      syncConfig();
   }

   public static void syncConfig()
   {
//      config.addCustomCategoryComment(sectionName, "Tool Information");
//
//      int toolCount = config.get(sectionName, "toolCount", 0, "Number of tools added", 0, 32).getInt();
//      
//      ItemBase[] tools  = new ItemBase[32];
//      
//      for( int count = 0; count < toolCount; ++count)
//      {
//         tools[count] = new ItemCustomPick(toolMaterial, name, texture)
//      }
//
//      config.save();
   }
}
