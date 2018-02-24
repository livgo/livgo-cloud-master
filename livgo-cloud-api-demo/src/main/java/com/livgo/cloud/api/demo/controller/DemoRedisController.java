package com.livgo.cloud.api.demo.controller;

import com.livgo.cloud.common.util.log.LogUtil;
import com.livgo.cloud.data.redis.RedisHelper;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@Api(tags = "Redis Demo")
@RestController
@RequestMapping("redis")
@RefreshScope
public class DemoRedisController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(DemoRedisController.class);

    @Autowired
    private RedisHelper redisHelper;

    @GetMapping("redis/set")
    public void redis(String key, String value) {
        LogUtil.info(logger, String.format("redis set :key=%s,value=%s", key, value));
        redisHelper.set(key, value);
    }

    @GetMapping("redis/get")
    public String redis(String key) {
        LogUtil.info(logger, String.format("redis get :key=%s", key));
        return redisHelper.get(key);
    }

}
