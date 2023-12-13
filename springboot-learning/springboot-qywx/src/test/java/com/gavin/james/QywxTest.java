//package com.gavin.james;
//
//
//import com.github.shuaidd.dto.message.MsgTextCard;
//import com.github.shuaidd.enums.MsgType;
//import com.github.shuaidd.resquest.message.SendMessageRequest;
//import com.github.shuaidd.support.WeChatManager;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class QywxTest {
//
//    @Autowired
//    WeChatManager weChatManager;
//
//    @Test
//    void testSend() {
//        SendMessageRequest textCardRequest = this.buildSendMessageRequest();
//        textCardRequest.setMsgType(MsgType.TEXTCARD);
//
//        MsgTextCard textCard = new MsgTextCard();
//        textCard.setTitle("领奖通知");
//        textCard.setDescription("<div class=\"gray\">2016年9月26日</div> <div class=\"normal\">恭喜你抽中iPhone 7一台，领奖码：xxxx</div><div class=\"highlight\">请于2016年10月10日前联系行政同事领取</div>");
//        textCard.setUrl("http://www.baidu.com");
//        textCard.setBtntxt("更多");
//        textCardRequest.setTextcard(textCard);
//        this.weChatManager.messageService().sendMessage(textCardRequest, "send-msg");
//    }
//
//    private SendMessageRequest buildSendMessageRequest() {
//        SendMessageRequest request = new SendMessageRequest();
//        request.setAgentId("1000209");
//        request.setToUser("20170410022717");
//        return request;
//    }
//}
