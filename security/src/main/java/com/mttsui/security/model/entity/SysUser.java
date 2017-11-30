package com.mttsui.security.model.entity;

import java.util.Date;

public class SysUser {
    private String id;

    private String name;

    private String password;

    private String nickname;

    private Date birthday;

    private String actInd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getActInd() {
        return actInd;
    }

    public void setActInd(String actInd) {
        this.actInd = actInd == null ? null : actInd.trim();
    }
}