package com.mttsui.mybatisplus.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mttsui.mybatisplus.entity.User;
import com.mttsui.mybatisplus.entity.XmlUser;
import com.mttsui.mybatisplus.service.UserService;
import com.thoughtworks.xstream.XStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author admin
 * @since 2018-08-01
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("save")
    public User save(@RequestParam String name,@RequestParam int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        userService.insert(user);
        return user;
    }

    @GetMapping("get")
    public User get(@RequestParam String name) {
        // sql 条件构造器
        EntityWrapper<User> ew = new EntityWrapper<>();
        ew.eq("name", name);
        User user = userService.selectOne(ew);
        return user;
    }

    @PostMapping
    public Object parseXml(@RequestBody String xml){
        XStream xStream = new XStream();
        xStream.alias("user", User.class);
        Object s = xStream.fromXML(xml);
        return s;
    }

    @PostMapping(value="xml", produces = MediaType.APPLICATION_XML_VALUE)
    public Object parseXml(@RequestBody XmlUser xmlUser){
        System.out.println(xmlUser);
        return xmlUser;
    }
}

