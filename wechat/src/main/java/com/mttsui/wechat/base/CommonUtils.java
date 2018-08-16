package com.mttsui.wechat.base;

import com.mttsui.wechat.dto.TextMessage;

public class CommonUtils {

    public static TextMessage genTextMessage(String touser, String message){
        TextMessage textMessage = new TextMessage();
        textMessage.setTouser(touser);
        textMessage.setMsgtype("text");
        textMessage.getText().put("content", message);
        return textMessage;
    }
}
