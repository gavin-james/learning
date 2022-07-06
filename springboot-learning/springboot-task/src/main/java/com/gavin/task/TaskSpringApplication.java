package com.gavin.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author gavin
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class TaskSpringApplication {
  public static void main(String[] args) {
    SpringApplication.run(TaskSpringApplication.class, args);
  }
}
