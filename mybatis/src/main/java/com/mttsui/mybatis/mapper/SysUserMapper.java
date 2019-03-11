package com.mttsui.mybatis.mapper;

import com.mttsui.mybatis.entity.SysUser;
import java.util.List;
import java.util.Map;

public interface SysUserMapper {


    List<SysUser> query1();

    List<SysUser> query2();

    List<Map> query3();
}