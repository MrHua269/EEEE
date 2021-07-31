package org.wangxyper.EEEserverPlugin.Funcitons;

import java.awt.*;

public class MessageSelector {
    private String LeftMessage = "喝茶去了";
    private String JoinMessage = "加入了服务器";
    public String MessageSelector(String username,int JoinorLeft,boolean reset,boolean isop){
        //判断要获取的信息
        if(JoinorLeft == 1){
            //判断是否为op
            if(isop == false){
            return "[玩家]" + username + this.JoinMessage;
            }else{
                return "\r[管理员]" + username + this.JoinMessage;
            }
        }else{
            if(isop == false){
                return "[玩家]" + username + this.LeftMessage;
            }else{
                return "[管理员]" + username + this.LeftMessage;
            }
        }

    }
    //用于设置自定义消息
    public void setMessage(String message,boolean reset,boolean leftorjoin){
        //判断是否重置消息
        if(reset!=true) {
            //判断设置的类型
            if(leftorjoin!=false){
                this.LeftMessage = message;
            }else{
                this.JoinMessage = message;
            }
        }else{
           this.LeftMessage = "喝茶去了";
           this.JoinMessage = "加入了服务器";
        }

    }
}
