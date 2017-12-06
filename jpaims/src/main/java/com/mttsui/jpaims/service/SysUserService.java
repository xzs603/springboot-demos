package com.mttsui.jpaims.service;

import com.mttsui.jpaims.entity.SysUser;
import com.mttsui.jpaims.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    public List<SysUser> list(){
        return sysUserRepository.findAll();
    }

    public SysUser save(SysUser sysUser){
        return sysUserRepository.save(sysUser);
    }

    public void delete(SysUser sysUser){
        sysUserRepository.delete(sysUser.getId());
    }

    public SysUser update(SysUser sysUser){
        return sysUserRepository.save(sysUser);
    }

    public SysUser findById(SysUser sysUser){
        return sysUserRepository.findOne(sysUser.getId());
    }

    public SysUser getByUsername(String username){
        return sysUserRepository.findByUsername(username);
    }
}
