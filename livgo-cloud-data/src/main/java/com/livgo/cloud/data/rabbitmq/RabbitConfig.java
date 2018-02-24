package com.livgo.cloud.data.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Description:
 * Author:     gaocl
 * Date:       2018/2/23
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue1() {
        return new Queue("queue1");
    }

    @Bean
    public Queue queue2() {
        return new Queue("queue2");
    }

}
