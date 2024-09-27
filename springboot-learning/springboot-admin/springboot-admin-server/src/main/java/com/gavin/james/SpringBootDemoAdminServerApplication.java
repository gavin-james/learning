package com.gavin.james;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gavin
 * @date 2021/7/6 0006 1:49
 */
@SpringBootApplication
@EnableAdminServer
public class SpringBootDemoAdminServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoAdminServerApplication.class, args);
    }

}
