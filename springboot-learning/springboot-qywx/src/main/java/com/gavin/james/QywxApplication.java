package com.gavin.james;

import com.github.shuaidd.autoconfigure.EnableWeChat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableWeChat
public class QywxApplication {
    public static void main(String[] args) {
        SpringApplication.run(QywxApplication.class, args);
    }

}