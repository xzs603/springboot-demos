package com.mttsui.security.controller;

import com.mttsui.security.model.entity.SysUser;
import com.mttsui.security.model.mapper.SysUserMapper;
import com.mttsui.security.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysUserMapper sysUserMapper;

    @RequestMapping("/list")
    @ResponseBody
    public List<SysUser> listUser() {
        return sysUserMapper.list();
    }

    @RequestMapping("/create")
    @ResponseBody
    public SysUser create(SysUser sysUser) {
        sysUser.setId(CommonUtil.genUUID());
        sysUserMapper.insert(sysUser);
        return sysUser;
    }

    @RequestMapping("/{id}/update")
    @ResponseBody
    public SysUser update(SysUser sysUser) {
        sysUserMapper.updateByPrimaryKey(sysUser);
        return sysUser;
    }

    @RequestMapping("/{id}/delete")
    @ResponseBody
    public Map<String, Object> delete(String id) {
        Map<String, Object> map = new HashMap<>();
        sysUserMapper.deleteByPrimaryKey(id);
        map.put("success", true);
        return map;
    }

    @RequestMapping("/crud")
    public String crud(SysUser sysUser) {
        return "/user/crud";
    }

}
