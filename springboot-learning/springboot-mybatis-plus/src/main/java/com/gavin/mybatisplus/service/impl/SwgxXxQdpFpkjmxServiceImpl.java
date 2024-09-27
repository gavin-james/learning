package com.gavin.mybatisplus.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gavin.mybatisplus.entity.SwgxXxQdpFpkjmx;
import com.gavin.mybatisplus.mapper.SwgxXxQdpFpkjmxMapper;
import com.gavin.mybatisplus.service.SwgxXxQdpFpkjmxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@Slf4j
public class SwgxXxQdpFpkjmxServiceImpl extends ServiceImpl<SwgxXxQdpFpkjmxMapper, SwgxXxQdpFpkjmx> implements SwgxXxQdpFpkjmxService {
    @Override
    public void saveData() {
        List<SwgxXxQdpFpkjmx> list = new CopyOnWriteArrayList<>();
        SwgxXxQdpFpkjmxServiceImpl.log.info("开始生成五十万的数据");
        for (int i = 0; i < 500000; i++) {
            SwgxXxQdpFpkjmx swgxXxQdpFpkjmx = new SwgxXxQdpFpkjmx();
            swgxXxQdpFpkjmx.setQdqFpkjId("");
            swgxXxQdpFpkjmx.setFpkjId("");
            swgxXxQdpFpkjmx.setFpkjmxId("");
            swgxXxQdpFpkjmx.setXh("");
            swgxXxQdpFpkjmx.setFphxz("");
            swgxXxQdpFpkjmx.setZkxh1("");
            swgxXxQdpFpkjmx.setXmmc("");
            swgxXxQdpFpkjmx.setSpfwjc("");
            swgxXxQdpFpkjmx.setSpmc(this.randomChineseName(10));
            swgxXxQdpFpkjmx.setSpbm("");
            swgxXxQdpFpkjmx.setGgxh("");
            swgxXxQdpFpkjmx.setDw("");
            swgxXxQdpFpkjmx.setDj("");
            swgxXxQdpFpkjmx.setSpsl("");
            swgxXxQdpFpkjmx.setJe("");
            swgxXxQdpFpkjmx.setHsje("");
            swgxXxQdpFpkjmx.setSe("");
            swgxXxQdpFpkjmx.setSlv(this.randomSl());
            swgxXxQdpFpkjmx.setLslbs("");
            swgxXxQdpFpkjmx.setYhzcbs("");
            swgxXxQdpFpkjmx.setSsyhzclxDm("");
            swgxXxQdpFpkjmx.setZzstsgl("");
            swgxXxQdpFpkjmx.setTdyslxDm("");
            swgxXxQdpFpkjmx.setTdzsfsDm("");
            swgxXxQdpFpkjmx.setZspmDm("");
            swgxXxQdpFpkjmx.setZzszcyjDm("");
            swgxXxQdpFpkjmx.setHzfpdylzfpmxxh("");
            swgxXxQdpFpkjmx.setHsdj("");
            swgxXxQdpFpkjmx.setBhsdj("");
            swgxXxQdpFpkjmx.setBhsje("");
            swgxXxQdpFpkjmx.setYslv("");
            swgxXxQdpFpkjmx.setBzkhMxid("");
            swgxXxQdpFpkjmx.setZkje("");
            swgxXxQdpFpkjmx.setJzfwfsd("");
            swgxXxQdpFpkjmx.setJzxmmc("");
            swgxXxQdpFpkjmx.setCqzsh("");
            swgxXxQdpFpkjmx.setKz1("");
            swgxXxQdpFpkjmx.setKz2("");
            swgxXxQdpFpkjmx.setKz3("");
            swgxXxQdpFpkjmx.setKz4("");
            swgxXxQdpFpkjmx.setKz5("");
            swgxXxQdpFpkjmx.setKz6("");
            swgxXxQdpFpkjmx.setSppc("");
            swgxXxQdpFpkjmx.setLzmxxh("");
            list.add(swgxXxQdpFpkjmx);
        }
        SwgxXxQdpFpkjmxServiceImpl.log.info("开始插入五十万的数据");
        this.saveBatch(list);
        SwgxXxQdpFpkjmxServiceImpl.log.info("插入完成");
    }

    String randomChineseName(int length) {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < length; i++) {
            name.append(RandomUtil.randomChinese());
        }
        return name.toString();
    }

    String randomSl() {
        return String.valueOf(RandomUtil.randomInt(0, 100) / 100.0);
    }
}
