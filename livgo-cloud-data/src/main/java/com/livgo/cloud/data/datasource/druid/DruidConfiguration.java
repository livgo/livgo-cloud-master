package com.livgo.cloud.data.datasource.druid;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:Druid配置
 * Author:     gaocl
 * Date:       2018/2/22
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Configuration
public class DruidConfiguration {
    @Autowired
    private DruidMonitorProperties druidMonitorProperties;

    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        System.out.println("druidStatViewServlet druidMonitorProperties:"+druidMonitorProperties);
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //白名单
        servletRegistrationBean.addInitParameter("allow", druidMonitorProperties.getAllow());
        //IP黑名单,优先于allow
        servletRegistrationBean.addInitParameter("deny", druidMonitorProperties.getDeny());
        servletRegistrationBean.addInitParameter("loginUsername", druidMonitorProperties.getLoginUsername());
        servletRegistrationBean.addInitParameter("loginPassword", druidMonitorProperties.getLoginPassword());
        servletRegistrationBean.addInitParameter("resetEnable", druidMonitorProperties.getResetEnable());

        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean druidStatFilter() {

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns(druidMonitorProperties.getUrlPatterns());
        filterRegistrationBean.addInitParameter("exclusions", druidMonitorProperties.getExclusions());

        return filterRegistrationBean;
    }

}
