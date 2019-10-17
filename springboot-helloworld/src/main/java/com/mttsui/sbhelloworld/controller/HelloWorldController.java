package com.mttsui.sbhelloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/11/20 0020.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/host")
    public String index(HttpServletRequest request){
        String host = request.getHeader("Host");
        return "Host: " + host;
    }
}