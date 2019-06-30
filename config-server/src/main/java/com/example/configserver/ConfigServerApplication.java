package com.example.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 在spring cloud config 组件中，分两个角色，一是config server，二是config client。
 * 启动程序：访问http://localhost:8888/foo/dev,若能得到数据，证明配置服务中心可以从远程程序获取配置信息
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
