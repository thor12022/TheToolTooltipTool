package main.customtools.util;

/*
 * Class for most of your events to be registered in.
 * Remember that there are two different registries for Events. This one will not work for everything.
 */

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import main.customtools.CustomTools;
import main.customtools.ModInformation;
import main.customtools.client.gui.TooltipHelper;
import net.minecraft.item.ItemTool;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class EventHandler
{   
   @SubscribeEvent
   public void onItemTooltip(ItemTooltipEvent eventArg)
   {
      if( eventArg.itemStack.getItem() instanceof ItemTool)
      {
         if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
         {
            TooltipHelper.AppendTooltip(eventArg.itemStack, eventArg.toolTip );
         }
         else
         {
            eventArg.toolTip.add(TextHelper.localize(ModInformation.ID + ".tooltip.shiftMessage"));
         }
      }
   }
}
