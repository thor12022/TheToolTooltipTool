package main.customtools.items;

import main.customtools.CustomTools;
import main.customtools.ModInformation;
import net.minecraft.item.ItemPickaxe;

public class ItemCustomPick extends ItemPickaxe
{
   public ItemCustomPick(ToolMaterial toolMaterial, String name, String texture)
   {
      super(toolMaterial);
      this.setTextureName(ModInformation.ID + ":" + texture);
      this.setUnlocalizedName(ModInformation.ID + "." + name);
      this.setCreativeTab(CustomTools.creativeTabCustomTools);
   }
}
