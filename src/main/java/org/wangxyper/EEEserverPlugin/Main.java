package org.wangxyper.EEEserverPlugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.wangxyper.EEEserverPlugin.Commands.SetMessage;
import org.wangxyper.EEEserverPlugin.Listeners.PlayerListener;

public final class Main extends JavaPlugin {

     public void Init(){

     }
    @Override
    public void onEnable() {
         //注册命令和监听器
    this.getPluginLoader().createRegisteredListeners(new PlayerListener(),this);
    this.getCommand("setmessage").setExecutor(new SetMessage());
    }

    @Override
    public void onDisable() {

    }
}
