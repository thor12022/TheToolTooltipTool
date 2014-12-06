package main.customtools;

/*
 * Creation and usage of the config file.
 */

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler
{

   public static Configuration config;

   // Sections to add to the config
   public static String exampleSection = "Example Section";
   public static String generation = "Generation";

   // Options in the config
   public static boolean exampleOption;

   public static void init(File file)
   {
      config = new Configuration(file);
      syncConfig();
   }

   public static void syncConfig()
   {
      config.addCustomCategoryComment(exampleSection, "Example section comment");

      exampleOption = config.get(exampleSection, "exampleOption", true, "Description of option goes here.").getBoolean(exampleOption);

      config.save();
   }
}
