package com.gavin.oauth.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 用户表(AclUser)表实体类
 *
 * @author makejava
 * @since 2022-01-06 17:52:05
 */
//@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AclUser implements UserDetails {
  //会员id
  private String id;
  //微信openid
  private String username;
  //密码
  private String password;
  //昵称
  private String nickName;
  //用户头像
  private String salt;
  //用户签名
  private String token;
  //逻辑删除 1（true）已删除， 0（false）未删除
  private Integer isDeleted;
  //创建时间
  private Date gmtCreate;
  //更新时间
  private Date gmtModified;

  @TableField(exist = false)
  private List<String> authorityList;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    ArrayList<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
    if (!CollectionUtils.isEmpty(authorityList)) {
      // 如果从数据库查询的有权限 就封装给他
      authorityList.forEach(auth -> simpleGrantedAuthorities.add(new SimpleGrantedAuthority(auth)));
    }
    return simpleGrantedAuthorities;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}

