package com.livgo.cloud.service.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:Demo服务
 * Author:     gaocl
 * Date:       2017/12/1
 * Version:    V1.0.0
 * Update:     更新说明
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages={"com.livgo.cloud"})
public class ApplicationServiceDemo {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationServiceDemo.class, args);
    }

}
