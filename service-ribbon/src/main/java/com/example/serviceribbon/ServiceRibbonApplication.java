package com.example.serviceribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * ribbon ribbon是对服务之间调用做负载，是服务之间的负载均衡
 *
 * 较底层的服务如果出现故障，会导致连锁故障。当对特定的服务的调用的不可用达到一个阀值（Hystric 是5秒20次） 断路器将会被打开
 * 断路打开后，可用避免连锁故障，fallback方法可以直接返回一个固定值
 */
@EnableDiscoveryClient //通过@EnableDiscoveryClient向服务中心注册
@SpringBootApplication
@EnableHystrix //加@EnableHystrix注解开启Hystrix断路器
@EnableHystrixDashboard  //在主程序启动类中加入@EnableHystrixDashboard注解，开启hystrixDashboard,访问http://localhost:8764/hystrix
public class ServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class, args);
    }

    //向程序的ioc注入一个bean: restTemplate;并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
