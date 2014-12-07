package main.customtools.items;

import main.customtools.CustomTools;
import main.customtools.ModInformation;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemCustomPick extends ItemPickaxe
{
   private String displayName;
   private String unlocalizedName;
   
   public ItemCustomPick(ToolMaterial toolMaterial, String name, String texture)
   {
      super(toolMaterial);
      this.setTextureName(ModInformation.ID + ":" + texture);
      this.setUnlocalizedName(ModInformation.ID + "." + name);
      this.setCreativeTab(CustomTools.creativeTabCustomTools);
      displayName = name;
      unlocalizedName = toolMaterial.name();
   }
   
   @Override
   public String getUnlocalizedName(ItemStack stack) {

      return unlocalizedName;
   }
   
   @Override
   public String getItemStackDisplayName(ItemStack stack) {

      return displayName;
   }
}
