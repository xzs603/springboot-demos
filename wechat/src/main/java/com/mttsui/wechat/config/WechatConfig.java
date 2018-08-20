package com.mttsui.wechat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("wechat")
public class WechatConfig {

    private String appid;

    private String appsecret;

    private String templateid;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getTemplateid() {
        return templateid;
    }

    public void setTemplateid(String templateid) {
        this.templateid = templateid;
    }
}
