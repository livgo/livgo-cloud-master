package com.livgo.cloud.data.datasource.druid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Description:
 * Author:     gaocl
 * Date:       2017/12/1
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "druid.view")
public class DruidMonitorProperties implements Serializable {
    private final static long serialVersionUID = 1L;
    private String allow;
    private String deny;
    private String loginUsername;
    private String loginPassword;
    private String resetEnable;
    private String urlPatterns;
    private String exclusions;


}
