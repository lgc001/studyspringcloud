package com.example.servicehi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/*
SpringCLoud中的“Discovery Service”有多种实现，比如：eureka, consul, zookeeper。
1，@EnableDiscoveryClient 注解是基于 spring-cloud-commons依赖，并且在classpath中实现；
2，@EnableEurekaClient 注解是基于 spring-cloud-netflix依赖，只能为eureka作用；
简单的说，就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient
*/

@EnableEurekaClient  //通过注解@EnableEurekaClient 表明自己是一个eurekaclient
@SpringBootApplication
public class ServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}
}
