package com.zd.baseframework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;

/**
 * @Title: com.zd.baseframework.BaseFrameworkApplication
 * @Description 启动类，此类注解的值内容可以从外部的配置系统中配置
 * @author liudong
 * @date 2022/6/13 10:41 PM
 */
@SpringBootApplication(scanBasePackages = {"com.zd.baseframework", "cn.hutool.extra.spring"})
@MapperScan({"com.zd.baseframework"})
@EnableConfigurationProperties
@EnableScheduling
@EnableAsync
public class BaseFrameworkApplication {

    public static void main(String []args){
        TimeZone.setDefault(TimeZone.getTimeZone("CTT"));
        SpringApplication.run(BaseFrameworkApplication.class, args);
    }
}