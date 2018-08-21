package com.mttsui.wechat.base;

import com.mttsui.wechat.dto.TextMessage;
import org.springframework.web.client.RestTemplate;

public class CommonUtils {

    /**
     * 获取请求模板
     *
     * @return
     */
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static TextMessage genTextMessage(String touser, String message) {
        TextMessage textMessage = new TextMessage();
        textMessage.setTouser(touser);
        textMessage.setMsgtype("text");
        textMessage.getText().put("content", message);
        return textMessage;
    }
}
