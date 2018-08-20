package com.mttsui.wechat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class TemplateMessage<T> {

    private String touser;
    @JsonProperty("template_id")
    private String templateId;
    private String url;
    private Map<String, T> data;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, T> getData() {
        return data;
    }

    public void setData(Map<String, T> data) {
        this.data = data;
    }
}
