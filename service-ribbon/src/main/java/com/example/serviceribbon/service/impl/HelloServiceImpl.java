package com.example.serviceribbon.service.impl;

import com.example.serviceribbon.dto.NameValue;
import com.example.serviceribbon.dto.ResponseDto;
import com.example.serviceribbon.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.naming.Name;
import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    RestTemplate restTemplate;

    //加上@HystrixCommand注解。该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法，熔断方法直接返回了一个字符串，字符串为”hi,”+name+”,sorry,error!”
    @HystrixCommand(fallbackMethod = "hiError")
    @Override
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/home/test?name=" + name, String.class);//SERVICE-HI大小写都行
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

    @Override
    public ResponseDto test(String name){
        NameValue nv=new NameValue();
        nv.setName("nametest");
        nv.setValue("valueTest");
        String result = restTemplate.getForObject("http://SERVICE-HI/home/test1", String.class,nv);

        return new ResponseDto();
    }

    @Override
    public ResponseDto testException(String name){
        try {
            return restTemplate.getForObject("http://SERVICE-HI/home/testExcepion1?name=" + name, ResponseDto.class);
        }catch (Exception e){
            return new ResponseDto("1");
        }
    }

    @Override
    public ResponseDto testException1(String name){
        try {
            return restTemplate.getForObject("http://SERVICE-HI/home/testException1?name=" + name, ResponseDto.class);
        }catch (Exception e){
            return new ResponseDto("1");
        }
    }

    @Override
    public NameValue getForEntityIdentifyByType(String name){
        ResponseEntity<NameValue> entity = restTemplate.getForEntity("http://SERVICE-HI/home/test?name=" + name,NameValue.class);
        return entity.getBody();
    }
}
