package com.micropsi.teleportfood;

import java.util.logging.Logger;
//import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class TeleportListener implements Listener {

	public static final Logger log = Bukkit.getLogger();

	@EventHandler
	public void onPlayerCommand(PlayerCommandPreprocessEvent event){
		if(!event.isCancelled()){
			if(event.getMessage().contains("tppos")){
				Player player = event.getPlayer();
//				log.log(Level.INFO, "Current player exhaustion: {0}", player.getExhaustion());
				// max exhaustion level is 4. See minecraft hunger mechanics
				if(player.getExhaustion() + 1 > 4){
					player.setFoodLevel(player.getFoodLevel() - 1);
					player.setExhaustion(0);
				} else {
					player.setExhaustion((float) (player.getExhaustion() + 1));
				}
			}
		}
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		if(event.getItem().getType().isEdible()){
			// player is eating, reset exhaustion level
			Player player = event.getPlayer();
			player.setExhaustion(0);
		}
	}

}
