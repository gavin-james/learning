package com.gavin.mapstruct.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 被映射类VO3:类型不一致
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVo3 {
  private String id;
  private String name;
  /**
   * 实体类该属性是String
   */
  private LocalDateTime createTime;
  /**
   * 实体类该属性是LocalDateTime
   */
  private String updateTime;
}
