package com.example.servicefeign.remote;

import com.example.servicefeign.remote.SchedualServiceHi;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

//SchedualServiceHiHystric需要实现SchedualServiceHi 接口，并注入到Ioc容器中。实现断路器的断路时的快速返回内容
@Component
public class SchedualServiceHiFallback implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(@RequestParam(value = "name") String name) {
        return "sorry "+name;
    }
}