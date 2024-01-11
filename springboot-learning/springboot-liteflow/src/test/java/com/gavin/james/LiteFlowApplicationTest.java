package com.gavin.james;

import com.gavin.james.model.User;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
public class LiteFlowApplicationTest {
    @Resource
    private FlowExecutor flowExecutor;

    @Test
    void normalComponent() {
        LiteflowResponse response = this.flowExecutor.execute2Resp("chain1", "arg");
        System.out.println(response);
    }

    @Test
    void parallelChainComponent() {
        LiteflowResponse response = this.flowExecutor.execute2Resp("parallelchain", "arg");
        System.out.println(response);
    }

    @Test
    void switchComponent() {
        LiteflowResponse response = this.flowExecutor.execute2Resp("switchnode", "arg");
        System.out.println(response);
    }

    @Test
    void dataComponent() {
        User user = new User();
        user.setName("小李");
        user.setAge(16);
        LiteflowResponse response = this.flowExecutor.execute2Resp("data", null, user);
        User contextBean = response.getFirstContextBean();
        System.out.println(contextBean);
    }
}
