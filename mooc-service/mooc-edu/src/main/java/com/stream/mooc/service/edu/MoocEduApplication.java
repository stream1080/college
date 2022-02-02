package com.stream.mooc.service.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author stream
 * @since 2022/2/2 21:38
 */
@SpringBootApplication
@ComponentScan({"com.stream.mooc"})
public class MoocEduApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoocEduApplication.class, args);
    }
}
