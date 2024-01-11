package com.gavin.james.liteflow.nodeswitch;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@LiteflowComponent("switchnode2")
@Slf4j
public class SwitchNode2 extends NodeComponent {

    @Override
    public void process() {
        //do your business
        SwitchNode2.log.info("switchnode2 组件");
    }
}