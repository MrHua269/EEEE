package org.wangxyper.EEEserverPlugin.Commands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.wangxyper.EEEserverPlugin.Listeners.BossBarListener;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender.isOp()){
            try{
            BossBarListener.reload();
            commandSender.sendMessage(ChatColor.GREEN+"重载成功");
            }catch (Exception e){
                commandSender.sendMessage(ChatColor.RED+"一个内部错误导致该命令无法执行，请联系服务器管理员*/");
            }return true;
        }else{
            commandSender.sendMessage(ChatColor.RED+"您没有该权限执行此命令");
            return true;
        }
    }
}
