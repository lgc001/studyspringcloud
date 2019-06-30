package com.example.servicefeign.remote;

import com.example.servicefeign.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//通过@ FeignClient（“服务名”），来指定调用哪个服务。比如在代码中调用了service-hi服务的“/home/hi”接口
//断路器只需要在FeignClient的ServiceHiClient接口的注解中加上fallback的指定类就行了
@FeignClient(value = "service-hi",fallback = ServiceHiClientFallback.class)
public interface ServiceHiClient {

    @RequestMapping(value = "/home/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/home/test",method = RequestMethod.GET)
    ResponseDto test(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/home/test-exception",method = RequestMethod.GET)
    ResponseDto testException(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/home/test-exception1",method = RequestMethod.GET)
    ResponseDto testException1(@RequestParam(value = "name") String name);
}
