package com.livgo.cloud.gateway.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_RESPONSE_FILTER_ORDER;

/**
 * Description:
 * Author:     gaocl
 * Date:       2018/2/7
 * Version:    V1.0.0
 * Update:     更新说明
 */
public class AddResponseHeaderFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //在route和error过滤器之后被调用
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletResponse servletResponse = context.getResponse();
        servletResponse.addHeader("X-Foo", UUID.randomUUID().toString());
        return null;
    }
}
