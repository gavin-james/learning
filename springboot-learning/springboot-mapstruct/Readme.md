# 实体对象映射转换Mapstruct

[github地址](https://github.com/mapstruct/mapstruct)
idea插件： MapStruct Support

## 1、整合Mapstruct

### 1.1、引入依赖

Maven

``` xml
<!-- 核心依赖 -->
<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct</artifactId>
    <version>1.5.0.Beta2</version>
</dependency>

<!-- 注解解析器 -->
<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct-processor</artifactId>
    <version>1.5.0.Beta2</version>
</dependency>
```

Gradle

```groovy
// mapstruct 注解驱动器
annotationProcessor 'org.mapstruct:mapstruct-processor:1.5.0.Beta2'
// mapstruct 核心依赖包
implementation 'org.mapstruct:mapstruct:1.5.0.Beta2'
```

## 2、开始使用

### 2.1、添加实体类

```java
/**
 * 实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
  private Integer id;
  private String name;
  private String createTime;
  private LocalDateTime updateTime;
}

// -----------------------------------------

/**
 * 被映射类VO1:和实体类一模一样
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVo1 {
  private Integer id;
  private String name;
  private String createTime;
  private LocalDateTime updateTime;
}

// -----------------------------------------

/**
 * 被映射类VO2:比实体类少一个字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVo2 {
  private Integer id;
  private String name;
  private String createTime;
}
```

### 2.2、添加映射Mapper接口

```java
/**
 * 实体类转换映射接口
 * componentModel 用于指定自动生成的接口实现类的组件类型，个属性支持四个值
 *        default：mapstruct 不使用任何组件类型, 可以通过Mappers.getMapper(Class)方式获取自动生成的实例对象。
 *        cdi：The generated mapper is an application-scoped CDI bean and can be retrieved via @Inject
 *        spring：生成的实现类上面会自动添加一个@Component注解，可以通过Spring的 @Autowired方式进行注入
 *        jsr330：生成的实现类上会添加@javax.inject.Named 和@Singleton注解，可以通过 @Inject注解获取
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
  /**
   * 字段数量类型数量相同，利用工具BeanUtils也可以实现类似效果
   *
   * @param user 实体类
   * @return vo1 映射类
   */
  UserVo1 toVo1(User user);

  User vo1ToUser(UserVo1 userVo1);

  /**
   * 字段数量类型相同,数量少：仅能让多的转换成少的，故没有 vo2ToUser
   *
   * @param user 实体类
   * @return vo2 映射类
   */
  UserVo2 toVo2(User user);

}
```

### 2.3、开始测试

```java

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class test {
  @Autowired
  UserMapper userMapper;

  // 需要转化的user
  User user;

  @BeforeAll
  void init() {
    user = new User(1, "张三", "2022-01-14T09:55:40.812", LocalDateTime.now());
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

}
```

### 2.4、编译结果

编译后自动生成 UserMapper 的实现类 UserMapperImpl

```java

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2022-01-14T10:03:24+0800",
        comments = "version: 1.5.0.Beta2, compiler: javac, environment: Java 1.8.0_312 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

  @Override
  public UserVo1 toVo1(User user) {
    if (user == null) {
      return null;
    }

    UserVo1.UserVo1Builder userVo1 = UserVo1.builder();

    userVo1.id(user.getId());
    userVo1.name(user.getName());
    userVo1.createTime(user.getCreateTime());
    userVo1.updateTime(user.getUpdateTime());

    return userVo1.build();
  }

  @Override
  public User vo1ToUser(UserVo1 userVo1) {
    if (userVo1 == null) {
      return null;
    }

    User.UserBuilder user = User.builder();

    user.id(userVo1.getId());
    user.name(userVo1.getName());
    user.createTime(userVo1.getCreateTime());
    user.updateTime(userVo1.getUpdateTime());

    return user.build();
  }

  @Override
  public UserVo2 toVo2(User user) {
    if (user == null) {
      return null;
    }

    UserVo2.UserVo2Builder userVo2 = UserVo2.builder();

    userVo2.id(user.getId());
    userVo2.name(user.getName());
    userVo2.createTime(user.getCreateTime());

    return userVo2.build();
  }

}

```

### 2.5、运行即可展示结果

当想要转换一个集合的话，只需要把这里的实体类换成集合就行了，例如：

```java
List<UserVO1> toVO1List(List<User> userList);
```

## 3、复杂情况时

### 3.1、类型不一致

#### 3.1.1、映射类

```java
/**
 * 被映射类VO3:类型不一致
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVo3 {
  private String id;
  private String name;
  /**
   * 实体类该属性是String
   */
  private LocalDateTime createTime;
  /**
   * 实体类该属性是LocalDateTime
   */
  private String updateTime;
}
```

#### 3.1.2、映射接口

```java
/**
 * 字段类型不同时，需指定类型转换 ( 当然了 ， java 中有些不需要指定)
 *
 * @param user 实体类
 * @return vo3 映射类
 */
@Mappings({
        @Mapping(target = "createTime", expression = "java(com.gavin.mapstruct.utils.DateTransform.strToDate(user.getCreateTime()))"),
})
UserVo3 toVo3(User user);

        User vo3ToUser(UserVo3 userVo3);
```

其中 expression 指定使用如下工具类对类型进行转换

```java
/**
 * 类型转换工具类
 */
@UtilityClass
public class DateTransform {
  public LocalDateTime strToDate(String str) {
    return LocalDateTime.parse(str);
  }
}
```

#### 3.1.3、反编译结果

```java
@Override
public UserVo3 toVo3(User user){
        if(user==null){
        return null;
        }

        UserVo3.UserVo3Builder userVo3=UserVo3.builder();

        if(user.getId()!=null){
        userVo3.id(String.valueOf(user.getId()));
        }
        userVo3.name(user.getName());
        if(user.getUpdateTime()!=null){
        userVo3.updateTime(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(user.getUpdateTime()));
        }

        userVo3.createTime(com.gavin.mapstruct.utils.DateTransform.strToDate(user.getCreateTime()));

        return userVo3.build();
        }
```

#### 3.1.4 小结

当字段类型不一致时，以下的类型之间是 `mapstruct` 自动进行类型转换的:

- 1、基本类型及其他们对应的包装类型。此时 `mapstruct` 会自动进行拆装箱。不需要人为的处理
- 2、基本类型的包装类型和string类型之间

除此之外的类型转换我们可以通过定义表达式来进行指定转换。

### 3.2、字段名不一致

#### 3.2.1、实体类

```java
/**
 * 被映射类VO4:字段名不一致
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVo4 {
  /**
   * 实体类该属性名是id
   */
  private String userId;
  /**
   * 实体类该属性名是 name
   */
  private String userName;
  private String createTime;
  private String updateTime;
}
```

#### 3.1.2、映射接口

```java
/**
 * 名称不一致时，需要指定对应属性名称，否则不会进行注入
 *
 * @param user 实体类
 * @return vo4 映射类
 */
@Mappings({
        @Mapping(source = "id", target = "userId"),
        @Mapping(source = "name", target = "userName")
})
UserVo4 toVO4(User user);

        User vo4ToUser(UserVo4 userVo3);
```

#### 3.2.3、编译结果

```java
@Override
public UserVo4 toVO4(User user){
        if(user==null){
        return null;
        }

        UserVo4.UserVo4Builder userVo4=UserVo4.builder();

        if(user.getId()!=null){
        userVo4.userId(String.valueOf(user.getId()));
        }
        userVo4.userName(user.getName());
        userVo4.createTime(user.getCreateTime());
        if(user.getUpdateTime()!=null){
        userVo4.updateTime(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(user.getUpdateTime()));
        }

        return userVo4.build();
        }
```

#### 3.2.4、小结

当字段名不一致时，通过使用 `@Mappings` 注解指定对应关系，编译后即可实现对应字段的赋值。

### 3.3、属性是枚举类型

#### 3.3.1、实体类

```java
/**
 * 实体类 属性是枚举
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEnum {
  private Integer id;
  private String name;
  private UserTypeEnum userTypeEnum;
}
```

#### 3.3.2、映射类

```
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEnumVo {
  private Integer id;
  private String name;
  private String userTypeEnum;
}
```

#### 3.3.3、枚举对象

```
/**
 * 枚举类
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {

  ALL("这是一个枚举类");

  private String value;
}
```

#### 3.3.4、接口

```
/**
* 属性是枚举时 接口还是照常定义，不会受到它是枚举就有所变化
*
* @param userEnum 实体类
* @return userEnumVo 映射类
*/
UserEnumVo toEnumVO(UserEnum userEnum);

UserEnum enumVOToUser(UserEnumVo userEnumVo);
```

#### 3.3.5、编译结果

```java
@Override
public UserEnumVo toEnumVO(UserEnum userEnum){
        if(userEnum==null){
        return null;
        }

        UserEnumVo userEnumVo=new UserEnumVo();

        userEnumVo.setId(userEnum.getId());
        userEnumVo.setName(userEnum.getName());
        if(userEnum.getUserTypeEnum()!=null){
        userEnumVo.setUserTypeEnum(userEnum.getUserTypeEnum().name());
        }

        return userEnumVo;
        }
```

## 4、性能比较

使用 Mapstruct 在性能，速度上完虐 使用 BeanUtils 的实体转换，建议日后进行实体类转换，可以使用 Mapstruct

