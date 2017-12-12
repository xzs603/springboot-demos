package com.mttsui.jpaims.service;

import com.mttsui.jpaims.entity.SysRole;
import com.mttsui.jpaims.repository.SysRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleService {

    @Autowired
    private SysRoleRepository sysRoleRepository;

    public List<SysRole> list(){
        return sysRoleRepository.findAll();
    }
}
