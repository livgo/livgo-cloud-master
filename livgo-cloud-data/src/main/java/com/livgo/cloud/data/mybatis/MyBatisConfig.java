//package com.livgo.cloud.data.mybatis;
//
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
///**
// * Description:Mybatis配置
// * Author:     gaocl
// * Date:       2018/1/4
// * Version:    V1.0.0
// * Update:     更新说明
// */
//@Configuration
//@EnableTransactionManagement
//public class MyBatisConfig {
//
//    @Autowired
//    private DataSource dataSource;
//    @Autowired
//    private MybatisPlugin mybatisPlugin;
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
////        sessionFactory.setDataSource(roundRobinDataSouceProxy());
////        sqlSessionFactoryBean.setConfigLocation();
////        sqlSessionFactoryBean.setTypeHandlersPackage();
////        sqlSessionFactoryBean.setTypeAliasesPackage("");
////        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
////        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mappers/*.xml"));
//        sqlSessionFactoryBean.setPlugins(new Interceptor[]{mybatisPlugin});
//        return sqlSessionFactoryBean.getObject();
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    //读写分离使用
////    @Resource(name="writeDataSource")
////    private DataSource writeDataSource;
////
////    @Resource(name="readDataSources")
////    private List<Object> readDataSources;
////    @Bean
////    public RoundRobinRWRoutingDataSourceProxy roundRobinDataSouceProxy(){
////        RoundRobinRWRoutingDataSourceProxy proxy = new RoundRobinRWRoutingDataSourceProxy();
////        proxy.setWriteDataSource(writeDataSource);
////        proxy.setReadDataSoures(readDataSources);
////        proxy.setReadKey("READ");
////        proxy.setWriteKey("WRITE");
////
////        return proxy;
////    }
////
////    @Bean
////    @ConditionalOnMissingBean
////    public DataSourceTransactionManager transactionManager() {
////        return new DataSourceTransactionManager(writeDataSource);
////    }
//}
