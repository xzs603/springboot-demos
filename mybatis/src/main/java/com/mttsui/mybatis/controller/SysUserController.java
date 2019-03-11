package com.mttsui.mybatis.controller;

import com.mttsui.mybatis.base.GridView;
import com.mttsui.mybatis.base.Response;
import com.mttsui.mybatis.entity.SysUser;
import com.mttsui.mybatis.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/sysusers")
@RestController
public class SysUserController {

    @Autowired
    private SysUserMapper sysUserMapper;

    @GetMapping("list1")
    public List<SysUser> list1() {
        List<SysUser> rows = sysUserMapper.query1();
        return rows;
    }

    @GetMapping("list2")
    public List<SysUser> list2() {
        List<SysUser> rows = sysUserMapper.query2();
        return rows;
    }

    @GetMapping("list3")
    public List<Map> list3() {
        List<Map> rows = sysUserMapper.query3();
        return rows;
    }
}
