package com.mttsui.jpa;

import com.mttsui.jpa.entity.SysMenu;
import com.mttsui.jpa.repository.SysMenuRepository;
import com.mttsui.jpa.repository.SysUserRepository;
import com.mttsui.jpa.entity.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class JpaApplicationTests {

    @Autowired
    private SysUserRepository sysUserRepository;
    @Autowired
    private SysMenuRepository sysMenuRepository;

    @Test
    public void Test(){
//        sysUserRepository.save(new SysUser("AAA", 10));
//        sysUserRepository.save(new SysUser("BBB", 20));
//        sysUserRepository.save(new SysUser("CCC", 30));
        sysMenuRepository.save(new SysMenu(-1L, "系统管理", "/sys/manage", ""));
        sysMenuRepository.save(new SysMenu(1L, "菜单管理", "/sys/manage", ""));
        sysMenuRepository.save(new SysMenu(1L, "用户管理", "/sys/manage", ""));

        Assert.assertEquals(3, sysMenuRepository.findAll().size());

    }
}
