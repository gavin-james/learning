package com.gavin.atguigu.pattern.command;

/**
 * 创建命令接口
 */
public interface Command {
  void execute();

  void undo();
}
