package com.mttsui.jpaims.web;

import com.mttsui.jpaims.entity.SysMenu;
import com.mttsui.jpaims.entity.SysUser;
import com.mttsui.jpaims.service.SysMenuService;
import com.mttsui.jpaims.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping("/list")
    public List<SysMenu> list(){
        return sysMenuService.list();
    }
}
