package com.mttsui.wechat.config;

import com.mttsui.wechat.base.Constant;
import com.mttsui.wechat.dto.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@Service
public class TokenService {

    @Autowired
    private WechatConfig wechatConfig;

    private static String accessToken = null;

    public String getAccessToken() {
        if (accessToken == null) {
            refreshAccessToken();
        }
        return accessToken;
    }

    @Scheduled(fixedRate = 3600 * 1000)
    private void refreshAccessToken() {
        System.out.println("开始刷新token");
        RestTemplate restTemplate = new RestTemplate();
        String tokenUrl = Constant.BASE_URL + Constant.GET_TOKEN.replace("APPID", wechatConfig.getAppid())
                .replace("APPSECRET", wechatConfig.getAppsecret());
        System.out.println(tokenUrl);
        AccessToken token = restTemplate.getForObject(tokenUrl, AccessToken.class);
        accessToken = token.getAccess_token();
        System.out.println("刷新成功" + accessToken);
    }
}
