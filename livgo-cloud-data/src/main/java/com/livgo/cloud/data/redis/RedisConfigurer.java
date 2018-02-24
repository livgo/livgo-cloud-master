//package com.livgo.cloud.data.redis;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//
///**
// * Description:
// * Author:     gaocl
// * Date:       2018/2/23
// * Version:    V1.0.0
// * Update:     更新说明
// */
//@Configuration
//@EnableCaching
//@RefreshScope
//public class RedisConfigurer extends CachingConfigurerSupport {
//    @Autowired
//    private RedisProperties redisProperties;
//
//    /**
//     * 生产key的策略
//     *
//     * @return
//     */
//    @Bean
//    @Override
//    public KeyGenerator keyGenerator() {
//        return (target, method, params) -> {
//            StringBuilder sb = new StringBuilder();
//            sb.append(target.getClass().getName());
//            sb.append(method.getName());
//            for (Object obj : params) {
//                sb.append(obj.toString());
//            }
//            return sb.toString();
//        };
//
//    }
//
//    @SuppressWarnings("rawtypes")
//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
//        return rcm;
//    }
//
//    @Bean
//    public JedisConnectionFactory redisConnectionFactory() {
////        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
////        jedisPoolConfig.setMaxIdle(redisProperties.getPool().getMaxIdle());
////        jedisPoolConfig.setMinIdle(redisProperties.getPool().getMinIdle());
////        jedisPoolConfig.setMaxWaitMillis(redisProperties.getPool().getMaxWait());
//        JedisConnectionFactory factory = new JedisConnectionFactory();
//        factory.setDatabase(redisProperties.getDatabase());
//        factory.setHostName(redisProperties.getHost());
//        factory.setPort(redisProperties.getPort());
//        factory.setTimeout(redisProperties.getTimeout()); // 设置连接超时时间
//
//
//        return factory;
//    }
//
//    /**
//     * redisTemplate配置
//     *
//     * @param factory
//     * @return
//     */
//    @SuppressWarnings({"rawtypes", "unchecked"})
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        StringRedisTemplate template = new StringRedisTemplate(factory);
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//        return template;
//    }
//
//}
