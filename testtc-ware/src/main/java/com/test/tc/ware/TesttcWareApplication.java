package com.test.tc.ware;

import com.test.tc.common.ExceptionControllerAdvice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ExceptionControllerAdvice.class)
public class TesttcWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesttcWareApplication.class, args);
    }

}
