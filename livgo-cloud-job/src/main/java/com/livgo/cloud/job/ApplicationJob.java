package com.livgo.cloud.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.core.Ordered;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;

/**
 * Description:Job系统
 * Author:     gaocl
 * Date:       2017/12/14
 * Version:    V1.0.0
 * Update:     更新说明
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync(
        mode = AdviceMode.PROXY, proxyTargetClass = false,
        order = Ordered.HIGHEST_PRECEDENCE
)
public class ApplicationJob {
    private final static Logger LOG = LoggerFactory.getLogger(ApplicationJob.class);

    public static void main(String[] args) {
        SpringApplication.run(ApplicationJob.class, args);
    }

}
