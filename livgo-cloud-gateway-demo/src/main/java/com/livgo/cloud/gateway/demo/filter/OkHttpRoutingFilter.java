//package com.livgo.cloud.gateway.demo.filter;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import javax.servlet.http.HttpServletRequest;
//
//import java.io.InputStream;
//import java.util.Enumeration;
//
//import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ROUTE_TYPE;
//import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SIMPLE_HOST_ROUTING_FILTER_ORDER;
//
///**
// * Description:
// * Author:     gaocl
// * Date:       2018/2/7
// * Version:    V1.0.0
// * Update:     更新说明
// */
//public class OkHttpRoutingFilter extends ZuulFilter {
//    @Autowired
//    private ProxyRequestHelper helper;
//
//    @Override
//    public String filterType() {
//        return ROUTE_TYPE;
//    }
//
//    @Override
//    public int filterOrder() {
//        return SIMPLE_HOST_ROUTING_FILTER_ORDER - 1;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return RequestContext.getCurrentContext().getRouteHost() != null
//                && RequestContext.getCurrentContext().sendZuulResponse();
//    }
//
//    @Override
//    public Object run() {
//        OkHttpClient httpClient = new OkHttpClient.Builder()
//                // customize
//                .build();
//
//        RequestContext context = RequestContext.getCurrentContext();
//        HttpServletRequest request = context.getRequest();
//
//        String method = request.getMethod();
//
//        String uri = this.helper.buildZuulRequestURI(request);
//
//        Headers.Builder headers = new Headers.Builder();
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String name = headerNames.nextElement();
//            Enumeration<String> values = request.getHeaders(name);
//
//            while (values.hasMoreElements()) {
//                String value = values.nextElement();
//                headers.add(name, value);
//            }
//        }
//
//        InputStream inputStream = request.getInputStream();
//
//        RequestBody requestBody = null;
//        if (inputStream != null && HttpMethod.permitsRequestBody(method)) {
//            MediaType mediaType = null;
//            if (headers.get("Content-Type") != null) {
//                mediaType = MediaType.parse(headers.get("Content-Type"));
//            }
//            requestBody = RequestBody.create(mediaType, StreamUtils.copyToByteArray(inputStream));
//        }
//
//        Request.Builder builder = new Request.Builder()
//                .headers(headers.build())
//                .url(uri)
//                .method(method, requestBody);
//
//        Response response = httpClient.newCall(builder.build()).execute();
//
//        LinkedMultiValueMap<String, String> responseHeaders = new LinkedMultiValueMap<>();
//
//        for (Map.Entry<String, List<String>> entry : response.headers().toMultimap().entrySet()) {
//            responseHeaders.put(entry.getKey(), entry.getValue());
//        }
//
//        this.helper.setResponse(response.code(), response.body().byteStream(),
//                responseHeaders);
//        context.setRouteHost(null); // prevent SimpleHostRoutingFilter from running
//        return null;
//    }
//}
