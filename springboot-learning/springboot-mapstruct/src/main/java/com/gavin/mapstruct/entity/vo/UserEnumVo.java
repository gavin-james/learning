package com.gavin.mapstruct.entity.vo;

import com.gavin.mapstruct.enums.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEnumVo {
  private Integer id;
  private String name;
  private String userTypeEnum;
}
