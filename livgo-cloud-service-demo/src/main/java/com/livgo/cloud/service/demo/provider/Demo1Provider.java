package com.livgo.cloud.service.demo.provider;

import com.livgo.cloud.config.redis.RedisConfig;
import com.livgo.cloud.common.model.bean.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("service-demo-demo1")
public class Demo1Provider {
    private final static Logger LOG = LoggerFactory.getLogger(Demo1Provider.class);

    @Autowired
    private RedisConfig redisConfig;

    @RequestMapping("hi/{name}")
    public ResultBean hi(@PathVariable("name") String name) {

        LOG.info("s1 RedisConfig.key ==========>>" + redisConfig.toString());
        return ResultBean.SUCCESS("Hi, " + name);
    }
}
