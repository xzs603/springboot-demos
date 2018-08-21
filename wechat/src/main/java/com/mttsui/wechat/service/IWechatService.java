package com.mttsui.wechat.service;

import com.mttsui.wechat.dto.SnsAccessToken;
import com.mttsui.wechat.dto.TemplateMessage;
import com.mttsui.wechat.dto.TextMessage;
import com.mttsui.wechat.dto.WechatUserInfo;

public interface IWechatService {

    /**
     * 发送消息到指定用户
     *
     * @param openId
     * @param textMessage
     * @return
     */
    boolean sendTextMessageToUser(String openId, TextMessage textMessage);

    /**
     * 发送消息到指定用户
     *
     * @param openId
     * @param textMessage
     * @return
     */
    boolean sendTemplateMessageToUser(String openId, TemplateMessage textMessage);

    /**
     * 获取当前用户的SnsAccessToken
     * @return
     */
    SnsAccessToken getSnsAccessToken(String code);

    /**
     * 根据openid获取用户信息
     * @param openId
     * @return
     */
    WechatUserInfo getWechatUserInfo(String openId);
}
