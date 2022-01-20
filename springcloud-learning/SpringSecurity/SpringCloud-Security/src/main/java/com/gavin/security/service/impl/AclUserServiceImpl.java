package com.gavin.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gavin.security.dao.AclUserDao;
import com.gavin.security.entity.AclUser;
import com.gavin.security.service.AclUserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(AclUser)表服务实现类
 *
 * @author makejava
 * @since 2022-01-06 17:52:06
 */
@Service("aclUserService")
public class AclUserServiceImpl extends ServiceImpl<AclUserDao, AclUser> implements AclUserService {
  @Override
  public AclUser selectByUsername(String username) {
    return baseMapper.selectByUsername(username);
  }
}

