package com.mttsui.security.controller;

import com.mttsui.security.model.entity.SysUser;
import com.mttsui.security.model.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class CrudController {

    @Autowired
    private SysUserMapper sysUserMapper;

    @GetMapping("/list")
    public SysUser listUser() {
        return sysUserMapper.selectByPrimaryKey(1L);
    }
}