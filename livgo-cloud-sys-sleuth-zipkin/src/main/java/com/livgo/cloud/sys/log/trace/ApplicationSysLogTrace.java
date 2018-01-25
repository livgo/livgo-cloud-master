package com.livgo.cloud.sys.log.trace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * Description:全系统日志跟踪（Sleuth,Zipkin）
 * Author:     gaocl
 * Date:       2017/12/08
 * Version:    V1.0.0
 * Update:     更新说明
 */
@SpringBootApplication
@EnableZipkinStreamServer
public class ApplicationSysLogTrace {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationSysLogTrace.class, args);
    }
}
