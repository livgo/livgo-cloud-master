package com.livgo.cloud.core.swagger;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:Swagger配置信息
 * Author:     gaocl
 * Date:       2018/1/29
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Component
@Data
@ConfigurationProperties(prefix = "swagger")
@PropertySource("classpath:swagger.properties")
public class SwaggerProperties {

    //是否开启swagger
    private Boolean enabled;
    //标题
    private String title = "";
    //描述
    private String description = "";
    //版本
    private String version = "";
    //扫描的包路径
    private String basePackage = "";
    //解析的url规则
    private List<String> basePath = new ArrayList<>();
    //排除的url规则
    private List<String> excludePath = new ArrayList<>();
    //全局参数配置
    private List<GlobalParameters> globalParameters;
    //联系人
    private Contact contact = new Contact();

    @Data
    @NoArgsConstructor
    public static class GlobalParameters {

        //参数名
        private String name;
        //描述信息
        private String description;
        //指定参数类型
        private String modelRef;
        //参数位置:header,query,path,form
        private String parameterType;
        //参数是否必须传
        private String required;

    }

    @Data
    @NoArgsConstructor
    public static class Contact {
        //联系人信息
        private String name = "";
        private String url = "";
        private String email = "";

    }

}


