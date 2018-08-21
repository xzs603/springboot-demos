package com.mttsui.wechat.controller;

import com.mttsui.wechat.base.CommonUtils;
import com.mttsui.wechat.base.Constant;
import com.mttsui.wechat.config.TokenService;
import com.mttsui.wechat.config.WechatConfig;
import com.mttsui.wechat.config.WxMappingJackson2HttpMessageConverter;
import com.mttsui.wechat.dto.*;
import com.mttsui.wechat.service.IWechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@RequestMapping("wechat")
@RestController
public class WechatController {

    @Autowired
    private WechatConfig wechatConfig;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private IWechatService wechatService;

    private String touser = "o5B5m6MvBjGTNdkTHideVhondO7Y";

    @GetMapping
    public String index(String echostr) {
        return echostr;
    }

    @GetMapping("sendmsg")
    public boolean sendMessage() {
        String message = "你好吗？<a href=\"http://m.cnblogs.com\">测试链接</a>" + new Date();
        TextMessage msg = CommonUtils.genTextMessage(touser, message);
        return wechatService.sendTextMessageToUser(touser, msg);
    }

    @GetMapping("sendtemplatemsg")
    public boolean sendTemplateMsg() {
        TemplateMessage<WcTemplateItem> templateMessage = new TemplateMessage<>();
        templateMessage.setTouser(touser);
        templateMessage.setTemplateId(wechatConfig.getTemplateid());
        templateMessage.setUrl("https://m.cnblogs.com");
        Map<String, WcTemplateItem> words = new HashMap<>();
        words.put("hospitalName", new WcTemplateItem("第三人民医院"));
        words.put("doctorName", new WcTemplateItem("胡青牛"));
        words.put("patientName", new WcTemplateItem("张无忌"));
        //words.put("doctorName", new WcTemplateItem("胡青牛"));
        templateMessage.setData(words);
        return wechatService.sendTemplateMessageToUser(touser, templateMessage);
    }

    @GetMapping("templatemsg")
    public Object templateMsg() {
        TemplateMessage<WcTemplateItem> templateMessage = new TemplateMessage<>();
        templateMessage.setTouser(touser);
        templateMessage.setTemplateId(wechatConfig.getTemplateid());
        templateMessage.setUrl("https://m.cnblogs.com");
        Map<String, WcTemplateItem> words = new TreeMap<>();
        words.put("hospitalName", new WcTemplateItem("第三人民医院"));
        words.put("doctorName", new WcTemplateItem("胡青牛"));
        words.put("patientName", new WcTemplateItem("张无忌"));
        templateMessage.setData(words);
        return templateMessage;
    }

    @GetMapping("getcode")
    public void getCode(HttpServletResponse response) {
        RestTemplate restTemplate = new RestTemplate();
        String sendUrl = Constant.REQ_CODE_URL.replace("APPID", wechatConfig.getAppid()).
                replace("REDIRECT_URI", "http://samxu.free.idcfengye.com/wechat/openid");
        try {
            response.sendRedirect(sendUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("openid")
    public Object getOpenid(String code) {
        String sendUrl = Constant.REQ_OPENID_URL.replace("APPID", wechatConfig.getAppid())
                .replace("APPSECRET", wechatConfig.getAppsecret()).replace("CODE", code);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        SnsAccessToken snsAccessToken = restTemplate.getForObject(sendUrl, SnsAccessToken.class);
        System.out.println(snsAccessToken);
        String wechatUserinfoUrl = Constant.REQ_USERINFO_URL.replace("ACCESS_TOKEN",
                tokenService.getAccessToken()).replaceAll("OPENID", snsAccessToken.getOpenid());
        WechatUserInfo wechatUserInfo = restTemplate.getForObject(wechatUserinfoUrl, WechatUserInfo.class);
        return wechatUserInfo;
    }
}
