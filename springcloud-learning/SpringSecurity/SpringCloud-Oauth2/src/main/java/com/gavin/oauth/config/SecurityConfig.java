package com.gavin.oauth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final PasswordEncoder passwordEncoder;

//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.inMemoryAuthentication()
//            .withUser("test")
//            .password(passwordEncoder.encode("123456"))
//            .authorities("sys:view");
//  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.formLogin()
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .cors()
            .disable();
  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
}
