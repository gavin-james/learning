package com.gavin.mybatisplus;

import com.gavin.mybatisplus.service.SwgxXxQdpFpkjmxService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisTest {

    @Autowired
    SwgxXxQdpFpkjmxService swgxXxQdpFpkjmxService;

    @Test
    void addData() {
        for (int i = 0; i < 200; i++) {
            this.swgxXxQdpFpkjmxService.saveData();
        }
    }
}
