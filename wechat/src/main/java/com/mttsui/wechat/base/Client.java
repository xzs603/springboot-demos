package com.mttsui.wechat.base;

import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zsxu2
 * @Date 2018/8/15 8:45
 */
public class Client {

    public static final String BASE_URL = "https://api.weixin.qq.com/cgi-bin";

    /**
     * 获取访问TOKEN
     */
    public static final String GET_TOKEN = "/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**
     * 发送消息
     */
    public static final String SEND_MASSGE = "/message/custom/send?access_token=ACCESS_TOKEN";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String appid = "wx6bcb623f00a99848";
        String appsecret = "9b5fdaeb668a50664049200b75b67dbe";
        String touser = "oRJ9p1P_Migfr0sWuN-_GorVALXc";
        String message = "你好吗？<a href=\"http://m.cnblogs.com\">测试链接</a> " + new Date();
        String url1 = BASE_URL + GET_TOKEN.replace("APPID", appid).replace("APPSECRET", appsecret);
        System.out.println(url1);
        AccessToken token = restTemplate.getForObject(url1, AccessToken.class);
        String tk = token.getAccess_token();
        System.out.println("TOKEN is " + token);
        String url2 = BASE_URL + SEND_MASSGE.replace("ACCESS_TOKEN", tk);
        SendMessage msg = genTextMessage(touser, message);
        String result = restTemplate.postForObject(url2, msg, String.class);
        System.out.println(result);
    }

    public static SendMessage genTextMessage(String touser, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setTouser(touser);
        sendMessage.setMsgtype("text");
        sendMessage.getText().put("content", message);
        return sendMessage;
    }
}

class AccessToken {
    private String access_token;

    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}

class ErrorDto {
    private int errcode;

    private String errmsg;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}

class SendMessage extends ErrorDto {
    private String touser;
    private String msgtype;
    private Map<String, Object> text = new HashMap<>();

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

    public void setText(Map<String, Object> text) {
        this.text = text;
    }
}

