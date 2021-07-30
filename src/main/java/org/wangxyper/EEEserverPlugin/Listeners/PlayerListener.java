package org.wangxyper.EEEserverPlugin.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.wangxyper.EEEserverPlugin.Funcitons.MessageSelector;
public class PlayerListener implements Listener {
    private MessageSelector get = new MessageSelector();
//设置登入时或退出时广播的消息
    @EventHandler
    public void OnPlayerJoinGame(PlayerJoinEvent e) {
        e.setJoinMessage(get.MessageSelector(e.getPlayer().getName(), 1, false, e.getPlayer().isOp()));
    }

    @EventHandler
    public void OnPlayerLeftGame(PlayerQuitEvent e) {
        e.setQuitMessage(get.MessageSelector(e.getPlayer().getName(), 0, false, e.getPlayer().isOp()));
    }


}
