package com.livgo.cloud.data.mybatis;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Properties;

/**
 * Description:Mybatis插件
 * Author:     gaocl
 * Date:       2018/1/4
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Component
@Intercepts({
//        @Signature(method = "query", type = Executor.class, args = {
//                MappedStatement.class, Object.class, RowBounds.class,
//                ResultHandler.class }),
        @Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class, Integer.class})})
public class MybatisPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object result = invocation.proceed();
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

}
