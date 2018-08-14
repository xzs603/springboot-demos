package com.mttsui.wechat.base;

import com.mttsui.wechat.dto.SendMessage;

public class CommonUtils {

    public static SendMessage genTextMessage(String touser, String message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setTouser(touser);
        sendMessage.setMsgtype("text");
        sendMessage.getText().put("content", message);
        return sendMessage;
    }
}
