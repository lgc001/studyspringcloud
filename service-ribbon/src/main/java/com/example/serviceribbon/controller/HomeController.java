package com.example.serviceribbon.controller;

import com.example.serviceribbon.util.JsonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name) {
        Map<String,String> map=new HashMap<>();
        map.put("key","testvalue");
        map.put("testkey","hi "+name+",i am service-ribbon from port:" +port);

        return JsonUtil.toJson(map);
    }

    @RequestMapping("/index")
    public String hi(@RequestBody Map<String,String> map) {
        map.put("ok","okvalue");

        return JsonUtil.toJson(map);
    }
}
