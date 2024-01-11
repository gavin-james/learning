package com.gavin.james.liteflow.nomal;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@LiteflowComponent("a")
@Slf4j
public class ACmp extends NodeComponent {

    @Override
    public void process() {
        //do your business
        ACmp.log.info("A组件");
    }
}