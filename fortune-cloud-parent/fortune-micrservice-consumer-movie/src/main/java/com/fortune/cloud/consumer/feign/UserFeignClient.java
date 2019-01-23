package com.fortune.cloud.consumer.feign;

import com.fortune.cloud.config.FeignConfiguration;
import com.fortune.cloud.consumer.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author <a href="mailto:pinker.lin@zkteco.com">pinker.lin</a>
 * @version V1.0
 * @date Created In 13:40 2019/1/23
 */
@FeignClient(value="microservice-provider-user",configuration = FeignConfiguration.class)
public interface UserFeignClient {

    @RequestLine("GET /simple/{id}")
    User findById(@Param("id") Long id);
}
