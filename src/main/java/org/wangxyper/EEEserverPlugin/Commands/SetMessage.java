package org.wangxyper.EEEserverPlugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.wangxyper.EEEserverPlugin.Funcitons.MessageSelector;

public class SetMessage implements CommandExecutor {
    private MessageSelector get =new MessageSelector();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp()) {
            if (args[0]!=null && args[1]!=null){
                if(args[0] =="join"){
                    get.setMessage(args[1],false,false);
                }else{
                    get.setMessage(args[1],false,true);
                }

            }else if(args[0] = !null){
               if(args[0]=="reset"){
              get.setMessage("awa",true，false)

              }
           }
       else{return false;}
            
            return true;
        } else {
            return false;
        }
    }
}
