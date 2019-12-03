package com.example.multipart.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.example.multipart.dao")
public class MyBatisConfig {
}
