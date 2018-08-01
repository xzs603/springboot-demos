package com.mttsui.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: zsxu2
 * @Date 2018/8/1 18:56
 */
@EnableSwagger2
@MapperScan("com.mttsui.mybatisplus.**.mapper")
@SpringBootApplication
public class MybatisplusApp {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusApp.class, args);
    }
}
