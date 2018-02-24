package com.livgo.cloud.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Author:     gaocl
 * Date:       2018/1/26
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Component
public class DemoJob {


    @Scheduled(fixedRate = 1000)
    public void job1() {
        System.out.println("Job1 每秒执行一次");
    }

    @Scheduled(cron = "0/5 * *  * * ? ")
    public void job2() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Job2 每5秒执行一次");

    }

}
