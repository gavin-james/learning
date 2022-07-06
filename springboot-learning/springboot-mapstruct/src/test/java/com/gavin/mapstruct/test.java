package com.gavin.mapstruct;

import com.gavin.mapstruct.entity.pojo.User;
import com.gavin.mapstruct.entity.pojo.UserEnum;
import com.gavin.mapstruct.entity.vo.*;
import com.gavin.mapstruct.enums.UserTypeEnum;
import com.gavin.mapstruct.mapper.UserMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.time.LocalDateTime;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class test {
  @Autowired
  UserMapper userMapper;

  // 需要转化的user
  User user;
  UserEnum userEnum;

  @BeforeAll
  void init() {
    user = new User(1, "张三", "2022-01-14T09:55:40.812", LocalDateTime.now());
    userEnum = new UserEnum(1, "张三", UserTypeEnum.ALL);
  }

  /**
   * 字段类型、数量相同时，互相转换
   */
  @Test
  void vo1AndUser() {
    // 使用 mapper 对 user 和 vo1 进行转换
    UserVo1 userVo1 = userMapper.toVo1(this.user);
    User vo1User = userMapper.vo1ToUser(userVo1);

    System.out.println(userVo1);
    System.out.println(vo1User);
  }

  /**
   * 字段类型、数量少时，只能从数量多到数量少的转换
   */
  @Test
  void vo2AndUser() {
    // 使用 mapper 对 user 和 vo2 进行转换
    UserVo2 userVo2 = userMapper.toVo2(user);
    System.out.println(userVo2);
  }

  /**
   * 类型不一致
   */
  @Test
  void vo3AndUser() {
    // 使用 mapper 对 user 和 vo3 进行转换
    UserVo3 userVo3 = userMapper.toVo3(user);
    User vo3User = userMapper.vo3ToUser(userVo3);
    System.out.println(userVo3);
    System.out.println(vo3User);
  }

  /**
   * 名称不一致
   */
  @Test
  void vo4AndUser() {
    // 使用 mapper 对 user 和 vo4 进行转换
    UserVo4 userVo4 = userMapper.toVO4(user);
    User vo4User = userMapper.vo4ToUser(userVo4);
    System.out.println(userVo4);
    System.out.println(vo4User);
  }

  /**
   * 属性是枚举时
   */
  @Test
  void enumAndUser() {
    // 使用 mapper 对 user 和 vo4 进行转换
    UserEnumVo userEnumVo = userMapper.toEnumVO(userEnum);
    UserEnum enumUser = userMapper.enumVOToUser(userEnumVo);
    System.out.println(userEnumVo);
    System.out.println(enumUser);
  }

  /**
   * 测试 beanutils 和 mapstruct 的性能
   */
  @Test
  void test() {

//    StopWatch stopWatch = new StopWatch();
//
    User user = new User(1, "张三", "张三", LocalDateTime.now());
    UserVo1 userVo1 = userMapper.toVo1(user);
    System.out.println(userVo1);
//    int count = 1000000;
//    stopWatch.start("mapstruct");
//    for (int i = 0; i < count; i++) {
//      userMapper.toVo(user);
//    }
//    stopWatch.stop();
//
//    UserVo1 userVo1 = new UserVo1();
//    stopWatch.start("beanutils");
//    for (int i = 0; i < count; i++) {
//      BeanUtils.copyProperties(user, userVo1);
//    }
//    stopWatch.stop();
//
//    System.out.println(stopWatch.prettyPrint());
  }
}
