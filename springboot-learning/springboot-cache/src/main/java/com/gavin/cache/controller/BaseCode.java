package com.gavin.cache.controller;

import java.io.Serializable;

/**
 * 封装API的错误码
 *
 * @author tiny
 */
public interface BaseCode extends Serializable {

  /**
   * 返回错误代码
   * Return error code
   *
   * @return error code
   */
  long getCode();

  /**
   * 返回错误代码
   * Return error message
   *
   * @return error code
   */
  String getMsg();
}
