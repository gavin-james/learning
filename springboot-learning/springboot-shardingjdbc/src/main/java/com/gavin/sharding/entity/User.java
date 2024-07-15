package com.gavin.sharding.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @className: User
 * @description: TODO 类描述
 * @author: liangshijie
 * @date: 2022/12/5
 **/
@Data
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String username;
    private Date age;
}
