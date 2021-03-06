package com.mttsui.wechat.base;

import com.mttsui.wechat.dto.AccessToken;
import com.mttsui.wechat.dto.TextMessage;
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
    public static final String SEND_TEXT_MASSGE = "/message/custom/send?access_token=ACCESS_TOKEN";

    /**
     * 发送模板消息
     */
    public static final String SEND_TEMPLATE_MASSGE = "/message/template/send?access_token=ACCESS_TOKEN";

    /**
     * 获取访问code
     */
    public static final String REQ_CODE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
            "appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";

    /**
     * 获取Openid
     */
    public static final String REQ_OPENID_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
            "appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code";

    /**
     * 获取用户信息
     */
    public static final String REQ_USERINFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?" +
            "access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";


    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String appid = "wx6bcb623f00a99848";
        String appsecret = "9b5fdaeb668a50664049200b75b67dbe";
        String touser = "oRJ9p1MXZQKJOnnRbENL1L8u4c4U";
        String message = "你好吗？http://m.cnblogs.com " + new Date();
        String url1 = BASE_URL + GET_TOKEN.replace("APPID", appid).replace("APPSECRET", appsecret);
        System.out.println(url1);
        AccessToken token = restTemplate.getForObject(url1, AccessToken.class);
        String tk = token.getAccessToken();
        System.out.println("TOKEN is " + token);
        String url2 = BASE_URL + SEND_TEXT_MASSGE.replace("ACCESS_TOKEN", tk);
        TextMessage msg = CommonUtils.genTextMessage(touser, message);
        String result = restTemplate.postForObject(url2, msg, String.class);
        System.out.println(result);
    }
}
