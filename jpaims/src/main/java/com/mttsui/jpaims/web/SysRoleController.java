package com.mttsui.jpaims.web;

import com.mttsui.jpaims.entity.SysRole;
import com.mttsui.jpaims.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("/list")
    public List<SysRole> list() {
        return sysRoleService.list();
    }
}
