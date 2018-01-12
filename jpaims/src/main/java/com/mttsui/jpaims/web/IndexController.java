package com.mttsui.jpaims.web;

import com.mttsui.jpaims.entity.SysMenu;
import com.mttsui.jpaims.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping("")
    public String index(Model model){
        SysMenu sysMenu = new SysMenu();
        sysMenu.setType((byte)0);
        List<SysMenu> list = sysMenuService.findByType(sysMenu);
        for(SysMenu each : list){
            each.setChildren(sysMenuService.findByPid(each));
        }
        model.addAttribute("menus", list);
        return "index";
    }
}
