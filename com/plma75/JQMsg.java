package com.plma75;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class JQMsg extends JavaPlugin implements Listener {
   public void onEnable() {
      Bukkit.getLogger().info("[JQM] Created by Plma75");
      Bukkit.getLogger().info("[JQM] Copyright 2021. Plma75 All rights reserved.");
      this.getServer().getPluginManager().registerEvents(this, this);
      this.saveConfig();
      File cfile = new File(this.getDataFolder(), "config.yml");
      if (cfile.length() == 0L) {
         this.getConfig().options().copyDefaults(true);
         this.saveConfig();
      }

   }

   public void onDisable() {
      Bukkit.getLogger().info("[JQM] Created by Plma75");
      Bukkit.getLogger().info("[JQM] Copyright 2021. Plma75 All rights reserved.");
   }

   @EventHandler
   public void onJoin(PlayerJoinEvent e) {
      Player player = e.getPlayer();
      String Msg = this.getConfig().getString("join-message");
      String jMsg = Msg.replace("{player}", player.getName());
      e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', jMsg));
   }

   @EventHandler
   public void onQuit(PlayerQuitEvent e) {
      Player player = e.getPlayer();
      String Msg = this.getConfig().getString("quit-message");
      String qMsg = Msg.replace("{player}", player.getName());
      e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', qMsg));
   }
}
