package com.example.servicefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果
 *
 * Feign是自带断路器的，在低版本的Spring Cloud中，它没有默认打开。需要在配置文件中配置打开它，在配置文件加以下代码：feign.hystrix.enabled=true
 */
@EnableDiscoveryClient //通过@EnableDiscoveryClient向服务中心注册
@EnableFeignClients  //@EnableFeignClients注解开启Feign的功能
@SpringBootApplication
@EnableHystrixDashboard  //在主程序启动类中加入@EnableHystrixDashboard注解，开启hystrixDashboard,访问http://localhost:8765/hystrix
public class ServiceFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignApplication.class, args);
    }
}
