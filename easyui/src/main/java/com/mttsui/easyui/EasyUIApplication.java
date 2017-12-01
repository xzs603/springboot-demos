package com.mttsui.easyui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2017/11/21 0021.
 */
@SpringBootApplication
@MapperScan("mybatis.mapper.*")
public class EasyUIApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyUIApplication.class, args);
    }
}
