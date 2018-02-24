package com.livgo.cloud.gateway.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

/**
 * Description:
 * Author:     gaocl
 * Date:       2018/2/7
 * Version:    V1.0.0
 * Update:     更新说明
 */
public class QueryParamPreFilter extends ZuulFilter {
    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1; // run before PreDecoration
    }

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return !ctx.containsKey(FORWARD_TO_KEY) // a filter has already forwarded
                && !ctx.containsKey(SERVICE_ID_KEY); // a filter has already determined serviceId
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if (request.getParameter("foo") != null) {
            // put the serviceId in `RequestContext`
            ctx.put(SERVICE_ID_KEY, request.getParameter("foo"));
        }
        return null;
    }
}
