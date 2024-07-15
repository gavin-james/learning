package com.gavin.sharding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gavin.sharding.entity.User;
import com.gavin.sharding.mapper.UserMapper;
import com.gavin.sharding.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @className: UserServiceImpl
 * @description: TODO 类描述
 * @author: liangshijie
 * @date: 2022/12/5
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
