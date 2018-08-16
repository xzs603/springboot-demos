package com.mttsui.wechat.dto;

/**
 *
 健康档案查看授权提醒

 医院：{{hospitalName.DATA}}
 医生：{{doctorName.DATA}}
 申请内容：{{patientName.DATA}}，您好！为了向您提供更好的健康管理服务，{{doctorName.DATA}}医生需要查看您的健康档案，点击本条消息完成授权，谢谢！
 以上由【讯飞AI健康管理】为您提供
 */
public class WcTemplateItem {

    private String value;

    public WcTemplateItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
