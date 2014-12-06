package main.customtools.client.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import main.customtools.CustomTools;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{

   @Override
   public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
   {
      return null;
   }

   @Override
   public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
   {
      if(ID == 0)
      {
         CustomTools.logger.info("Open Gui");
      }
      return null;
   }
}
