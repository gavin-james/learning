package com.gavin.cache.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gavin
 */
@Configuration
@MapperScan("com.gavin.cache.dao")
public class MyBatisConfig {
}
