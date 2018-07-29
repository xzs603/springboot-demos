package com.mttsui.baseapi.repository;

import com.mttsui.baseapi.entity.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysMenuRepository extends JpaRepository<SysMenu, Long> {

    public List<SysMenu> findByType(byte type);

    public List<SysMenu> findByPid(Long pid);
}
