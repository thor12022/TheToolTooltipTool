package main.customtools.util;

//General place to register all oreDict recipes.

import main.customtools.blocks.BlockRegistry;
import main.customtools.items.ItemRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictHandler {

	//Oredict entries
	//items
	public static String powderBlaze = "powderBlaze";
	public static String quisqueLapis = "dustQuisqueLapis";

	//blocks
	public static String quisqueLapis_ore = "oreLapisQuisque";

	public static void registerOreDict() {
		OreDictionary.registerOre(powderBlaze, new ItemStack(Items.blaze_powder, 1, 0));
		OreDictionary.registerOre(quisqueLapis, new ItemStack(ItemRegistry.quisqueLapis));

		OreDictionary.registerOre(quisqueLapis_ore, new ItemStack(BlockRegistry.quisqueLapisOre));
	}
}