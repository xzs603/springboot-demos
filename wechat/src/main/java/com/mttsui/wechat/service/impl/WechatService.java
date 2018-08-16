package com.mttsui.wechat.service.impl;

import com.mttsui.wechat.base.Constant;
import com.mttsui.wechat.config.TokenService;
import com.mttsui.wechat.dto.ErrorDto;
import com.mttsui.wechat.dto.TemplateMessage;
import com.mttsui.wechat.dto.TextMessage;
import com.mttsui.wechat.service.IWechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WechatService implements IWechatService {

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean sendTextMessageToUser(String openId, TextMessage textMessage) {
        RestTemplate restTemplate = new RestTemplate();
        String token = tokenService.getAccessToken();
        String sendMsgUrl = Constant.BASE_URL + Constant.SEND_TEXT_MASSGE.replace("ACCESS_TOKEN", token);
        ErrorDto result = restTemplate.postForObject(sendMsgUrl, textMessage, ErrorDto.class);
        System.out.println(result);
        return result.getErrcode() == 0;
    }

    @Override
    public boolean sendTemplateMessageToUser(String openId, TemplateMessage templateMessage) {
        RestTemplate restTemplate = new RestTemplate();
        String token = tokenService.getAccessToken();
        String sendMsgUrl = Constant.BASE_URL + Constant.SEND_TEMPLATE_MASSGE.replace("ACCESS_TOKEN", token);
        ErrorDto result = restTemplate.postForObject(sendMsgUrl, templateMessage, ErrorDto.class);
        System.out.println(result);
        return result.getErrcode() == 0;
    }

}
