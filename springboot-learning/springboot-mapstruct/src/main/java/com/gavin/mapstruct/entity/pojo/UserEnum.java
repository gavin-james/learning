package com.gavin.mapstruct.entity.pojo;

import com.gavin.mapstruct.enums.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实体类 属性是枚举
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEnum {
  private Integer id;
  private String name;
  private UserTypeEnum userTypeEnum;
}
