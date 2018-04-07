package com.example.servicefeign.Service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "service-ribbon")
public interface SchedualServiceRibbon {
    @RequestMapping(value = "/home/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/home/index",method = RequestMethod.POST)
    String sayIndexFromClientOne(@RequestBody Map<String,String> map);
}
