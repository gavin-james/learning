package com.gavin.task.controller;

import com.gavin.task.service.TaskService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class TaskController {

  @Autowired
  TaskService taskService;

  @GetMapping("task")
  public String testAsync(){
    taskService.async();
    log.info("TaskController运行了");
    return "ok";
  }
}
