package com.gavin.satoken.controller;

import com.gavin.satoken.common.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 * Created by macro on 2020/6/19.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public R hello() {
        return R.success("Hello World.");
    }

}