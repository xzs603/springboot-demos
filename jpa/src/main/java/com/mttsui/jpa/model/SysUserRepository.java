package com.mttsui.jpa.model;

import com.mttsui.jpa.model.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    SysUser findByName(String name);

    SysUser findByNameAndAge(String name, Integer age);
}
