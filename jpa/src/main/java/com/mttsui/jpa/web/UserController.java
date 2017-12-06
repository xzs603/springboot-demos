package com.mttsui.jpa.web;

import com.mttsui.jpa.repository.SysUserRepository;
import com.mttsui.jpa.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysUserRepository sysUserRepository;

    @RequestMapping("/list")
    public List<SysUser> list(){
        return sysUserRepository.findAll();
    }

    @RequestMapping("/findByName")
    public SysUser findByName(SysUser sysUser){
        return sysUserRepository.findByName(sysUser.getName());
    }

    @RequestMapping("/create")
    public SysUser create(SysUser sysUser){
        return sysUserRepository.save(sysUser);
    }
}
