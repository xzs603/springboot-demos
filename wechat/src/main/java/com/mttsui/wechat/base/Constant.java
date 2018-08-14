package com.mttsui.wechat.base;

import com.mttsui.wechat.dto.AccessToken;
import com.mttsui.wechat.dto.SendMessage;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

public class Constant {

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
        String touser = "oRJ9p1MXZQKJOnnRbENL1L8u4c4U";
        String message = "你好吗？http://m.cnblogs.com " + new Date();
        String url1 = BASE_URL + GET_TOKEN.replace("APPID", appid).replace("APPSECRET", appsecret);
        System.out.println(url1);
        AccessToken token = restTemplate.getForObject(url1, AccessToken.class);
        String tk = token.getAccess_token();
        System.out.println("TOKEN is " + token);
        String url2 = BASE_URL + SEND_MASSGE.replace("ACCESS_TOKEN", tk);
        SendMessage msg = CommonUtils.genTextMessage(touser, message);
        String result = restTemplate.postForObject(url2, msg, String.class);
        System.out.println(result);
    }
}
