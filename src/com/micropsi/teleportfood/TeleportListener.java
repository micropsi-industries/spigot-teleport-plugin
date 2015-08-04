package com.micropsi.teleportfood;

import java.util.logging.Logger;
//import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class TeleportListener implements Listener {

	public static final Logger log = Bukkit.getLogger();

	@EventHandler
	public void onPlayerCommand(PlayerCommandPreprocessEvent event){
		if(!event.isCancelled()){
			if(event.getMessage().contains("tppos")){
				Player player = event.getPlayer();
//				log.log(Level.INFO, "decreasing food after teleport");
				player.setFoodLevel(player.getFoodLevel() - 1);
			}
		}
	}

}
