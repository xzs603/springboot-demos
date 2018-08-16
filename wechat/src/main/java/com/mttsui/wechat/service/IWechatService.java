package com.mttsui.wechat.service;

import com.mttsui.wechat.dto.TemplateMessage;
import com.mttsui.wechat.dto.TextMessage;

public interface IWechatService {

    /**
     * 发送消息到指定用户
     * @param openId
     * @param textMessage
     * @return
     */
    boolean sendTextMessageToUser(String openId, TextMessage textMessage);

    /**
     * 发送消息到指定用户
     * @param openId
     * @param textMessage
     * @return
     */
    boolean sendTemplateMessageToUser(String openId, TemplateMessage textMessage);
}
