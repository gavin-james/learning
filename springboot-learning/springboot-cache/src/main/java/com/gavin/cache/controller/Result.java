package com.gavin.cache.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通用返回对象
 *
 * @author gavin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
  /**
   * 返回代码
   * error code
   */
  private long code;

  /**
   * 返回信息
   * error message
   */
  private String msg;

  /**
   * 返回数据
   * error data
   */
  private T data;

  /**
   * 根据枚举的结果返回信息
   */
  public static <V> Result<V> byEnum(long code, String msg, V data) {
    return new Result<>(code, msg, data);
  }
}
