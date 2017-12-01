package com.mttsui.security.controller;

import com.mttsui.security.model.entity.SysUser;
import com.mttsui.security.model.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysUserMapper sysUserMapper;

    @RequestMapping("/list")
    @ResponseBody
    public List<SysUser> listUser() {
        return sysUserMapper.list();
    }

    @RequestMapping("/add")
    @ResponseBody
    public SysUser add(SysUser sysUser) {
        System.out.println(sysUser);
        return sysUser;
    }

    @RequestMapping("/{id}/update")
    @ResponseBody
    public SysUser update(SysUser sysUser) {
            System.out.println(sysUser);
        return sysUser;
    }

    @RequestMapping("/{id}/delete")
    @ResponseBody
    public SysUser delete(SysUser sysUser) {
        return sysUser;
    }

    @RequestMapping("/crud")
    public String crud(SysUser sysUser) {
        return "/user/crud";
    }
}
