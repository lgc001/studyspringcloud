package com.example.servicehi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    //这里是调用配置中心，启动不了，似乎是不能既读本项目配置也读配置中心。config-client是只能配置中心
    @Value("${foo}")
    String foo;

    @RequestMapping(value = "/readConfigFoo")
    public String readConfigFoo(){
        return foo;
    }

    @RequestMapping("/index")
    public String index() {

        return "这是 test/index";
    }
}
