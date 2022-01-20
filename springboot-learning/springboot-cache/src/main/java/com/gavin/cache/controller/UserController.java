package com.gavin.cache.controller;

import com.gavin.cache.entity.User;
import com.gavin.cache.service.UserService;
import lombok.extern.java.Log;
import org.springframework.cache.annotation.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2021-12-08 17:30:52
 */
@RestController
@Log
@RequestMapping("user")
public class UserController {
  /**
   * 服务对象
   */
  @Resource
  private UserService userService;

  /**
   * 分页查询所有数据
   *
   * @return 所有数据
   */
  @GetMapping
  @Cacheable(value = "user")
  public Result<List<User>> selectAll() {
    log.info("调用了selectAll方法");
    return Result.byEnum(200L, "ok", userService.list());
  }

  /**
   * 通过主键查询单条数据
   *
   * @param id 主键
   * @return 单条数据
   */
  @GetMapping("{id}")
  @Cacheable(value = "user",key="#id")
  public Result<User> selectOne(@PathVariable Serializable id) {
    log.info("调用了 selectOne 方法");
    return Result.byEnum(200L, "ok", userService.getById(id));
  }

  /**
   * 新增数据
   *
   * @return 新增结果
   */
  @PostMapping
  public Result<Boolean> insert(String name) {
    log.info("调用了 insert 方法");
    return Result.byEnum(200L, "ok", userService.save(new User(name)));
  }

    /**
     * 修改数据
     *
     * @return 修改结果
     */
    @PutMapping
    @CachePut(value="user",key = "#id")
    public Result<Boolean> update(Long id, String name) {
      log.info("调用了 update 方法");
      return Result.byEnum(200L, "ok", userService.updateById(new User(id,name)));
    }

    /**
     * 删除数据
     *
     * @return 删除结果
     */
    @DeleteMapping
    @CacheEvict(value = "user",key = "#id")
    public Result<Boolean> delete(Long id) {
      log.info("调用了 delete 方法");
        return Result.byEnum(200L, "ok", userService.removeById(id));
    }
}

