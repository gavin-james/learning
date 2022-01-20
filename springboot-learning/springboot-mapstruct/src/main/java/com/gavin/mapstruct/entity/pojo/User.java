package com.gavin.mapstruct.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
  private Integer id;
  private String name;
  private String createTime;
  private LocalDateTime updateTime;
}
