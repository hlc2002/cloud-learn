package com.hlc.cloud;

import com.hlc.cloud.entity.Product;
import org.springframework.stereotype.Component;

/**
 * @author Dell
 * @date 2023/3/2 15:05
 * @package_name com.hlc.cloud
 * @project_name spring_cloud
 */
@Component("feignHystrix")
public class FeignHystrix implements FeignInterface{

    public Product findById(int id) {
        Product product = new Product();
        product.setId(-1);
        product.setProductName("服务熔断");
        return product;
    }
}
