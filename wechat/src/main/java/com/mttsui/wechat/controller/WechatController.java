package com.mttsui.wechat.controller;

import com.mttsui.wechat.base.CommonUtils;
import com.mttsui.wechat.config.WechatConfig;
import com.mttsui.wechat.dto.SendMessage;
import com.mttsui.wechat.service.IWechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RequestMapping("wechat")
@RestController
public class WechatController {

    @Autowired
    private WechatConfig wechatConfig;

    @Autowired
    private IWechatService wechatService;

    @GetMapping
    public String index() {
        return wechatConfig.getAppsecret();
    }

    @GetMapping("sendmsg")
    public boolean sendMessage() {
        String message = "你好吗？http://m.cnblogs.com " + new Date();
        String touser = "oRJ9p1MXZQKJOnnRbENL1L8u4c4U";
        SendMessage msg = CommonUtils.genTextMessage(touser, message);
        return wechatService.sendMessageToUser(touser, msg);
    }
}
