package com.livgo.cloud.gateway.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Description:DEMO网关
 * Author:     gaocl
 * Date:       2017/12/08
 * Version:    V1.0.0
 * Update:     更新说明
 */
@SpringBootApplication
@EnableZuulProxy
public class ApplicationGatewayDemo {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationGatewayDemo.class, args);
    }
}
