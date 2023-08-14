package com.hlc.cloud.fallback;

import com.hlc.cloud.client.OrderControllerClient;
import com.hlc.cloud.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Dell
 * @date 2023/3/2 15:05
 * @package_name com.hlc.cloud
 * @project_name spring_cloud
 */
@Component("feignHystrix")
@Slf4j
public class OrderControllerClientFallback implements FallbackFactory<OrderControllerClient> {

    @Override
    public OrderControllerClient create(Throwable cause) {
        return new OrderControllerClient() {
            @Override
            public Product findById(int id) {
                log.info("{}","获取错误，请重试");
                return new Product();
            }
        };
    }
}
