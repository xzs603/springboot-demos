package com.mttsui.baseapi.test;

import com.mttsui.baseapi.service.SysUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstTest {

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void hello() {
        System.out.println("hello world");
        Assert.assertEquals(2,sysUserService.list().size());
    }
}
