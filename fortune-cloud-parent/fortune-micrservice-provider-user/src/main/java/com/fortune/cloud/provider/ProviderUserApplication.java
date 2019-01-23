package com.fortune.cloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
/**
 *注解是基于spring-cloud-netflix依赖，只能为eureka作用；
 * @EnableDiscoveryClient 注解是基于spring-cloud-commons依赖，并且在classpath中实现
 * @author linkepeng
 */
public class ProviderUserApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProviderUserApplication.class, args);
	}
	
}
