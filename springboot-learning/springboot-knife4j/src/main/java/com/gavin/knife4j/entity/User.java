package com.gavin.knife4j.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "用户信息实体", description = "用户信息实体描述")
public class User {

  @Schema(name = "编号", description = "这是编号的哦", title = "编号标题")
  private String id;

  @Schema(description = "用户 名字", type = "string", required = true, minLength = 4, maxLength = 12, example = "10086")
  private String name;
}
