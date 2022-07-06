package com.gavin.cache.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2021-12-08 17:30:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends Model<User> {

  @TableId(type = IdType.AUTO)
  private Long id;

  private String name;

  public User(String name) {
    this.name = name;
  }
}

