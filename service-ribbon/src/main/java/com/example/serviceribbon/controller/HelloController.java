package com.example.serviceribbon.controller;

import com.example.serviceribbon.dto.NameValue;
import com.example.serviceribbon.dto.ResponseDto;
import com.example.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }

    @RequestMapping(value = "/testGet")
    public String testGet(@RequestParam String name){
        name = "dsafadaf";
        ResponseDto responseDto1 = helloService.test(name);

        ResponseDto responseDto2 = helloService.testException(name);

        ResponseDto responseDto3 = helloService.testException1(name);

        NameValue nameValue = helloService.getForEntityIdentifyByType(name);

        return "ok";
    }
}
