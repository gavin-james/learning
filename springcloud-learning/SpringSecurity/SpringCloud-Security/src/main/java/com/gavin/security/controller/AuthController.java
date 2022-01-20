package com.gavin.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthController {

  @GetMapping("get")
  @PreAuthorize("hasAuthority('sys:get')")
  public String get() {
    return "get";
  }

  @GetMapping("add")
  @PreAuthorize("hasAuthority('sys:add')")
  public String add() {
    return "add";
  }

  @GetMapping("edit")
  @PreAuthorize("hasAuthority('sys:edit')")
  public String edit() {
    return "edit";
  }

  @GetMapping("del")
  @PreAuthorize("hasAuthority('sys:del')")
  public String del() {
    return "del";
  }
}
