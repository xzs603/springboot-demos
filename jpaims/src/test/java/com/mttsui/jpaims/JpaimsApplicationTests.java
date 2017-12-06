package com.mttsui.jpaims;

import com.mttsui.jpaims.entity.SysUser;
import com.mttsui.jpaims.repository.SysUserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaimsApplication.class)
public class JpaimsApplicationTests {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Before
    public void setup(){
        System.out.println("start...");
        sysUserRepository.save(new SysUser("sfzhang","张三丰",'1'));
        sysUserRepository.save(new SysUser("mcli","李莫愁",'1'));
        sysUserRepository.save(new SysUser("hltang","唐福禄",'1'));
    }

    @Test
    public void numTest(){
        Assert.assertEquals(sysUserRepository.count(),3);
    }
}
