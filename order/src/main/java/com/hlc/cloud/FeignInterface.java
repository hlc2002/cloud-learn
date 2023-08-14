package com.hlc.cloud;

import com.hlc.cloud.entity.Product;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Dell
 * @date 2023/3/2 14:07
 * @package_name com.hlc.cloud
 * @project_name spring_cloud
 */

/*对应调用的微服务名称*/
@FeignClient(name = "product",configuration = FeignAutoConfiguration.class,fallback = FeignHystrix.class)
public interface FeignInterface {
    /*对应微服务的访问路径*/
    @GetMapping("/product/{id}")
    Product findById(@PathVariable("id")int id);
}
