package com.gavin.task.service;

import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Log
public class TaskService {
  @Async
  public void async(){
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    log.info("异步任务");
  }

  @Scheduled(cron = "0/10 * * * * ? ")
  public void testScheduled(){
    log.info("这是调度任务的时间"+(new Date()).getTime());
  }
}
