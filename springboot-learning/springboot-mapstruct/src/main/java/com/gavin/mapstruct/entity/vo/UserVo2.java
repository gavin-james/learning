package com.gavin.mapstruct.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 被映射类VO2:比实体类少一个字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVo2 {
  private Integer id;
  private String name;
  private String createTime;
}
