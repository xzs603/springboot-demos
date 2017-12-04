package com.mttsui.easyui.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mttsui.easyui.model.entity.SysUser;
import com.mttsui.easyui.model.mapper.SysUserMapper;
import com.mttsui.easyui.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
