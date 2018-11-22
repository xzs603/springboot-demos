package com.mttsui.jpa.web;

import com.mttsui.jpa.repository.SysUserRepository;
import com.mttsui.jpa.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/findByName")
    @Cacheable(value="user-key")
    public SysUser findByName(SysUser sysUser){
        SysUser user = sysUserRepository.findByName(sysUser.getName());
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping("/create")
    public SysUser create(SysUser sysUser){
        return sysUserRepository.save(sysUser);
    }
}
