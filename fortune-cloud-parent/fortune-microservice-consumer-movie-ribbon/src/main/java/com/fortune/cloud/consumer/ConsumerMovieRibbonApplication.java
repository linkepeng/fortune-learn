package com.fortune.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//使用RibbonClient配置对应微服务，并且使用的配置规则使用了 configuration 对应的类
@RibbonClient(name = "microservice-provider-user", configuration = TestConfiguration.class)
//@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })
public class ConsumerMovieRibbonApplication {

    @Bean
    @LoadBalanced//使用这个注解实现客户端的负载均衡
    public RestTemplate restTemplate() {
      return new RestTemplate();
    }

    public static void main(String[] args) {

      SpringApplication.run(ConsumerMovieRibbonApplication.class, args);
    }
}
