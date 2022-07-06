package com.gavin.security.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gavin.security.api.ApiController;
import com.gavin.security.api.R;
import com.gavin.security.entity.AclUser;
import com.gavin.security.service.AclUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户表(AclUser)表控制层
 *
 * @author makejava
 * @since 2022-01-06 17:52:05
 */
@RestController
@RequestMapping("aclUser")
public class AclUserController extends ApiController {
  /**
   * 服务对象
   */
  @Resource
  private AclUserService aclUserService;

  /**
   * 分页查询所有数据
   *
   * @param username 用户名字
   * @return 所有数据
   */
  @GetMapping("get/{username}")
  public R<AclUser> selectByUsername(@PathVariable String username) {
    return success(this.aclUserService.selectByUsername(username));
  }

  /**
   * 分页查询所有数据
   *
   * @param page 分页对象
   * @return 所有数据
   */
  @GetMapping
  public R<Page<AclUser>> selectAll(Page<AclUser> page) {
    return success(this.aclUserService.page(page));
  }

  /**
   * 通过主键查询单条数据
   *
   * @param id 主键
   * @return 单条数据
   */
  @GetMapping("{id}")
  public R selectOne(@PathVariable Serializable id) {
    return success(this.aclUserService.getById(id));
  }

  /**
   * 新增数据
   *
   * @param aclUser 实体对象
   * @return 新增结果
   */
  @PostMapping
  public R insert(@RequestBody AclUser aclUser) {
    return success(this.aclUserService.save(aclUser));
  }

  /**
   * 修改数据
   *
   * @param aclUser 实体对象
   * @return 修改结果
   */
  @PutMapping
  public R update(@RequestBody AclUser aclUser) {
    return success(this.aclUserService.updateById(aclUser));
  }

  /**
   * 删除数据
   *
   * @param idList 主键结合
   * @return 删除结果
   */
  @DeleteMapping
  public R delete(@RequestParam("idList") List<Long> idList) {
    return success(this.aclUserService.removeByIds(idList));
  }
}

