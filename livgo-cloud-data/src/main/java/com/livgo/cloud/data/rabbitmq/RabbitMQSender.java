package com.livgo.cloud.data.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description: RabbitMQ发送
 * Author:     gaocl
 * Date:       2018/2/23
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Component
public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String key, String content) {
        rabbitTemplate.convertAndSend(key, content);
        System.out.println(" Send : " + key + ":" + content);
    }

}
