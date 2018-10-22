package com.mttsui.redis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zsxu2
 * @Date 2018/10/22 18:55
 */
@RequestMapping("redis")
@RestController
public class RedisController {

    @GetMapping
    public String getVal() {
        return "getVal";
    }
}
