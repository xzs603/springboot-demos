package com.mttsui.jpa.web;

import com.mttsui.jpa.entity.SysRole;
import com.mttsui.jpa.entity.SysUser;
import com.mttsui.jpa.repository.SysRoleRepository;
import com.mttsui.jpa.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @RequestMapping("/list")
    public List<SysRole> list(){
        return sysRoleRepository.findAll();
    }

    @RequestMapping("/findById")
    public SysRole findByName(SysUser sysRole){
        return sysRoleRepository.findOne(sysRole.getId());
    }

}
