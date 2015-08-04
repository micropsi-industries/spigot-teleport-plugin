package com.micropsi.teleportfood;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.HandlerList;

/**
 * Simple Plugin
 *
 */
public class TeleportFoodPlugin extends JavaPlugin
{
	protected TeleportListener listener;
	
    public void onEnable(){
        listener = new TeleportListener();
        getServer().getPluginManager().registerEvents(listener, this);
    }

    public void onDisable(){
        HandlerList.unregisterAll(listener);
    }
}