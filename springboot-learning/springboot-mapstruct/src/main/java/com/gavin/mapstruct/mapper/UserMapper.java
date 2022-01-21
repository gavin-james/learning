package com.gavin.mapstruct.mapper;

import com.gavin.mapstruct.entity.pojo.User;
import com.gavin.mapstruct.entity.pojo.UserEnum;
import com.gavin.mapstruct.entity.vo.*;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * 实体类转换映射接口
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
  /**
   * 字段数量类型数量相同，利用工具BeanUtils也可以实现类似效果
   *
   * @param user 实体类
   * @return vo1 映射类
   */
  UserVo1 toVo1(User user);

  User vo1ToUser(UserVo1 userVo1);

  /**
   * 字段数量类型相同,数量少：仅能让多的转换成少的，故没有 vo2ToUser
   *
   * @param user 实体类
   * @return vo2 映射类
   */
  UserVo2 toVo2(User user);

  /**
   * 字段类型不同时，需指定类型转换 ( 当然了 ， java 中有些不需要指定)
   *
   * @param user 实体类
   * @return vo3 映射类
   */
  @Mappings({
          @Mapping(target = "createTime", expression = "java(com.gavin.mapstruct.utils.DateTransform.strToDate(user.getCreateTime()))"),
  })
  UserVo3 toVo3(User user);

  User vo3ToUser(UserVo3 userVo3);


  /**
   * 名称不一致时，需要指定对应属性名称，否则不会进行注入
   *
   * @param user 实体类
   * @return vo4 映射类
   */
  @Mappings({
          @Mapping(source = "id", target = "userId"),
          @Mapping(source = "name", target = "userName")
  })
  UserVo4 toVO4(User user);

  User vo4ToUser(UserVo4 userVo3);


  /**
   * 属性是枚举时 接口还是照常定义，不会受到它是枚举就有所变化
   *
   * @param userEnum 实体类
   * @return userEnumVo 映射类
   */
  UserEnumVo toEnumVO(UserEnum userEnum);

  UserEnum enumVOToUser(UserEnumVo userEnumVo);
}
