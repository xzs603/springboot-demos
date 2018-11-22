package com.mttsui.baseapi.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zsxu2
 * @Date 2018/2/10 18:51
 */
@ConfigurationProperties(prefix = "foo.bar")
@RestController
@Component
@RequestMapping("/index")
public class HelloController {

    private String name;

    @GetMapping("")
    public String index(){
        return "index page " + name;
    }
}
