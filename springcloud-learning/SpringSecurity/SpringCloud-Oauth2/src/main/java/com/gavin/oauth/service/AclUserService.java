package com.gavin.oauth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gavin.oauth.entity.AclUser;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表(AclUser)表服务接口
 *
 * @author makejava
 * @since 2022-01-06 17:52:06
 */
public interface AclUserService extends IService<AclUser> {

  /**
   * 根据用户登录名查用户
   *
   * @param username username 用户名
   * @return 当前的用户
   * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
   */
  AclUser selectByUsername(@Param("username") String username);
}

