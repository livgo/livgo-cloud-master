package com.livgo.cloud.service.demo.provider;

import com.livgo.cloud.config.kafka.KafkaConfig;
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
@RequestMapping("service-demo-demo2")
public class Demo2Provider {
    private final static Logger LOG = LoggerFactory.getLogger(Demo2Provider.class);

    @Autowired
    private KafkaConfig kafkaConfig;

    @RequestMapping("hello/{name}")
    public ResultBean hello(@PathVariable("name") String name) {
        LOG.info("s1 KafkaConfig.key ==========>>" + kafkaConfig.toString());
        return ResultBean.SUCCESS("Hello, " + name);
    }
}
