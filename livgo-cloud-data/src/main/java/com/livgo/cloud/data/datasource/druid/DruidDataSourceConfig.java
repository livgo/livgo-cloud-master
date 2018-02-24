//package com.livgo.cloud.data.datasource.druid;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.PreDestroy;
//import javax.sql.DataSource;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
///**
// * Description:连接池配置
// * Author:     gaocl
// * Date:       2018/1/4
// * Version:    V1.0.0
// * Update:     更新说明
// */
//@Configuration
//@EnableConfigurationProperties(DruidPoolDataSourceProperties.class)
//public class DruidDataSourceConfig extends DruidDataSource {
//
//    private Logger logger = Logger.getLogger(getClass());
//    private static final long serialVersionUID = 1L;
//
//    @Autowired
//    private DruidPoolDataSourceProperties druidPoolDataSourceProperties;
//
//    private DruidDataSource pool;
//
//    @Bean(destroyMethod = "close", name = "dataSource")
//    public DataSource dataSource() {
//
//        DruidPoolDataSourceProperties config = druidPoolDataSourceProperties;
//
//        this.pool = new DruidDataSource();
//        this.pool.setDriverClassName(config.getJdbcDriver());
//        this.pool.setUrl(config.getJdbcUrl());
//        if (config.getJdbcUser() != null) {
//            this.pool.setUsername(config.getJdbcUser());
//        }
//        if (config.getJdbcPassword() != null) {
//            this.pool.setPassword(config.getJdbcPassword());
//        }
//        this.pool.setInitialSize(config.getJdbcInitialPoolSize());
//        this.pool.setMaxActive(config.getJdbcMaxActive());
//        this.pool.setMaxIdle(config.getJdbcMaxIdle());
//        this.pool.setMinIdle(config.getJdbcMinIdle());
//        this.pool.setTestOnBorrow(config.isTestOnBorrow());
//        this.pool.setTestOnReturn(config.isTestOnReturn());
//        this.pool.setValidationQuery(config.getValidationQuery());
//        return this.pool;
//    }
//
//    @PreDestroy
//    public void close() {
//        try {
//            logger.info("开始注销数据库驱动!");
//            DriverManager.deregisterDriver(DriverManager.getDriver(getUrl()));
//            super.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
////    @Bean(name="writeDataSource", destroyMethod = "close", initMethod="init")
////    @Primary
////    public DataSource writeDataSource() {
////        DruidDataSource datasource = new DruidDataSource();
////        datasource.setUrl(propertyResolver.getProperty("url"));
////        datasource.setDriverClassName(propertyResolver.getProperty("driverClassName"));
////        datasource.setUsername(propertyResolver.getProperty("username"));
////        datasource.setPassword(propertyResolver.getProperty("password"));
////
////        return datasource;
////    }
////
////    @Bean(name="readOneDataSource", destroyMethod = "close", initMethod="init")
////    public DataSource readOneDataSource() {
////        DruidDataSource datasource = new DruidDataSource();
////        datasource.setUrl(propertyResolver.getProperty("url"));
////        datasource.setDriverClassName(propertyResolver.getProperty("driverClassName"));
////        datasource.setUsername(propertyResolver.getProperty("username"));
////        datasource.setPassword(propertyResolver.getProperty("password"));
////
////        return datasource;
////    }
////
////    @Bean(name="readTowDataSource", destroyMethod = "close", initMethod="init")
////    public DataSource readTowDataSource() {
////        DruidDataSource datasource = new DruidDataSource();
////        datasource.setUrl(propertyResolver.getProperty("url"));
////        datasource.setDriverClassName(propertyResolver.getProperty("driverClassName"));
////        datasource.setUsername(propertyResolver.getProperty("username"));
////        datasource.setPassword(propertyResolver.getProperty("password"));
////
////        return datasource;
////    }
////
////
////    @Bean(name="readDataSources")
////    public List<DataSource> readDataSources(){
////        List<DataSource> dataSources = new ArrayList<DataSource>();
////        dataSources.add(readOneDataSource());
////        dataSources.add(readTowDataSource());
////        return dataSources;
////    }
//
//
//}
