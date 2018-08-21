package com.mttsui.wechat.service.impl;

import com.mttsui.wechat.base.CommonUtils;
import com.mttsui.wechat.base.Constant;
import com.mttsui.wechat.config.TokenService;
import com.mttsui.wechat.config.WechatConfig;
import com.mttsui.wechat.dto.*;
import com.mttsui.wechat.service.IWechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WechatService implements IWechatService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private WechatConfig wechatConfig;

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

    @Override
    public SnsAccessToken getSnsAccessToken(String code) {
        RestTemplate restTemplate = CommonUtils.getRestTemplate();
        String sendUrl = Constant.REQ_OPENID_URL.replace("APPID", wechatConfig.getAppid())
                .replace("APPSECRET", wechatConfig.getAppsecret()).replace("CODE", code);
        SnsAccessToken snsAccessToken = restTemplate.getForObject(sendUrl, SnsAccessToken.class);
        return snsAccessToken;
    }

    @Override
    public WechatUserInfo getWechatUserInfo(String openId) {
        RestTemplate restTemplate = CommonUtils.getRestTemplate();
        String wechatUserinfoUrl = Constant.REQ_USERINFO_URL.replace("ACCESS_TOKEN",
                tokenService.getAccessToken()).replaceAll("OPENID", openId);
        WechatUserInfo wechatUserInfo = restTemplate.getForObject(wechatUserinfoUrl, WechatUserInfo.class);
        return wechatUserInfo;
    }

}
