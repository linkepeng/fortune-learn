package com.fortune.cloud.disconvery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
/**
 * 添加此注解才表示启动Eureka服务器
 * @author linkepeng
 */
public class DiscoveryEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryEurekaApplication.class, args);
    }
}
