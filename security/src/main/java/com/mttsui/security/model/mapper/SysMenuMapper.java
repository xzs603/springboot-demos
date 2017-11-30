package com.mttsui.security.model.mapper;

import com.mttsui.security.model.entity.SysMenu;

public interface SysMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}