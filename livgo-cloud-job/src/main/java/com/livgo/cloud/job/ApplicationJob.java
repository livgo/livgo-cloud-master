package com.livgo.cloud.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.core.Ordered;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Description:Job系统
 * Author:     gaocl
 * Date:       2017/12/14
 * Version:    V1.0.0
 * Update:     更新说明
 */
@SpringBootApplication
//@EnableDiscoveryClient
//@EnableFeignClients(basePackages={"com.livgo.cloud.service.*.api"})
//@ComponentScan(basePackages={"com.livgo.cloud"})
@EnableScheduling
@EnableAsync(
        mode = AdviceMode.PROXY, proxyTargetClass = false,
        order = Ordered.HIGHEST_PRECEDENCE
)
public class ApplicationJob {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationJob.class, args);
    }
}
