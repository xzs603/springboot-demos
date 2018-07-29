package com.mttsui.baseapi.service;

import com.mttsui.baseapi.entity.SysMenu;
import com.mttsui.baseapi.repository.SysMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuService {

    @Autowired
    private SysMenuRepository sysMenuRepository;

    public List<SysMenu> list() {
        return sysMenuRepository.findAll();
    }

    public SysMenu save(SysMenu sysMenu) {
        return sysMenuRepository.save(sysMenu);
    }

    public void delete(SysMenu sysMenu) {
        sysMenuRepository.delete(sysMenu.getId());
    }

    public SysMenu update(SysMenu sysMenu) {
        return sysMenuRepository.save(sysMenu);
    }

    public SysMenu findById(SysMenu sysMenu) {
        return sysMenuRepository.findOne(sysMenu.getId());
    }

    public List<SysMenu> findByType(SysMenu sysMenu) {
        return sysMenuRepository.findByType(sysMenu.getType());
    }

    public List<SysMenu> findByPid(SysMenu sysMenu) {
        return sysMenuRepository.findByPid(sysMenu.getId());
    }
}
