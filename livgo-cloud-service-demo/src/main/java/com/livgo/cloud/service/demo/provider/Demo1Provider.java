package com.livgo.cloud.service.demo.provider;

import com.livgo.cloud.common.model.bean.ResultBean;
import com.livgo.cloud.common.util.log.LogUtil;
import com.livgo.cloud.config.redis.RedisConfig;
import com.livgo.cloud.service.demo.config.ServiceDemoConfig;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author:     gaocl
 * Date:       2017/12/1
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Api("Demo1Provider")
@RestController
@RequestMapping("service-demo-demo1")
public class Demo1Provider {
    private final static Logger logger = LoggerFactory.getLogger(Demo1Provider.class);

    @Autowired
    private RedisConfig redisConfig;
    @Autowired
    private RabbitProperties rabbitProperties;
    @Autowired
    private ServiceDemoConfig serviceDemoConfig;

    @RequestMapping("hi1/{name}")
    public ResultBean hi1(@PathVariable("name") String name) {
        LogUtil.info(logger, "hi1 ==========>>" + name);
        return ResultBean.SUCCESS("Hi, " + name +
                ",redis:" + redisConfig.toString() +
                ",rabbit:" + rabbitProperties.getHost() +
                ",s1 key:" + serviceDemoConfig.getKey1()
        );
    }

    @RequestMapping("hi2/{name}")
    public ResultBean hi2(@PathVariable("name") String name) {
        LogUtil.info(logger, "hi2 ==========>>" + name);
        int i = 1 / 0;
        return ResultBean.SUCCESS("Hi, " + name +
                ",redis:" + redisConfig.toString() +
                ",rabbit:" + rabbitProperties.getHost() +
                ",s1 key:" + serviceDemoConfig.getKey1()
        );
    }
}
