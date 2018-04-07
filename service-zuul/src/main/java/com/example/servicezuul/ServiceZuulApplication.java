package com.example.servicezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/*在Spring Cloud微服务系统中，一种常见的负载均衡方式是，客户端的请求首先经过负载均衡（zuul、Ngnix），
再到达服务网关（zuul集群），然后再到具体的服务

Zuul的主要功能是路由转发和过滤器。路由功能是微服务的一部分，比如／api/user转发到到user服务，/api/shop转发到到shop服务。
zuul默认和Ribbon结合实现了负载均衡的功能。

zuul不仅只是路由，并且还能过滤，做一些安全验证

对于Zuul来说暴露在外面的也就是URL，我们可以使用Nginx对外暴露一个URL，然后转发到Zuul服务，Nginx还有负载均衡。
*/

@EnableZuulProxy  //注解@EnableZuulProxy，开启zuul的功能
@EnableEurekaClient
@SpringBootApplication
public class ServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }
}
