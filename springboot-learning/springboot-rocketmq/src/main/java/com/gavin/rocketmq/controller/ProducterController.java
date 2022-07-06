package com.gavin.rocketmq.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProducterController {
  private final RocketMQTemplate template;

  @GetMapping("sync_message")
  public SendResult syncMessage(String msg) {

    log.info("msg");
    return template.syncSend("syncMessage", MessageBuilder.withPayload(msg).build());
  }

  @GetMapping("async_message")
  public String asyncMessage(String msg) {
    template.asyncSend("asyncMessage", MessageBuilder.withPayload(msg).build(), new SendCallback() {
      @Override
      public void onSuccess(SendResult sendResult) {
        log.info("发送结果---》{}", sendResult);
      }

      @Override
      public void onException(Throwable e) {
        e.printStackTrace();
      }
    });
    return "正在发送";
  }

  @GetMapping("delay_message")
  public SendResult delayMessage(String msg) {
    return template.syncSend("delayMessage", MessageBuilder.withPayload(msg).build(), 1000, 1);
  }

  @GetMapping("tag_message")
  public SendResult tagMessage(String msg) {
    return template.syncSend("tagMessage", MessageBuilder.withPayload(msg).build(), 1000, 1);
  }
}
