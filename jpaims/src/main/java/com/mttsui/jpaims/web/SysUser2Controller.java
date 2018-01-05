package com.mttsui.jpaims.web;

import com.mttsui.jpaims.entity.SysUser;
import com.mttsui.jpaims.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user2")
public class SysUser2Controller {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("")
    public String index(){
        return "user2/index";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<SysUser> list() {
        return sysUserService.list();
    }

    @RequestMapping("/create")
    @ResponseBody
    public SysUser create(SysUser sysUser) {
        return sysUserService.save(sysUser);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(SysUser sysUser) {
        sysUserService.delete(sysUser);
        return true;
    }

    @RequestMapping("/update")
    @ResponseBody
    public SysUser update(SysUser sysUser) {
        return sysUserService.update(sysUser);
    }

    @RequestMapping("/getById")
    @ResponseBody
    public SysUser getById(SysUser sysUser) {
        return sysUserService.findById(sysUser);
    }

    @GetMapping("getByUsername")
    @ResponseBody
    public SysUser getByUsername(String username) {
        return sysUserService.getByUsername(username);
    }
}
