package com.gavin.james.liteflow.nodeswitch;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeSwitchComponent;
import lombok.extern.slf4j.Slf4j;

@LiteflowComponent("switchnode")
@Slf4j
public class SwitchNode extends NodeSwitchComponent {

    @Override
    public String processSwitch() throws Exception {
        //do your business
        SwitchNode.log.info("switchnod 组件");
        return "switchnode1";
    }
}