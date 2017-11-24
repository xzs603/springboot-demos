package com.mttsui.security;

import com.mttsui.security.model.entity.SysUser;
import com.mttsui.security.model.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/11/21 0021.
 */
@Controller
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @Autowired
    private SysUserMapper sysUserMapper;

    @GetMapping("/list")
    public SysUser listUser() {
        return sysUserMapper.selectByPrimaryKey(1L);
    }
}