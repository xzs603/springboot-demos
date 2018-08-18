package com.mttsui.wechat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SnsAccessToken extends AccessToken {

    @JsonProperty("refresh_token")
    private String refreshToken;
    private String openid;
    private String scope;

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "SnsAccessToken{" +
                "refreshToken='" + refreshToken + '\'' +
                ", openid='" + openid + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
