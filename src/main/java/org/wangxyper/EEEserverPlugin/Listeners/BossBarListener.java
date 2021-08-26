package org.wangxyper.EEEserverPlugin.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class BossBarListener implements Listener {
    public final static BossBar getBossBar = Bukkit.createBossBar("0x00", BarColor.RED, BarStyle.SEGMENTED_20);
    private boolean trigger = false;
    private static FileConfiguration getPLConfig = Bukkit.getPluginManager().getPlugin("EEEEserverplugin").getConfig();
    public static boolean enable = false;
    public static Thread updateThread = new Thread(){
        public void run(){
            while(enable){
                getBossBar.setColor(BarColor.valueOf(getPLConfig.getString("BossBarColor")));
                getBossBar.setTitle(getPLConfig.getString("BarString"));
            }
        }
    };
    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent e){
     getBossBar.addPlayer(e.getPlayer());
     if(!trigger){
         updateThread.start();
         this.trigger = false;
     }
    }
    public void OnPlayerQuit(PlayerQuitEvent e){
        getBossBar.removePlayer(e.getPlayer());
    }
}
