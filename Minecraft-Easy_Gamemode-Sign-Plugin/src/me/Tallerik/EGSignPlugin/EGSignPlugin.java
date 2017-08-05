package me.Tallerik.EGSignPlugin;
 
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
 
public class EGSignPlugin extends JavaPlugin
  implements Listener {
 
 
public void onEnable()
  {
    System.out.println("##! EasyGamemode Sign Plugin Enabled!");
    getServer().getPluginManager().registerEvents(this, this);
  }
 
  public void onDisable() {
    System.out.println("##! EasyGamemode Sign Plugin Disabled!!");
  }
 
 
  @EventHandler
  public void onSignChange(SignChangeEvent sign) {
      Player player = sign.getPlayer();
      if (sign.getLine(0).equalsIgnoreCase("[gm]")) {
    	  if(player.hasPermission("EGSignPlugin.createSign"))
    	  {
    		  sign.setLine(0, "[Gamemode]");
    		  player.sendMessage(ChatColor.DARK_AQUA + "[EasyGamemode Sign Plugin] " + ChatColor.GREEN + "Sign Created!");
    	  }
    	  else
    	  {
    		  player.sendMessage(ChatColor.DARK_AQUA + "[EasyGamemode Sign Plugin] " + ChatColor.RED + "Du hasst keine Rechte ein Gamemode schild zu erstellen! Bitte schreib was anderes drauf!"); 
    		  sign.setLine(0, "");
    		  sign.setLine(1, "");
    		  sign.setLine(2, "");
    		  sign.setLine(3, "");
    	  }
      }	
  }
  
  
  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent event)
  {
	  if(event.getPlayer().hasPermission("EGSignPlugin.useSign"))
	  {
		  if (event.getClickedBlock().getState() instanceof Sign)
	      {
	    	  Sign sign = (Sign)event.getClickedBlock().getState();
	    	  if(sign.getLine(0).equals("[Gamemode]"))
	    	  {
	    		  if(sign.getLine(1).equalsIgnoreCase("Creative"))
	    		  {
	    			  if(event.getPlayer().getGameMode() != GameMode.CREATIVE)
	    			  {
	    				  event.getPlayer().setGameMode(GameMode.CREATIVE);
		    			  event.getPlayer().sendMessage(ChatColor.DARK_AQUA + "[EasyGamemode Sign Plugin] " + ChatColor.GREEN + "Du wurdest in den Kreativmodus gesetzt!");
	    			  }
	    			  else
	    			  {
	    				  event.getPlayer().sendMessage(ChatColor.DARK_AQUA + "[EasyGamemode Sign Plugin] " + ChatColor.RED + "Du bist bereits im Kreativmodus!");
	    			  }
 	    		  }
	    		  if(sign.getLine(1).equalsIgnoreCase("Survival"))
	    		  {
	    			  if(event.getPlayer().getGameMode() != GameMode.SURVIVAL)
	    			  {
	    				  event.getPlayer().setGameMode(GameMode.SURVIVAL);
		    			  event.getPlayer().sendMessage(ChatColor.DARK_AQUA + "[EasyGamemode Sign Plugin] " + ChatColor.GREEN + "Du wurdest in den Überlebensmodus gesetzt!");
	    			  }
	    			  else
	    			  {
	    				  event.getPlayer().sendMessage(ChatColor.DARK_AQUA + "[EasyGamemode Sign Plugin] " + ChatColor.RED + "Du bist bereits im Überlebensmodus!");
	    			  }
 	    		  }
 	    	  }
 	      }
 	  }
   }
}



