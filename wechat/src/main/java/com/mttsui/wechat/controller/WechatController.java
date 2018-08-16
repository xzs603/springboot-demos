package com.mttsui.wechat.controller;

import com.mttsui.wechat.base.CommonUtils;
import com.mttsui.wechat.config.WechatConfig;
import com.mttsui.wechat.dto.TemplateMessage;
import com.mttsui.wechat.dto.TextMessage;
import com.mttsui.wechat.dto.WcTemplateItem;
import com.mttsui.wechat.service.IWechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private IWechatService wechatService;

    private String template_id = "3nGijr6SxA-7H5IsxaqtblDpx4iQohrgsulO4jNE7vk";

    private String touser = "oRJ9p1MXZQKJOnnRbENL1L8u4c4U";

    @GetMapping
    public String index() {
        return wechatConfig.getAppsecret();
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
        templateMessage.setTouser("oRJ9p1ELA8NWS6I6KEVKSJcIKSs8");
        templateMessage.setTemplate_id(template_id);
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
        templateMessage.setTemplate_id(template_id);
        templateMessage.setUrl("https://m.cnblogs.com");
        Map<String, WcTemplateItem> words = new TreeMap<>();
        words.put("hospitalName", new WcTemplateItem("第三人民医院"));
        words.put("doctorName", new WcTemplateItem("胡青牛"));
        words.put("patientName", new WcTemplateItem("张无忌"));
        //words.put("doctorName", new WcTemplateItem("胡青牛"));
        templateMessage.setData(words);
        return templateMessage;
    }
}
