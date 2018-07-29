package com.mttsui.mybatis.controller;

import com.mttsui.mybatis.base.GridView;
import com.mttsui.mybatis.base.Response;
import com.mttsui.mybatis.entity.SysUser;
import com.mttsui.mybatis.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/sysusers")
@RestController
public class SysUserController {

    @Autowired
    private SysUserMapper sysUserMapper;

    @GetMapping
    public GridView<SysUser> list() {
        List<SysUser> rows = sysUserMapper.selectAll();
        GridView<SysUser> gridView = new GridView(rows, rows.size());
        return gridView;
    }

    @PostMapping
    public Response add(@RequestBody SysUser sysUser) {
        System.out.println(sysUser);
        return Response.OK();
    }
}
