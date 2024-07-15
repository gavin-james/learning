package com.gavin.sharding;

import com.gavin.sharding.entity.User;
import com.gavin.sharding.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class ShardingTest {

    @Autowired
    private UserService userService;

    @Test
    void insertUser() {
        User user;
        for (int i = 10; i < 10 + 1000; i++) {
            user = new User();
            user.setUsername(i + "");
            user.setAge(new Date());
            this.userService.save(user);
        }
    }

    @Test
    void select() {
        List<User> list = this.userService.list();
        System.out.println(list);
    }
}
