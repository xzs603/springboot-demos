package com.mttsui.baseapi.web;

import com.mttsui.baseapi.entity.SysMenu;
import com.mttsui.baseapi.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zsxu2
 * @Date 2018/2/10 18:59
 */
@RestController
@RequestMapping("/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("")
    public List<SysMenu> list(){
        return sysMenuService.list();
    }
}
