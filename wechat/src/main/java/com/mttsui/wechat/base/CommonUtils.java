package com.mttsui.wechat.base;

import com.mttsui.wechat.config.WxMappingJackson2HttpMessageConverter;
import com.mttsui.wechat.dto.TextMessage;
import org.springframework.web.client.RestTemplate;

public class CommonUtils {

    /**
     * 获取请求模板
     *
     * @return
     */
    public static RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        return restTemplate;
    }

    public static TextMessage genTextMessage(String touser, String message) {
        TextMessage textMessage = new TextMessage();
        textMessage.setTouser(touser);
        textMessage.setMsgtype("text");
        textMessage.getText().put("content", message);
        return textMessage;
    }
}
