package com.mttsui.baseapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class SysUser {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String nickname;

    private Date birthday;

    private char actInd;

    public SysUser() {
    }

    public SysUser(String username, String password, char actInd) {
        this.username = username;
        this.password = password;
        this.actInd = actInd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getActInd() {
        return actInd;
    }

    public void setActInd(char actInd) {
        this.actInd = actInd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", birthday=" + birthday +
                ", actInd=" + actInd +
                '}';
    }
}
