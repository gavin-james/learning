package com.gavin.james.liteflow.data;

import com.gavin.james.model.User;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@LiteflowComponent("datanode3")
@Slf4j
public class DataNode3 extends NodeComponent {

    @Override
    public void process() {
        //do your business
        User user = this.getContextBean(User.class);
        DataNode3.log.info("datanode1 组件 接收到 user 信息 {}", user);
    }
}