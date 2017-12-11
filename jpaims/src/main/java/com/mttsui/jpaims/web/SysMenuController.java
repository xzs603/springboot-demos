package com.mttsui.jpaims.web;

import com.mttsui.jpaims.entity.SysMenu;
import com.mttsui.jpaims.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping("")
    public String index(){
        return "menu/index";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<SysMenu> list(){
        return sysMenuService.list();
    }

    @RequestMapping("/create")
    @ResponseBody
    public SysMenu create(SysMenu sysMenu) {
        return sysMenuService.save(sysMenu);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(SysMenu sysMenu) {
        sysMenuService.delete(sysMenu);
        return true;
    }

    @RequestMapping("/update")
    @ResponseBody
    public SysMenu update(SysMenu sysMenu) {
        return sysMenuService.update(sysMenu);
    }

    @RequestMapping("/getById")
    @ResponseBody
    public SysMenu getById(SysMenu sysMenu) {
        return sysMenuService.findById(sysMenu);
    }
}
