package com.livgo.cloud.config.server;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.Collections;

/**
 * Description:自定义引导配置来源(数据库等地)
 * Author:     gaocl
 * Date:       2018/2/11
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Configuration
public class CustomPropertySourceLocator implements PropertySourceLocator {

    @Override
    public PropertySource<?> locate(Environment environment) {
        return new MapPropertySource("testProperty",
                Collections.singletonMap("testKey", "testValue"));
    }
}
