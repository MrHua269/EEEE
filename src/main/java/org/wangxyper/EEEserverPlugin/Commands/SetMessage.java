package org.wangxyper.EEEserverPlugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.wangxyper.EEEserverPlugin.Funcitons.MessageSelector;

public class SetMessage implements CommandExecutor {
    private MessageSelector get =new MessageSelector();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp() == true) {
            if (args[1]!=null && args[2]!=null){
                if(args[1] =="1"){
                    get.setMessage(args[2],false,false);
                }else{
                    get.setMessage(args[2],false,true);
                }

            }
            return true;
        } else {
            return false;
        }
    }
}
