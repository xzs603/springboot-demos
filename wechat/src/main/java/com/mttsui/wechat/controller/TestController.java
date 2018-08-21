package com.mttsui.wechat.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zsxu2
 * @Date 2018/8/15 16:07
 */
@RequestMapping("test")
@RestController
public class TestController {

    @GetMapping("genmenu")
    public Map<String, Object> genMenu() {
        Map<String, Object> result = new HashMap<>();
        List buttons = new ArrayList();
        result.put("button", buttons);
        genButtonList(buttons);
        return result;
    }

    @PostMapping("json")
    public Object jsonTest(@RequestBody Jsontest jsontest) {
        return jsontest;
    }

    private void genButtonList(List buttons) {
        String blankUrl = "http://jkllq.iflysec.com/chat/#/target-blank";
        List<String> list = new ArrayList<>();
        // 菜单
        list.add("关于医院");
        // 子菜单
        List<Menu> sublist1 = new ArrayList<>();
        sublist1.add(new Menu("医院介绍", "http://jkllq.iflysec.com/chat/#/hospital-introduction"));
        sublist1.add(new Menu("医生介绍", "http://jkllq.iflysec.com/chat/#/department-introduction"));
        sublist1.add(new Menu("科室分布", blankUrl));
        sublist1.add(new Menu("预约挂号", blankUrl));
        list.add("健康服务");
        List<Menu> sublist2 = new ArrayList<>();
        sublist2.add(new Menu("账号绑定", "http://jkllq.iflysec.com/chat/#/login"));
        sublist2.add(new Menu("健康档案", "http://jkllq.iflysec.com/chat/#/person-detail"));
        sublist2.add(new Menu("健康画像", "http://jkllq.iflysec.com/chat/#/health-portrait"));
        sublist2.add(new Menu("生命之树", "http://jkllq.iflysec.com/chat/#/life-tree"));
        list.add("我的");
        List<Menu> sublist3 = new ArrayList<>();
        sublist3.add(new Menu("个人中心", "http://jkllq.iflysec.com/chat/#/person-center"));
        sublist3.add(new Menu("家医签约", blankUrl));
        sublist3.add(new Menu("在线评估", blankUrl));
        sublist3.add(new Menu("健康大课堂", "http://jkllq.iflysec.com/chat/#/health-classroom"));

        Map button = genButton(list.get(0));
        button.put("sub_button", getSubButtonList(sublist1));
        buttons.add(button);
        button = genButton(list.get(1));
        button.put("sub_button", getSubButtonList(sublist2));
        buttons.add(button);
        button = genButton(list.get(2));
        button.put("sub_button", getSubButtonList(sublist3));
        buttons.add(button);
    }

    private List getSubButtonList(List<Menu> list) {
        List subbuttons = new ArrayList();
        for (Menu menu : list) {
            subbuttons.add(genSubButton(menu.getName(), menu.getUrl()));
        }
        return subbuttons;
    }

    private Map<String, String> genButton(String name) {
        Map<String, String> subbtn = new HashMap<>();
        subbtn.put("name", name);
        return subbtn;
    }

    private Map<String, String> genSubButton(String name, String url) {
        Map<String, String> subbtn = new HashMap<>();
        subbtn.put("type", "view");
        subbtn.put("name", name);
        subbtn.put("url", url);
        return subbtn;
    }

}

class Menu {

    private String name;
    private String url;

    public Menu() {
    }

    public Menu(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

class Jsontest {

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("nick_name")
    private String nickName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}