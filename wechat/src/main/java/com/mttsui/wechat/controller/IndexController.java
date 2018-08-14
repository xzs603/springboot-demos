package com.mttsui.wechat.controller;

import com.mttsui.wechat.dto.ErrorDto;
import com.sun.javafx.binding.StringFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("index")
@RestController
public class IndexController {

    @GetMapping
    public String index() {
        return "Hello, baby.";
    }

    @GetMapping("rest")
    public String rest() {
        String rs = new RestTemplate().getForObject("https://m.cnblogs.com", String.class);
        return rs;
    }

    @GetMapping("wxerror")
    public ErrorDto wxerror() {
        ErrorDto rs = new RestTemplate().getForObject("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN", ErrorDto.class);
        return rs;
    }

    public static void main(String[] args) {
        String s = String.format("你好，%s", "张三");
        System.out.println(s);
    }
}
