package main.thetooltooltiptool.client.gui;

import java.util.List;
import java.util.Set;

import main.thetooltooltiptool.ModInformation;
import main.thetooltooltiptool.util.TextHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockStone;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;



public class TooltipHelper
{
   public static final void AppendTooltip(ItemStack itemStack, List<String> tooltip)
   {
       int maxDamageMultiplier = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, itemStack) + 1;
       if( maxDamageMultiplier == 1)
       {
          tooltip.add(new String(TextHelper.LIGHT_GRAY + 
                                 TextHelper.localize(ModInformation.ID + ".tooltip.maxDamage")+": " + 
                                 itemStack.getItem().getMaxDamage()));
       }
       else
       {
          tooltip.add(new String(TextHelper.LIGHT_GRAY + 
                TextHelper.localize(ModInformation.ID + ".tooltip.averageMaxDamage")+": " + 
                itemStack.getItem().getMaxDamage() * maxDamageMultiplier));
       }
       float extraEfficiency = ( EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, itemStack) * 0.3f ) + 1;
       Set<String> toolClasses = itemStack.getItem().getToolClasses(itemStack);
       for(String toolClass : toolClasses)
       {
          tooltip.add(new String(TextHelper.LIGHT_GRAY + 
                                 TextHelper.localize(ModInformation.ID + ".tooltip.harvestLevel") + 
                                 " (" + TextHelper.localize(ModInformation.ID + ".tooltip." + toolClass) + "): " + 
                                 itemStack.getItem().getHarvestLevel(itemStack, toolClass)));
          Block digBlock;
          if( toolClass.equals("pickaxe") || toolClass.equals("paxel") )
          {
             digBlock = (BlockStone)Block.blockRegistry.getObject("stone");
             //! @todo This should use the metadata of the tool
             tooltip.add(new String(TextHelper.LIGHT_GRAY + 
                                    TextHelper.localize(ModInformation.ID + ".tooltip.digSpeed") + 
                                    " (" + TextHelper.localize(ModInformation.ID + ".tooltip." + toolClass) + "): " + 
                                    String.format("%.1f", itemStack.getItem().getDigSpeed(itemStack, digBlock,0) * extraEfficiency)));
          }
          else if( toolClass.equals("shovel") )
          {
             digBlock = (BlockDirt)Block.blockRegistry.getObject("dirt");
             //! @todo This should use the metadata of the tool
             tooltip.add(new String(TextHelper.LIGHT_GRAY + 
                                    TextHelper.localize(ModInformation.ID + ".tooltip.digSpeed") +
                                    " (" + TextHelper.localize(ModInformation.ID + ".tooltip." + toolClass) + "): " + 
                                    String.format("%.1f", itemStack.getItem().getDigSpeed(itemStack, digBlock,0) * extraEfficiency)));
          }else if( toolClass.equals("axe") )
          {
             digBlock = (BlockLog)Block.blockRegistry.getObject("log");
             //! @todo This should use the metadata of the tool
             tooltip.add(new String(TextHelper.LIGHT_GRAY + 
                                    TextHelper.localize(ModInformation.ID + ".tooltip.digSpeed") +
                                    " (" + TextHelper.localize(ModInformation.ID + ".tooltip." + toolClass) + "): " + 
                                    String.format("%.1f", itemStack.getItem().getDigSpeed(itemStack, digBlock,0) * extraEfficiency)));
          } 
       }       
       tooltip.add(new String(TextHelper.LIGHT_GRAY + 
             TextHelper.localize(ModInformation.ID + ".tooltip.enchantability") + ": " + 
             itemStack.getItem().getItemEnchantability()));
   }
}
