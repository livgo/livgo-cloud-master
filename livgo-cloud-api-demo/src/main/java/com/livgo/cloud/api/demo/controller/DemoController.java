package com.livgo.cloud.api.demo.controller;

import com.livgo.cloud.api.demo.config.ApiDemoConfig;
import com.livgo.cloud.api.demo.model.entity.Demo;
import com.livgo.cloud.api.demo.service.DemoService;
import com.livgo.cloud.config.Config;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:
 * Author:     gaocl
 * Date:       2017/12/1
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Api(tags = "Demo")
@RestController
@RequestMapping("demo")
public class DemoController extends BaseController {
    private final static Logger LOG = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private Config config;
    @Autowired
    private ApiDemoConfig webDemoConfig;

    @Autowired
    private DemoService demoService;
    @Value("${hystrix.threadpool.default.coreSize}")
    private int coreSize;

    @ApiOperation("hi1")
    @GetMapping("hi1")
    public String hi1() {
//        LOG.info("WebDemoConfig.key ==========>>" + webDemoConfig.toString());
//        LOG.info("Config.key ==========>>" + config.toString());
        System.out.println("================>test coreSize:" + coreSize);
        return demoService.hi1("hi1");
    }

    @ApiOperation("hi2")
    @PostMapping(value = "hi2", produces = "application/json")
    public String hi2() {
        return demoService.hi2("hi2");
    }

    @ApiOperation("hello1")
    @GetMapping("hello1")
    public String hello1() {
        return demoService.hello1("hello1");
    }


    @ApiOperation("hello2")
    @PostMapping(value = "hello2", produces = "application/json")
    public String hello2() {
        return demoService.hello2("hello2");
    }

    @GetMapping("listDemoLimit")
    public List<Demo> listDemo(int pageNum) {
        return demoService.listDemoLimit(pageNum);
    }

    @GetMapping("listDemoPage")
    public List<Demo> listDemoPage(int pageNum) {
        return demoService.listDemoPage(pageNum);
    }

    @GetMapping("countDemo")
    public int countDemo() {
        return demoService.countDemo();
    }

//    @GetMapping("/config")
//    public String config() {
//        return redisConfig.getIp();
//    }

}
