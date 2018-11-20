package com.jiang.demo.bootview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author Jiang
 */
@SpringBootApplication
public class BootViewApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootViewApplication.class, args);
    }
}
