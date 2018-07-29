package com.mttsui.baseapi.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zsxu2
 * @Date 2018/2/10 18:51
 */
@RestController
@RequestMapping("/index")
public class HelloController {

    @GetMapping("")
    public String index(){
        return "index page";
    }
}
