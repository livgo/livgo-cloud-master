package com.livgo.cloud.sys.boot.admin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Description:系统集成与监控
 * Author:     gaocl
 * Date:       2017/12/08
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableAdminServer
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableTurbine
public class ApplicationSysBootAdmin {
    public static ApplicationContext APPLICATION_CONTEXT;

    public static void main(String[] args) {
        APPLICATION_CONTEXT = SpringApplication.run(ApplicationSysBootAdmin.class, args);
    }

    @Configuration
    public static class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").permitAll();
            http.logout().logoutUrl("/logout");
            http.csrf().disable();
            http.authorizeRequests()
                    .antMatchers("/api/**", "/**/*.html", "/login.html", "/**/*.css", "/img/**", "/third-party/**")
                    .permitAll();
            http.authorizeRequests().antMatchers("/**").authenticated();
            http.httpBasic();
        }
    }
//
//    @Configuration
//    public static class NotifierConfig {
//        @Bean
//        @Primary
//        public RemindingNotifier remindingNotifier() {
//            RemindingNotifier notifier = new RemindingNotifier(filteringNotifier(loggerNotifier()));
//            notifier.setReminderPeriod(TimeUnit.SECONDS.toMillis(10));
//            return notifier;
//        }
//
//        @Scheduled(fixedRate = 1_000L)
//        public void remind() {
//            remindingNotifier().sendReminders();
//        }
//
//        @Bean
//        public FilteringNotifier filteringNotifier(Notifier delegate) {
//            return new FilteringNotifier(delegate);
//        }
//
//        @Bean
//        public LoggingNotifier loggerNotifier() {
//            return new LoggingNotifier();
//        }
//    }
}
