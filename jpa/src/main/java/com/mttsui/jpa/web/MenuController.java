package com.mttsui.jpa.web;

import com.mttsui.jpa.entity.SysMenu;
import com.mttsui.jpa.repository.SysMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private SysMenuRepository sysMenuRepository;

    @GetMapping("/list")
    public List<SysMenu> list(){
        return sysMenuRepository.findAll();
    }

    @GetMapping("/findById")
    public SysMenu findById(Long id){
        return sysMenuRepository.findOne(id);
    }
}
