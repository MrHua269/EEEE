package org.wangxyper.EEEserverPlugin.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.world.SpawnChangeEvent;

public class PlayerListener implements Listener {
    private static FileConfiguration getPLConfig = Bukkit.getPluginManager().getPlugin("EEEEserverplugin").getConfig();
    //设置登入时或退出时广播的消息
    @EventHandler
    public void OnPlayerJoinGame(PlayerJoinEvent e) {
        e.setJoinMessage(e.getPlayer().getName()+" "+getPLConfig.getString("JoinMessage"));
       System.out.println(ChatColor.GREEN+"JoinListener detected !");
    }
    @EventHandler
    public void OnKick(PlayerKickEvent event){
        event.setLeaveMessage(event.getPlayer().getName()+"被管理一jio踢出了服务器");

    }
    @EventHandler
    public void OnPlayerLeftGame(PlayerQuitEvent e) {
        e.setQuitMessage(e.getPlayer().getName()+" "+getPLConfig.getString("LeftMessage"));
        System.out.println(ChatColor.GREEN+"LeftListener detected !");
    }
    @EventHandler
    public void OnBlockBOOM(BlockExplodeEvent event){
        event.setYield(1.00f);
    }
    @EventHandler
    public void OnSpawnChange(SpawnChangeEvent event){
        Bukkit.broadcastMessage(ChatColor.RED+"世界出生点已被改变，原出生点坐标："+event.getPreviousLocation().getBlockX()+","+event.getPreviousLocation().getBlockY()+","+event.getPreviousLocation().getBlockZ());
    }
}
