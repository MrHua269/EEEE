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

import java.util.List;

public class BossBarListener implements Listener {
    private static FileConfiguration getPLConfig = Bukkit.getPluginManager().getPlugin("EEEEserverplugin").getConfig();
    public final static BossBar getBossBar = Bukkit.createBossBar("0x00", BarColor.RED, BarStyle.SEGMENTED_20);
    private static boolean trigger = false;
    public static List<String> Strings = getPLConfig.getStringList("BarStrings");
    public static List<String> BarColorStrings = getPLConfig.getStringList("BarColors");
    public static boolean enable = getPLConfig.getBoolean("EnableBossBar");
    private static boolean Reload = false;
    //更新标题
    public static Thread updateTitleThread = new Thread(){
        public void run(){
            //在字符串列表的范围内循环
            while(enable){
             for(int i=1;i<Strings.size()&&trigger;i++) {
                getBossBar.setTitle(Strings.get(i));
                //复位
                try { Thread.sleep(getPLConfig.getInt("SleepTime")); } catch (InterruptedException e) { e.printStackTrace(); }
             }
            }

        }
    };
    //更新颜色
    public static Thread updateColorThread = new Thread(){
      public void run(){
          //在字符串列表范围内循环
          while(enable){
            for(int i=1;i<BarColorStrings.size()&&trigger;i++) {
             //利用BarColor.valueOf把字符串转换成颜色
              getBossBar.setColor(BarColor.valueOf(BarColorStrings.get(i)));
              //复位
              try { Thread.sleep(getPLConfig.getInt("SleepTime")); } catch (InterruptedException e) { e.printStackTrace(); }

           }
          }
      }
    };
    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent e){
        //让玩家可以看到血条
     getBossBar.addPlayer(e.getPlayer());
     //布尔锁
     if(!trigger){
         //启动线程
         trigger = true;
         updateTitleThread.start();
         updateColorThread.start();
     }
    }
    public void OnPlayerQuit(PlayerQuitEvent e){
        //删除玩家
        getBossBar.removePlayer(e.getPlayer());
    }
    //todo 检查错误
    public static void reload(){
        trigger = false;
    }
}
