package com.livgo.cloud.api.demo.controller;

import com.livgo.cloud.data.rabbitmq.RabbitMQSender;
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
@Api(tags = "RabbitMQ Demo")
@RestController
@RequestMapping("rabbitmq")
@RefreshScope
public class DemoRabbitMQController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(DemoRabbitMQController.class);

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @GetMapping("send")
    public void send(String key, String value) {
        rabbitMQSender.send(key, value);
    }

}
