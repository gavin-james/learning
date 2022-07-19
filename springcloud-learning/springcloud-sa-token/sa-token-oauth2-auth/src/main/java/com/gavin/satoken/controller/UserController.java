package com.gavin.satoken.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.gavin.satoken.common.R;
import com.gavin.satoken.entity.UserVo;
import com.gavin.satoken.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义Oauth2获取令牌接口
 * Created by macro on 2020/7/17.
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserServiceImpl userService;

  @PostMapping(value = "/login")
  public R login(@RequestBody UserVo user) {
    SaTokenInfo saTokenInfo = userService.login(user);
    if (saTokenInfo == null) {
      return R.validateFailed("用户名或密码错误");
    }
    Map<String, String> tokenMap = new HashMap<>();
    tokenMap.put("token", saTokenInfo.getTokenValue());
    tokenMap.put("tokenHead", saTokenInfo.getTokenName());
    return R.success(tokenMap);
  }
}