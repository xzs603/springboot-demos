package com.mttsui.jpa;

import com.mttsui.jpa.model.SysUserRepository;
import com.mttsui.jpa.model.entity.SysUser;
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

    @Test
    public void Test(){
        sysUserRepository.save(new SysUser("AAA", 10));
        sysUserRepository.save(new SysUser("BBB", 20));
        sysUserRepository.save(new SysUser("CCC", 30));

        Assert.assertEquals(3, sysUserRepository.findAll().size());

    }
}
