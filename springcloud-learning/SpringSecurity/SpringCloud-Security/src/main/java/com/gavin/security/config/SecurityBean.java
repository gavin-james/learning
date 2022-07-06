package com.gavin.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class SecurityBean {

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  private final ObjectMapper jacksonObjectMapper;

  @Bean
  public AuthenticationFailureHandler authenticationFailureHandler() {
    return (request, response, exception) -> {
      response.setContentType("application/json; charset=UTF-8");
      PrintWriter writer = response.getWriter();
      Map<String, Object> map = new HashMap<>();
      map.put("code", 500);
      String msg = "登陆失败";
      if (exception instanceof LockedException) {
        msg = "账号被锁定，登录失败";
      } else if (exception instanceof BadCredentialsException) {
        msg = "账号或者密码错误，登录失败";
      } else if (exception instanceof DisabledException) {
        msg = "账号已禁用，登录失败";
      } else if (exception instanceof AccountExpiredException) {
        msg = "账号已过期，登录失败";
      } else if (exception instanceof CredentialsExpiredException) {
        msg = "密码已过期，登录失败";
      }

      map.put("msg", msg);
      map.put("data", null);

      String s = jacksonObjectMapper.writeValueAsString(map);
      writer.write(s);
      writer.flush();
      writer.close();
    };
  }

  @Bean
  public AccessDeniedHandler accessDeniedHandler() {
    return (request, response, accessDeniedException) -> {
      System.out.println("访问被拒绝 返回json");
      response.setContentType("application/json; charset=UTF-8");
      PrintWriter writer = response.getWriter();
      Map<String, Object> map = new HashMap<>();
      map.put("code", 403);
      map.put("msg", "访问被拒绝");
      map.put("data", null);
      String s = jacksonObjectMapper.writeValueAsString(map);
      writer.write(s);
      writer.flush();
      writer.close();
    };
  }

}
