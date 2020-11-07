package com.test.tc.order;

import com.test.tc.common.ExceptionControllerAdvice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.test.tc.order.fegin")
@Import(ExceptionControllerAdvice.class)
public class TesttcOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesttcOrderApplication.class, args);
    }

}
