package com.example.servicefeign.controller;

import com.example.servicefeign.dto.ResponseDto;
import com.example.servicefeign.remote.ServiceHiClient;
import com.example.servicefeign.remote.SchedualServiceRibbon;
import com.example.servicefeign.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HiController {

    @Autowired
    ServiceHiClient serviceHiClient;

    @Autowired
    SchedualServiceRibbon schedualServiceRibbon;
    @Autowired
    TestService testService;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return serviceHiClient.sayHiFromClientOne(name);
    }

    @RequestMapping(value = "/ribbonhi",method = RequestMethod.GET)
    public String sayRibbonHi(@RequestParam String name){
        return schedualServiceRibbon.sayHiFromClientOne(name);
    }

    @RequestMapping(value = "/ribbonindex",method = RequestMethod.GET)
    public String sayRibbonIndex()
    {
        Map<String,String> map=new HashMap<>();
        map.put("key","testvalue");
        map.put("testkey","hihi--hihi");

        return schedualServiceRibbon.sayIndexFromClientOne(map);
    }

    @RequestMapping(value = "/ribbonIndex",method = RequestMethod.GET)
    public String ribbonIndex()
    {
        return testService.getRibbonIndex();
    }

    @RequestMapping("/test")
    public ResponseDto test() {
        return serviceHiClient.test("user");
    }

    @RequestMapping("/test-exception")
    public ResponseDto testException() {
        return serviceHiClient.testException("user");
    }

    @RequestMapping("/test-exception1")
    public ResponseDto testException1() {
        return serviceHiClient.testException1("user");
    }
}
