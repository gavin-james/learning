package com.gavin.oauth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gavin.oauth.entity.AclUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表(AclUser)表数据库访问层
 *
 * @author makejava
 * @since 2022-01-06 17:52:05
 */
public interface AclUserDao extends BaseMapper<AclUser> {

  /**
   * 批量新增数据（MyBatis原生foreach方法）
   *
   * @param entities List<AclUser> 实例对象列表
   * @return 影响行数
   */
  int insertBatch(@Param("entities") List<AclUser> entities);

  /**
   * 批量新增或按主键更新数据（MyBatis原生foreach方法）
   *
   * @param entities List<AclUser> 实例对象列表
   * @return 影响行数
   * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
   */
  int insertOrUpdateBatch(@Param("entities") List<AclUser> entities);

  /**
   * 根据用户登录名查用户
   *
   * @param username username 用户名
   * @return 当前的用户
   * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
   */
  AclUser selectByUsername(@Param("username") String username);

}

