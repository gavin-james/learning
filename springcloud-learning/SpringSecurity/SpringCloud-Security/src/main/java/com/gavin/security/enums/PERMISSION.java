package com.gavin.security.enums;

public enum PERMISSION {
  //
  USERLIST("user.list");

  private String value;

  PERMISSION(String value) {
    this.value = value;
  }

  public String getValue() {
    return "hasAuthority('" + value + "')";
  }
}
