package com.mttsui.wechat.service;

import com.mttsui.wechat.dto.SendMessage;

public interface IWechatService {

    /**
     * 发送消息到指定用户
     * @param openId
     * @param sendMessage
     * @return
     */
    boolean sendMessageToUser(String openId, SendMessage sendMessage);
}
