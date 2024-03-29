package com.gavin.knife4j.entity;

import io.swagger.v3.oas.annotations.media.Schema;

/***
 *
 * @since:knife4j-springdoc-openapi-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2020/03/15 20:53
 */
public class User {

  @Schema(description = "主键id", defaultValue = "1")
  private String id;

  @Schema(description = "名称", defaultValue = "张飞")
  private String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
