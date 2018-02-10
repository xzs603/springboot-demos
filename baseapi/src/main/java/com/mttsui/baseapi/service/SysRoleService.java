package com.mttsui.baseapi.service;

import com.mttsui.baseapi.entity.SysRole;
import com.mttsui.baseapi.repository.SysRoleRepository;
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
