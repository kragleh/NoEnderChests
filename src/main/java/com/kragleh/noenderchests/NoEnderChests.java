package com.kragleh.noenderchests;

import org.bukkit.ChatColor;
import org.bukkit.block.EnderChest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoEnderChests extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        if (event.getPlayer().hasPermission(getConfig().getString("permission"))) return;

        if (event.getInventory().getHolder() instanceof EnderChest) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("message")));
        }
    }

}
