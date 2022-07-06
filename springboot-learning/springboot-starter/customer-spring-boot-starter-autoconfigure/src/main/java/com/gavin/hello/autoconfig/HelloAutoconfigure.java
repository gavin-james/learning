package com.gavin.hello.autoconfig;

import com.gavin.hello.bean.HelloProperties;
import com.gavin.hello.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloProperties.class)
public class HelloAutoconfigure {
  @Bean
  @ConditionalOnMissingBean(HelloService.class)
  public HelloService helloService() {
    return new HelloService();
  }
}
