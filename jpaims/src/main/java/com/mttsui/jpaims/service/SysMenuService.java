package com.mttsui.jpaims.service;

import com.mttsui.jpaims.entity.SysMenu;
import com.mttsui.jpaims.entity.SysUser;
import com.mttsui.jpaims.repository.SysMenuRepository;
import com.mttsui.jpaims.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuService {

    @Autowired
    private SysMenuRepository sysMenuRepository;

    public List<SysMenu> list(){
        return sysMenuRepository.findAll();
    }
}
