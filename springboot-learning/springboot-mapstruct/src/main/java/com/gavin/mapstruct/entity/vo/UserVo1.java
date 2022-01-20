package com.gavin.mapstruct.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 被映射类VO1:和实体类一模一样
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVo1 {
  private Integer id;
  private String name;
  private String createTime;
  private LocalDateTime updateTime;
}
