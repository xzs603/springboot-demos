package com.mttsui.wechat.service.impl;

import com.mttsui.wechat.base.CommonUtils;
import com.mttsui.wechat.base.Constant;
import com.mttsui.wechat.config.TokenService;
import com.mttsui.wechat.dto.ErrorDto;
import com.mttsui.wechat.dto.SendMessage;
import com.mttsui.wechat.service.IWechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class WechatService implements IWechatService {

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean sendMessageToUser(String openId, SendMessage sendMessage) {
        RestTemplate restTemplate = new RestTemplate();
        String message = "你好吗？http://m.cnblogs.com " + new Date();
        String token = tokenService.getAccessToken();
        System.out.println("TOKEN is " + token);
        String sendMsgUrl = Constant.BASE_URL + Constant.SEND_TEXT_MASSGE.replace("ACCESS_TOKEN", token);
        SendMessage msg = CommonUtils.genTextMessage(openId, message);
        ErrorDto result = restTemplate.postForObject(sendMsgUrl, msg, ErrorDto.class);
        System.out.println(result);
        return result.getErrcode() == 0;
    }
}
