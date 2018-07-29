package com.mttsui.baseapi.service;

import com.mttsui.baseapi.entity.SysUser;
import com.mttsui.baseapi.repository.SysUserRepository;
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
