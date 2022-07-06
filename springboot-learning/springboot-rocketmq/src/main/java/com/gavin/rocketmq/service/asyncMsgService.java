//package com.gavin.rocketmq.service;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//@RocketMQMessageListener(consumerGroup = "sync_message_group", topic = "TopicTest")
//public class asyncMsgService implements RocketMQListener<String> {
//
//  @Override
//  public void onMessage(String msg) {
//    log.info("syncMessage 接受到的消息是--->{}", msg);
//  }
//
//}
