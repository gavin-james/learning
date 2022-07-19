package com.gavin.satoken.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.gavin.satoken.entity.UserDTO;
import com.gavin.satoken.entity.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl {
  private List<UserDTO> userList;

  @PostConstruct
  public void initData() {
    String password = SaSecureUtil.md5("123456");
    userList = new ArrayList<>();
    userList.add(UserDTO.builder()
            .id(1L)
            .username("admin")
            .password(password)
            .permissionList(Arrays.asList("api:user:info", "api:test:hello"))
            .build());
    userList.add(UserDTO.builder()
            .id(1L)
            .username("macro")
            .password(password)
            .permissionList(Arrays.asList("api:user:info"))
            .build());
  }

  public UserDTO loadUserByUsername(String username) {
    List<UserDTO> findUserList = userList.stream().filter(item -> item.getUsername().equals(username)).collect(Collectors.toList());
    if (CollectionUtils.isEmpty(findUserList)) {
      return null;
    }
    return findUserList.get(0);
  }

  public SaTokenInfo login(UserVo user) {
    SaTokenInfo saTokenInfo = null;
    UserDTO userDTO = loadUserByUsername(user.getUsername());
    if (userDTO == null) {
      return null;
    }
    if (!SaSecureUtil.md5(user.getPassword()).equals(userDTO.getPassword())) {
      return null;
    }
    // 密码校验成功后登录，一行代码实现登录
    StpUtil.login(userDTO.getId());
    // 将用户信息存储到Session中
    StpUtil.getSession().set("userInfo", userDTO);
    // 获取当前登录用户Token信息
    saTokenInfo = StpUtil.getTokenInfo();
    return saTokenInfo;
  }
}
