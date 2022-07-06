package com.gavin.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping
public class UserInfoController {

  @GetMapping("userinfo1")
  public Principal getUserInfo1(Principal principal) {
    return principal;
  }

  @GetMapping("userinfo2")
  public Authentication getUserInfo2() {
    return SecurityContextHolder.getContext().getAuthentication();
  }
}
