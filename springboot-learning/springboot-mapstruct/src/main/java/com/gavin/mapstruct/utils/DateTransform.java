package com.gavin.mapstruct.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

/**
 * 类型转换工具类
 */
@UtilityClass
public class DateTransform {
  public LocalDateTime strToDate(String str) {
    return LocalDateTime.parse(str);
  }
}
