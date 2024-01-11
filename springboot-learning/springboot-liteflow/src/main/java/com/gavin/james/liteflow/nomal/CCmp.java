package com.gavin.james.liteflow.nomal;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@LiteflowComponent("c")
@Slf4j
public class CCmp extends NodeComponent {

    @Override
    public void process() {
        //do your business
        CCmp.log.info("C组件");
    }
}