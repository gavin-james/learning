package com.gavin.james.liteflow.nodeswitch;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@LiteflowComponent("switchnode3")
@Slf4j
public class SwitchNode3 extends NodeComponent {

    @Override
    public void process() {
        //do your business
        SwitchNode3.log.info("switchnode3 组件");
    }
}