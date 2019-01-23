package com.fortune.cloud.consumer.controller;

import com.fortune.cloud.consumer.entity.User;
import com.fortune.cloud.consumer.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class MovieController {
  /*@Autowired
  private RestTemplate restTemplate;

  @Value("${user.userServicePath}")
  private String userServicePath;

  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
    // http://localhost:7900/simple/
    // VIP virtual IP
    // HAProxy Heartbeat
	System.err.println(userServicePath);
    return this.restTemplate.getForObject(userServicePath + id, User.class);
  }*/

/*  @GetMapping("/test")
  public String test() {
    ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
    System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

    ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-provider-user2");
    System.out.println("222" + ":" + serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());

    return "1";
  }*/


    /**使用Feign调用**/
    @Autowired
    private UserFeignClient userFeignClient;

    //通过feign 调用远程微服务数据
    @GetMapping("/feign/movie/{id}")
    public User findFeignById(@PathVariable Long id) {
        User user = userFeignClient.findById(id);
        return user;
    }

}
