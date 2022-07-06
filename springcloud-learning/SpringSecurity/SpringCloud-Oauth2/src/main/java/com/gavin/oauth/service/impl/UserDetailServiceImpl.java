package com.gavin.oauth.service.impl;

import com.gavin.oauth.service.AclUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

  private final AclUserService aclUserService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return aclUserService.selectByUsername(username);
  }
}
