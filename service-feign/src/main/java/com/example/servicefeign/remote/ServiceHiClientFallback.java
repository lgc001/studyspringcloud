package com.example.servicefeign.remote;

import com.example.servicefeign.dto.ResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

//SchedualServiceHiHystric需要实现SchedualServiceHi 接口，并注入到Ioc容器中。实现断路器的断路时的快速返回内容
@Component
public class ServiceHiClientFallback implements ServiceHiClient {
    @Override
    public String sayHiFromClientOne(@RequestParam(value = "name") String name) {
        return "sorry "+name;
    }

    @Override
    public ResponseDto test(@RequestParam(value = "name") String name){

        return new ResponseDto("9999");
    }

    @Override
    public ResponseDto testException(@RequestParam(value = "name") String name){

        return new ResponseDto("9999");
    }

    @Override
    public ResponseDto testException1(@RequestParam(value = "name") String name){
        ResponseDto resp=new ResponseDto("9999");
        resp.setCode("9999");
        return resp;
    }
}
