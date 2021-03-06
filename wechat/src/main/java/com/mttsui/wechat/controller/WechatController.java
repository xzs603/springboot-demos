package com.mttsui.wechat.controller;

import com.mttsui.wechat.base.CommonUtils;
import com.mttsui.wechat.base.Constant;
import com.mttsui.wechat.config.TokenService;
import com.mttsui.wechat.config.WechatConfig;
import com.mttsui.wechat.dto.*;
import com.mttsui.wechat.service.IWechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@RequestMapping(WechatController.CUR_PATH)
@RestController
public class WechatController {

    public static final String CUR_PATH = "/wechat";

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
    public void getCode(String service, HttpServletResponse response) {
        if (StringUtils.isEmpty(service)) {
            service = "openid";
        }
        String sendUrl = Constant.REQ_CODE_URL.replace("APPID", wechatConfig.getAppid()).
                replace("REDIRECT_URI", wechatConfig.getRooturi() + CUR_PATH + "/" + service);
        try {
            response.sendRedirect(sendUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("openid")
    public Object getOpenid(String code) {
        if (StringUtils.isEmpty(code)) {
            return "code不能为空";
        }
        // 根据code获取snsAccessToken
        SnsAccessToken snsAccessToken = wechatService.getSnsAccessToken(code);
        // 根据snsAccessToken中的openid查询用户信息
        WechatUserInfo wechatUserInfo = wechatService.getWechatUserInfo(snsAccessToken.getOpenid());
        return wechatUserInfo;
    }
}
