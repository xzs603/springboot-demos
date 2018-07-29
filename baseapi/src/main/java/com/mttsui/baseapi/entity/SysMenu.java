package com.mttsui.baseapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class SysMenu {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String url;

    private Long pid;

    private byte type;

    private String iconCls;

    @Transient
    private List<SysMenu> children;

    public SysMenu() {
    }

    public SysMenu(String title, String url, Long pid) {
        this.title = title;
        this.url = url;
        this.pid = pid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public List<SysMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                ", type=" + type +
                ", iconCls='" + iconCls + '\'' +
                '}';
    }
}
