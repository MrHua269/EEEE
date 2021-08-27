package org.wangxyper.EEEserverPlugin.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

public class MessageListener implements Listener {
    private HashMap<Player,Integer> MessageCache = new HashMap<>();
    private HashMap<Player,Boolean> CoolDownCache = new HashMap<>();
    @EventHandler
    public void OnMessage(AsyncPlayerChatEvent event){
      int CountCache = MessageCache.get(event.getPlayer());
      if(event.getMessage().length() > 16){
          MessageCache.replace(event.getPlayer(),CountCache+1);
      }
      if(MessageCache.get(event.getPlayer())>50){
          event.setCancelled(true);
          if(!CoolDownCache.get(event.getPlayer())) {
              CoolDownCache.replace(event.getPlayer(), true);
          }
      }
      if(CoolDownCache.get(event.getPlayer())){
           Thread cool = new Thread(){
             public void run(){
                  try {
                      Thread.sleep(30*1000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  CoolDownCache.replace(event.getPlayer(),true,false);
             }
           };    cool.start();
      }

    }
    @EventHandler
    public void OnJoin(PlayerJoinEvent e){
        MessageCache.put(e.getPlayer(),0);
        CoolDownCache.put(e.getPlayer(),false);
    }
}
