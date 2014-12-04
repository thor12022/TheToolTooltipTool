package main.customtools.items;

/*
 * Base item class for getting standard things done with quickly.
 * Extend this for pretty much every item you make.
 */

import main.customtools.CustomTools;
import main.customtools.ModInformation;
import net.minecraft.item.Item;

public class ItemBase extends Item {

	// If you aren't setting multiple textures for your item. IE: Non-Metadata items.
	public ItemBase(String unlocName, String textureName) {
		super();

		setUnlocalizedName(ModInformation.ID + "." + unlocName);
		setTextureName(ModInformation.ID + ":" + textureName);
		setCreativeTab(CustomTools.tabBaseMod);
	}

	// If you are setting multiple textures for your item. IE: Metadata items.
	public ItemBase(String unlocName) {
		super();

		setUnlocalizedName(ModInformation.ID + "." + unlocName);
		setCreativeTab(CustomTools.tabBaseMod);
	}
}
