package com.gavin.james.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.shuaidd.dto.message.MsgText;
import com.github.shuaidd.enums.MsgType;
import com.github.shuaidd.response.message.SendMessageResponse;
import com.github.shuaidd.resquest.message.SendMessageRequest;
import com.github.shuaidd.support.WeChatManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MessageController {
    private final WeChatManager weChatManager;
    private final ObjectMapper jackson;
    public static String APP = "customer-app";

    @PostMapping("sendTxtMsg")
    public SendMessageResponse sendTxtMsg(@RequestBody SendMessageRequest textRequest) throws Exception {
        /*
         * 文本消息
         */
        MessageController.log.info("参数为：{}", this.jackson.writeValueAsString(textRequest));

        textRequest.setMsgType(MsgType.TEXT);

        MsgText text = new MsgText();
        text.setContent("测试发送消息");
        textRequest.setText(text);
        return this.weChatManager.messageService().sendMessage(textRequest, MessageController.APP);
    }
}
