package com.livgo.cloud.data.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Description:RabbitMQ接收
 * Author:     gaocl
 * Date:       2018/2/23
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Component
public class RabbitMQReciever {

    @RabbitHandler
    @RabbitListener(queues = "queue1")
    public void processQueue1(String content) {
        //处理内容
        System.out.println("queue1 Receiver : " + content);
    }

    @RabbitHandler
    @RabbitListener(queues = "queue2")
    public void processQueue2(String content) {
        //处理内容
        System.out.println("queue2 Receiver : " + content);
    }


}
