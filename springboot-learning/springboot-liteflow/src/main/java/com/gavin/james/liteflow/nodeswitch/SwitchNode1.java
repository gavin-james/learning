package com.gavin.james.liteflow.nodeswitch;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@LiteflowComponent("switchnode1")
@Slf4j
public class SwitchNode1 extends NodeComponent {

    @Override
    public void process() {
        //do your business
        SwitchNode1.log.info("switchnode1 组件");
    }
}