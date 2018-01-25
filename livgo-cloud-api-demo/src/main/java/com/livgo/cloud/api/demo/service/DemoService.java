package com.livgo.cloud.api.demo.service;

import com.livgo.cloud.service.demo.api.consumer.Demo1Consumer;
import com.livgo.cloud.service.demo.api.consumer.Demo2Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Author:     gaocl
 * Date:       2017/12/1
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Service
public class DemoService {

    @Autowired
    private Demo1Consumer demo1Consumer;
    @Autowired
    private Demo2Consumer demo2Consumer;


    public String hello(String name) {
        return demo1Consumer.hi(name) + "\n" + demo2Consumer.hello(name);
    }

}
