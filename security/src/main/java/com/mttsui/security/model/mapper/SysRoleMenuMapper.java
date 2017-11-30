package com.mttsui.security.model.mapper;

import com.mttsui.security.model.entity.SysRoleMenu;

public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysRoleMenu record);

    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRoleMenu record);

    int updateByPrimaryKey(SysRoleMenu record);
}