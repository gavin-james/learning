package com.gavin.james.liteflow.nomal;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

@LiteflowComponent("b")
@Slf4j
public class BCmp extends NodeComponent {

    @Override
    public void process() {
        //do your business
        BCmp.log.info("B组件");
    }
}