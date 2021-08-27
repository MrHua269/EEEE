package org.wangxyper.EEEserverPlugin;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.wangxyper.EEEserverPlugin.Listeners.BossBarListener;
import org.wangxyper.EEEserverPlugin.Listeners.PlayerListener;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;

public final class Main extends JavaPlugin {
    @Override
    public void saveResource(String resourcePath, boolean replace) {
        if (resourcePath != null && !resourcePath.equals("")) {
            resourcePath = resourcePath.replace('\\', '/');
            InputStream in = this.getResource(resourcePath);
            if (in == null) {
            } else {
                File outFile = new File(getDataFolder(), resourcePath);
                int lastIndex = resourcePath.lastIndexOf(47);
                File outDir = new File(getDataFolder(), resourcePath.substring(0, lastIndex >= 0 ? lastIndex : 0));
                if (!outDir.exists()) {
                    outDir.mkdirs();
                }

                try {
                    if (outFile.exists() && !replace) {
                        getLogger().log(Level.WARNING, "Could not save " + outFile.getName() + " to " + outFile + " because " + outFile.getName() + " already exists.");
                    } else {
                        OutputStream out = new FileOutputStream(outFile);
                        byte[] buf = new byte[1024];

                        int len;
                        while((len = in.read(buf)) > 0) {
                            out.write(buf, 0, len);
                        }

                        out.close();
                        in.close();
                    }
                } catch (IOException var10) {
                    getLogger().log(Level.SEVERE, "Could not save " + outFile.getName() + " to " + outFile, var10);
                }

            }
        } else {
            throw new IllegalArgumentException("ResourcePath cannot be null or empty");
        }
    }
    @Override
    public void saveDefaultConfig(){
        if (!new File(getDataFolder(), "config.yml").exists()) {
            this.saveResource("config.yml", false);
        }
    }
    @Override
    public void onEnable() {

         //装逼字幕
        getLogger().info("§c\t //////////////////////////////////////////////////////////////////////");
        getLogger().info("§3\t  %%%%%%%%   %%%%%%%%   %%%%%%%%   %%%%%%%%   %%%%%%%%   %%%%%%%%%%");
        getLogger().info("§3\t  %%         %%         %%         %%         %%         %%      %%");
        getLogger().info("§3\t  %%         %%         %%         %%         %%         %%      %%");
        getLogger().info("§3\t  %%%%%%%%   %%%%%%%%   %%%%%%%%   %%%%%%%%   %%%%%%%%   %%%%%%%%%%");
        getLogger().info("§4\t  %%         %%         %%         %%               %%   %%");
        getLogger().info("§4\t  %%         %%         %%         %%               %%   %%");
        getLogger().info("§4\t  %%%%%%%%   %%%%%%%%   %%%%%%%%   %%%%%%%%   %%%%%%%%   %% V1.0.5BETA");
        getLogger().info("§c\t //////////////////////////////////////////////////////////////////////");
        //初始化
        getLogger().info("注册监听器......");
        Bukkit.getPluginManager().registerEvents(new PlayerListener(),this);
        Bukkit.getPluginManager().registerEvents(new BossBarListener(),this);
        getLogger().info("已注册");
        getLogger().info("启用Boss栏为："+getConfig().getBoolean("EnableBossBar"));
        getLogger().info("Boss栏更新时间："+getConfig().getBoolean("SleepTime"));
        this.saveConfig();
    }

    @Override
    public void onDisable() {

    }

}
