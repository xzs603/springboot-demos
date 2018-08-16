package com.mttsui.wechat.dto;

import java.util.HashMap;
import java.util.Map;

public class TextMessage extends ErrorDto {

    private String touser;
    private String msgtype;
    private Map<String, Object> text = new HashMap<>();

    public TextMessage() {
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public Map<String, Object> getText() {
        return text;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "touser='" + touser + '\'' +
                ", msgtype='" + msgtype + '\'' +
                ", text=" + text +
                '}';
    }
}
