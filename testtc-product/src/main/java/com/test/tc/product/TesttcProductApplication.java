package com.test.tc.product;

import com.test.tc.common.ExceptionControllerAdvice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ExceptionControllerAdvice.class)
public class TesttcProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesttcProductApplication.class, args);
    }

}
