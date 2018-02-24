package com.livgo.cloud.admin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:后台管理系统-demo
 * Author:     gaocl
 * Date:       2017/12/14
 * Version:    V1.0.0
 * Update:     更新说明
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.livgo.cloud.service.*.api"})
@EnableHystrix
@ComponentScan(basePackages = {"com.livgo.cloud"})
public class ApplicationAdminDemo {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationAdminDemo.class, args);
    }
}
