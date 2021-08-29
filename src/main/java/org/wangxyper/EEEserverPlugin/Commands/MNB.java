package org.wangxyper.EEEserverPlugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MNB implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player getPlayer = (Player) commandSender;
            if(strings[0]!=null){
                Thread message = new Thread(){
                    public void run(){
                        try {
                            Player getOffPlayer = Bukkit.getPlayer(strings[0]);
                            getOffPlayer.teleport(getPlayer.getLocation());
                            getOffPlayer.sendMessage("旁白:" + "有一个人前来卖瓜");
                            getPlayer.sendMessage("旁白:" + "有一个人前来卖瓜");
                            Thread.sleep(6000);
                            getOffPlayer.sendMessage("我：" + "哥们，你这瓜多少钱一斤啊");
                            getPlayer.sendMessage("买瓜人：" + "哥们，你这瓜多少钱一斤啊");
                            Thread.sleep(500);
                            getPlayer.sendMessage("我:" + "两块钱一斤");
                            getOffPlayer.sendMessage("卖瓜人:" + "两块钱一斤");
                            Thread.sleep(2000);
                            getOffPlayer.sendMessage("我:" + "what's up,你这瓜皮子是金子做的,还是瓜粒子是金子做的？");
                            getPlayer.sendMessage("买瓜人:" + "what's up,你这瓜皮子是金子做的,还是瓜粒子是金子做的？");
                            Thread.sleep(3000);
                            getOffPlayer.sendMessage("卖瓜人：你瞧瞧这现在哪有卖瓜的？这都是大棚的瓜");
                            getPlayer.sendMessage("我：你瞧瞧这现在哪有卖瓜的？这都是大棚的瓜");
                            Thread.sleep(3000);
                            getOffPlayer.sendMessage("我：刑，给我挑一个");
                            getPlayer.sendMessage("买瓜人：行，给我挑一个");
                            Thread.sleep(2000);
                            getOffPlayer.sendMessage("我：你这瓜保熟吗?");
                            getPlayer.sendMessage("买瓜人：你这瓜保熟吗?");
                            Thread.sleep(1000);
                            getOffPlayer.sendMessage("卖瓜人：我开水果摊的，能买给你生瓜蛋子啊?");
                            getPlayer.sendMessage("我：（不屑の笑）我开水果摊的，能买给你生瓜蛋子啊?");
                            Thread.sleep(4000);
                            getOffPlayer.sendMessage("我：我问你这瓜保熟吗");
                            getPlayer.sendMessage("买瓜人：我问你这瓜保熟吗");
                            Thread.sleep(5000);
                            getOffPlayer.sendMessage("卖瓜人：你故意找茬是不是?");
                            getPlayer.sendMessage("我：你故意找茬是不是?");
                            Thread.sleep(4000);
                            getOffPlayer.sendMessage("我：你这瓜要保熟我肯定要啊");
                            getPlayer.sendMessage("买瓜人：你这瓜要保熟我肯定要啊");
                            Thread.sleep(3000);
                            getOffPlayer.sendMessage("买瓜人：15斤30块");
                            getPlayer.sendMessage("我：15斤30块");
                            Thread.sleep(1000);
                            getOffPlayer.sendMessage("我：你这称有问题啊");
                            getPlayer.sendMessage("买瓜人：你这称有问题啊");
                            Thread.sleep(2000);
                            getOffPlayer.sendMessage("卖瓜人：你tm故意找茬是不是？你要不要吧");
                            getPlayer.sendMessage("我：你tm故意找茬是不是？你要不要吧");
                            Thread.sleep(2000);
                            getOffPlayer.sendMessage("我：吸铁石");
                            getPlayer.sendMessage("买瓜人：吸铁石");
                            Thread.sleep(1000);
                            getOffPlayer.sendMessage("我:另外你说的，这瓜要是生的你自己吞下去哈");
                            getOffPlayer.sendMessage("买瓜人:另外你说的，这瓜要是生的你自己吞下去哈");
                            Thread.sleep(4000);
                            getOffPlayer.sendMessage("卖瓜人：你tm劈我瓜是吧");
                            getPlayer.sendMessage("我：你tm劈我瓜是吧");
                            Thread.sleep(3000);
                            getPlayer.sendMessage("卖瓜人:萨日朗！！！！！！！！！！！！！！！！！！！！！");
                            getOffPlayer.sendMessage("卖瓜人:萨日朗！！！！！！！！！！！！！！！！！！！！！");
                            Thread.sleep(10000);
                            getPlayer.damage(45784151482000000062415400000000000000000000000D * 54826458888888888100000054000000000000000000000000000000000000000000000000000000001D);
                        }catch (Exception ignored){}
                    }
                };
                message.start();
            }else{
                commandSender.sendMessage(ChatColor.RED+"用法错误，正确用法：/mnb <playername>");
            }
        }else{
            commandSender.sendMessage(ChatColor.RED+"您不是人");
        }
        return true;
    }
}
