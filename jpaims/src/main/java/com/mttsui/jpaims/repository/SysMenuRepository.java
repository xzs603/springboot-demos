package com.mttsui.jpaims.repository;

import com.mttsui.jpaims.entity.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysMenuRepository extends JpaRepository<SysMenu, Long> {

    public List<SysMenu> findByType(byte type);

    public List<SysMenu> findByPid(Long pid);
}
