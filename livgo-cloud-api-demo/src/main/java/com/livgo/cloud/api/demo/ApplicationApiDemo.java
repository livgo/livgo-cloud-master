package com.livgo.cloud.api.demo;

import com.livgo.cloud.core.swagger.EnableSwagger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:DEMO API
 * Author:     gaocl
 * Date:       2017/12/1
 * Version:    V1.0.0
 * Update:     更新说明
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.livgo.cloud.service.*.api"})
@EnableHystrix
@ComponentScan(basePackages = {"com.livgo.cloud"})
@MapperScan("com.livgo.cloud.**.mapper")
@EnableSwagger
public class ApplicationApiDemo {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationApiDemo.class, args);
    }
}
