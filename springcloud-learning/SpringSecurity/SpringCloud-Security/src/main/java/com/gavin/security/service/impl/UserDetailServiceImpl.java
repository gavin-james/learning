package com.gavin.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gavin.security.dao.AclUserDao;
import com.gavin.security.entity.AclUser;
import com.gavin.security.service.AclUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailServiceImpl extends ServiceImpl<AclUserDao, AclUser> implements UserDetailsService {

  @Autowired
  AclUserService aclUserService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AclUser aclUser = aclUserService.selectByUsername(username);
//    UserDetails userDetails = User.withUsername("test").password("123456").authorities("sys:add", "sys:del", "sys:edit").build();
    return aclUser;
  }

}
