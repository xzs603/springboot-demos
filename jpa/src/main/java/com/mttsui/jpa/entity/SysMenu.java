package com.mttsui.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SysMenu {

    @Id
    @GeneratedValue
    private Long id;

    private Long pid;

    private String title;

    private String url;

    private String icon;

    public SysMenu() {
    }

    public SysMenu(Long pid, String title, String url, String icon) {
        this.pid = pid;
        this.title = title;
        this.url = url;
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "id=" + id +
                ", pid=" + pid +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
