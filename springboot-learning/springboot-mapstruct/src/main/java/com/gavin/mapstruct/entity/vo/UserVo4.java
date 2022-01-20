package com.gavin.mapstruct.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 被映射类VO4:字段名不一致
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVo4 {
  /**
   * 实体类该属性名是id
   */
  private String userId;
  /**
   * 实体类该属性名是 name
   */
  private String userName;
  private String createTime;
  private String updateTime;
}
