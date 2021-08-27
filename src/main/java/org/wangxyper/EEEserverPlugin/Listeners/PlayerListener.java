package org.wangxyper.EEEserverPlugin.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
public class PlayerListener implements Listener {
    private static FileConfiguration getPLConfig = Bukkit.getPluginManager().getPlugin("EEEEserverplugin").getConfig();
    //设置登入时或退出时广播的消息
    @EventHandler
    public void OnPlayerJoinGame(PlayerJoinEvent e) {
        e.setJoinMessage(e.getPlayer().getName()+" "+getPLConfig.getString("JoinMessage"));
       System.out.println("JoinListener detected !");
    }

    @EventHandler
    public void OnPlayerLeftGame(PlayerQuitEvent e) {
        e.setQuitMessage(e.getPlayer().getName()+" "+getPLConfig.getString("LeftMessage"));
        System.out.println("LeftListener detected !");
    }
}
