package com.gavin.knife4j.controller;

import com.gavin.knife4j.entity.User;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@Api(value = "upload", tags = "文件上传")
public class HelloController {

  @GetMapping
  @Operation(summary = "获取信息", description = "方法描述")
  public String get() {
    return "hello";
  }

  @GetMapping("user")
  @Operation(summary = "获取详细", description = "方法描述")
  public User getUser() {
    User u = new User();
    u.setId("123").setName("张三");
    return u;
  }

  @GetMapping("list")
  @Operation(summary = "获取列表", description = "方法描述")
  @Parameters({@Parameter(name = "name", description = "用户名称", required = true)})
  public User getUserList(String name) {
    User u = new User();
    u.setId("123").setName("张三");
    return u;
  }
}
