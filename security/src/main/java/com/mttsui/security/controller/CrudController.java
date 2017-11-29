package com.mttsui.security.controller;

import com.mttsui.security.model.entity.SysUser;
import com.mttsui.security.model.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CrudController {

    @Autowired
    private SysUserMapper sysUserMapper;

    @GetMapping("/list")
    public List<SysUser> listUser() {
        return sysUserMapper.list();
    }

    @RequestMapping("/add")
    public SysUser add(SysUser sysUser){
        System.out.println(sysUser);
        return sysUser;
    }

    @RequestMapping("/{id}/update")
    public SysUser update(SysUser sysUser){
        System.out.println(sysUser);
        return sysUser;
    }

    @RequestMapping("/{id}/delete")
    public SysUser delete(SysUser sysUser){
        System.out.println(sysUser);
        return sysUser;
    }
}