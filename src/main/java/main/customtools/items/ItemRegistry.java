package main.customtools.items;

/*
 * Class to register your items in.
 * The order that you list them here is the order they are registered.
 * Keep that in mind if you like nicely organized creative tabs.
 */

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraft.item.Item;

public class ItemRegistry
{
   // items
   public static Item customPick;

   public static void registerItems()
   {
      Item.ToolMaterial toolMaterial = EnumHelper.addToolMaterial("lapisPick", 2, 20, 0.5f, 2.0f, 30);
      customPick = new ItemCustomPick(toolMaterial, "lapisPick", "customPick");
      GameRegistry.registerItem(customPick, "ItemCustomPick");
   }
}
