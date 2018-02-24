package com.livgo.cloud.config.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Description:Kafka config
 * Author:     gaocl
 * Date:       2017/12/1
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "kafka")
public class KafkaConfig implements Serializable {
    private final static long serialVersionUID = 1L;
    private String key;

}
