package com.livgo.cloud.api.demo.controller;

import com.livgo.cloud.api.demo.config.ApiDemoConfig;
import com.livgo.cloud.api.demo.service.DemoService;
import com.livgo.cloud.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author:     gaocl
 * Date:       2017/12/1
 * Version:    V1.0.0
 * Update:     更新说明
 */
@RestController
@RequestMapping("demo")
public class DemoController extends BaseController{
    private final static Logger LOG = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private Config config;
    @Autowired
    private ApiDemoConfig webDemoConfig;

    @Autowired
    private DemoService demoService;

    @GetMapping("hello")
    public String hello() {
        LOG.info("WebDemoConfig.key ==========>>" + webDemoConfig.toString());
        LOG.info("Config.key ==========>>" + config.toString());
        return demoService.hello("World");
    }

//    @GetMapping("/config")
//    public String config() {
//        return redisConfig.getIp();
//    }

}
