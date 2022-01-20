package com.gavin.oauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.Principal;
import java.security.PublicKey;

@RestController
public class UserController {
  /**
   * 获取当前用户
   *
   * @return
   */
  @GetMapping("getUserInfo")
  public Principal userInfo(Principal principal) {
    return principal;
  }

  @Autowired
  private KeyPair keyPair;

  /**
   * 获取当前用户
   *
   * @return
   */
  @GetMapping("getUserInfo")
  public Principal getPublic(Principal principal) {
    keyPair.getPublic()
    return principal;
  }
}
