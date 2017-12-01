package com.mttsui.security.controller;

import com.mttsui.security.model.entity.SysRole;
import com.mttsui.security.model.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @GetMapping("/list")
    public List<SysRole> list(){
        return sysRoleMapper.list();
    }
}
