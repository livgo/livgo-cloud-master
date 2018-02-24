package com.livgo.cloud.common.util.http;

import org.junit.Test;

/**
 * Description:
 * Author:     gaocl
 * Date:       2017/12/21
 * Version:    V1.0.0
 * Update:     更新说明
 */
public class HttpClientTest {

    private static String url = "http://www.baidu.com";

    @Test
    public void get() throws Exception {
        System.out.println(HttpClient.get(url));
    }

    @Test
    public void getConn() throws Exception {
        System.out.println(HttpClient.getConn(url));
    }

    @Test
    public void post() throws Exception {
        System.out.println(HttpClient.post(url, "ddd"));
    }


}
