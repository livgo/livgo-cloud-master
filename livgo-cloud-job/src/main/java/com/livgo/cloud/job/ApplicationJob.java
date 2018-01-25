package com.livgo.cloud.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:Job系统
 * Author:     gaocl
 * Date:       2017/12/14
 * Version:    V1.0.0
 * Update:     更新说明
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages={"com.livgo.cloud.service.*.api"})
@EnableHystrix
@ComponentScan(basePackages={"com.livgo.cloud"})
public class ApplicationJob {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationJob.class, args);
    }
}
