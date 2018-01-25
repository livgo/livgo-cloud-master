package com.livgo.cloud.service.demo.api.consumer;

import com.livgo.cloud.common.model.bean.ResultBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description:
 * Author:     gaocl
 * Date:       2017/12/1
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Component
@FeignClient(name = "service-demo", fallbackFactory = Demo1ConsumerFallbackFactory.class)
@RequestMapping("service-demo-demo1")
public interface Demo1Consumer {

//    @RequestLine("GET /hi/{name}")
    @RequestMapping(value = "hi/{name}", method = RequestMethod.GET)
    public ResultBean hi(@PathVariable("name") String name);

//    @HystrixCommand(fallbackMethod = "")
//    @HystrixProperty
    @RequestMapping(value = "hi1/{name}", method = RequestMethod.GET)
    public ResultBean hi1(@PathVariable("name") String name);
}