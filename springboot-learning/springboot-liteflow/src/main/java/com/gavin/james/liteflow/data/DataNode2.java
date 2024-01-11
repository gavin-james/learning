package com.gavin.james.liteflow.data;

import com.gavin.james.model.User;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@LiteflowComponent("datanode2")
@Slf4j
public class DataNode2 extends NodeComponent {

    @Override
    public void process() {
        //do your business
        User user = this.getContextBean(User.class);
        DataNode2.log.info("datanode1 组件 接收到 user 信息 {}", user);
        user.setAge(user.getAge() + 1);
    }
}