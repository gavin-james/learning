package com.gavin.mapstruct.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 枚举类
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {

  ALL("这是一个枚举类");

  private String value;
}
