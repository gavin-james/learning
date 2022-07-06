package com.gavin.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gavin.security.handle.AuthSuccessHandle;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final  PasswordEncoder passwordEncoder;
  private final AuthSuccessHandle authSuccessHandle;
  private final AuthenticationFailureHandler authenticationFailureHandler;
  private final AccessDeniedHandler accessDeniedHandler;

  //  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.inMemoryAuthentication()
//            .withUser("test")
//            .password(passwordEncoder.encode("123456"))
//            .roles("test_admin")
//            .authorities("sys:get", "sys:add", "sys:edit");
//  }
  public static void main(String[] args) {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    System.out.println(bCryptPasswordEncoder.encode("123456"));
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // 这是访问异常处理器
    http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    // 这是认证成功处理器和认证失败处理器
    http.formLogin().successHandler(authSuccessHandle).failureHandler(authenticationFailureHandler);
    // 这是拦截所有的请求
    http.authorizeRequests().anyRequest().authenticated();
  }
}
