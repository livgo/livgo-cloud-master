package com.livgo.cloud.gateway.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * Description:
 * Author:     gaocl
 * Date:       2018/2/7
 * Version:    V1.0.0
 * Update:     更新说明
 */
public class PathFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //可以在请求被路由之前调用
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        //TODO 权限过滤条件，排除不需要过滤的
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        //TODO 权限处理
//        String token = request.getHeader("token");
//        if(校验token) {
//            ctx.setSendZuulResponse(true);// 对该请求进行路由
//            ctx.setResponseStatusCode(200);
//            ctx.set("isSuccess", true);// 设值，让下一个Filter看到上一个Filter的状态
//            return null;
//        }else{
//            ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由
//            ctx.setResponseStatusCode(401);// 返回错误码
//            ctx.setResponseBody("{\"result\":\"username is not correct!\"}");// 返回错误内容
//            ctx.set("isSuccess", false);
//            return null;
//        }
        return null;
    }
}
