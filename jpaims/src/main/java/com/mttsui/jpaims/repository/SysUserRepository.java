package com.mttsui.jpaims.repository;

import com.mttsui.jpaims.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    SysUser findByUsername(String username);
}
