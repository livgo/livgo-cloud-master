package com.livgo.cloud.sys.hystrix.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Description:服务监控仪表盘
 * Author:     gaocl
 * Date:       2017/12/08
 * Version:    V1.0.0
 * Update:     更新说明
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableTurbine
public class ApplicationSysHystrixMonitor {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationSysHystrixMonitor.class, args);
    }

//    @Configuration
//    public static class SecurityConfig extends WebSecurityConfigurerAdapter {
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
////            http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").permitAll();
////            http.logout().logoutUrl("/logout");
//            http.csrf().disable();
//            http.authorizeRequests()
//                    .antMatchers("/info","/metrics","/health", "/**/*.css", "/img/**","/login/**")
//                    .permitAll();
//            http.authorizeRequests().antMatchers("/**").authenticated();
//            http.httpBasic();
//        }
//    }
}
