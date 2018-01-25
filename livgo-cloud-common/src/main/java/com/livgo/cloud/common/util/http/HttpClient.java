package com.livgo.cloud.common.util.http;

import com.livgo.cloud.common.Const;
import com.livgo.cloud.common.util.lang.UUIDUtil;
import com.livgo.cloud.common.util.log.LogUtil;
import com.livgo.cloud.common.util.valid.ValidUtil;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Description: HttpClient 工具类
 * Author:      gaocl
 * Date:        2017/12/21
 * Version:     V1.0.0
 * Update:      更新说明
 */
public final class HttpClient {
    private final static Logger logger = LoggerFactory.getLogger(HttpClient.class);

    private final static int CONNECT_TIMEOUT = 10000;//连接超时时间（ms）
    private final static int READ_TIMEOUT = 60000;//读写超时时间（ms）
    private final static String POST = "POST";
    private final static String GET = "GET";
    private static RequestConfig requestConfig = null;

    static {
        requestConfig = RequestConfig.custom()
                .setSocketTimeout(CONNECT_TIMEOUT)
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setConnectionRequestTimeout(READ_TIMEOUT)
                .build();
    }


    /**
     * HTTP Client GET
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String get(String url) throws Exception {

        String responseBody = "";
        CloseableHttpClient httpclient;
        httpclient = HttpClients.createDefault();
        try {

            HttpGet httpget = new HttpGet(url);
            httpget.setConfig(requestConfig);
            responseBody = httpclient.execute(httpget, createResponseHandler());

        } finally {
            httpclient.close();
        }

        return responseBody;
    }


    /**
     * HttpClient POST
     *
     * @param url
     * @param params NameValuePair params
     * @return
     * @throws Exception
     */
    public static String post(String url, List<NameValuePair> params)
            throws Exception {

        String responseBody = "";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(params, Const.ENCODE));
            responseBody = httpclient.execute(httpPost, createResponseHandler());

        } finally {
            httpclient.close();
        }

        return responseBody;
    }

    /**
     * HttpClient POST
     * <p>
     * gaocl
     *
     * @param url 请求地址
     * @param map 请求参数-map类型
     * @return 响应字符串
     * @throws Exception
     */
    public static String post(String url, Map<String, String> map)
            throws Exception {

        String responseBody = "";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {

            HttpPost httpPost = new HttpPost(url);

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }

            httpPost.setEntity(new UrlEncodedFormEntity(params, Const.ENCODE));
            responseBody = httpclient.execute(httpPost, createResponseHandler());

        } finally {
            httpclient.close();
        }

        return responseBody;
    }

    /**
     * HttpClient POST
     *
     * @param url
     * @param param key1=value1&key2=value2
     * @return
     * @throws Exception
     */
    public static String post(String url, String param) throws Exception {

        String responseBody = "";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new StringEntity(param));
            responseBody = httpclient.execute(httpPost, createResponseHandler());

        } finally {
            httpclient.close();
        }

        return responseBody;
    }

    private static ResponseHandler<String> createResponseHandler() throws Exception {
        ResponseHandler<String> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity, Const.ENCODE) : null;
            } else {
                throw new ClientProtocolException("Response Error Status: " + status);
            }
        };
        return responseHandler;
    }

    /**
     * URLConnection GET
     *
     * @param url
     * @return
     */
    public static String getConn(String url) throws Exception {

        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod(GET);
        conn.setConnectTimeout(CONNECT_TIMEOUT);
        conn.setReadTimeout(READ_TIMEOUT);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setUseCaches(false);

        int status = conn.getResponseCode();
        if (status >= 200 && status < 300) {
            return readStream(conn.getInputStream());
        } else {
            LogUtil.error(logger, readStream(conn.getErrorStream()));
            throw new ClientProtocolException("Response Error Status: " + status);
        }
    }

    /**
     * URLConnection POST
     *
     * @param url
     * @return
     */
    public static String postConn(String url, String param) throws Exception {

        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod(POST);
        conn.setConnectTimeout(CONNECT_TIMEOUT);
        conn.setReadTimeout(READ_TIMEOUT);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setUseCaches(false);
        if (param != null && !"".equals(param)) {
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            out.write(param.getBytes(Const.ENCODE));
            out.flush();
            out.close();
        }

        int status = conn.getResponseCode();
        if (status >= 200 && status < 300) {
            return readStream(conn.getInputStream());
        } else {
            LogUtil.error(logger, readStream(conn.getErrorStream()));
            throw new ClientProtocolException("Response Error Status: " + status);
        }
    }


    private static String readStream(InputStream inputStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inputStream.close();
        return new String(outStream.toByteArray(), Const.ENCODE);
    }


    /**
     * 文件上传
     *
     * @param path
     * @param is
     * @param fileName
     * @return
     */
    public static String upload(String path, InputStream is, String fileName) throws Exception {
        String responseBody = null;
        String BOUNDARY = "---------" + UUIDUtil.get32UUID(); // 定义数据分隔线
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.setConnectTimeout(CONNECT_TIMEOUT);
        conn.setReadTimeout(READ_TIMEOUT);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("Charsert", Const.ENCODE);
        conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

        OutputStream out = new DataOutputStream(conn.getOutputStream());
        byte[] end_data = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();// 定义最后数据分隔线
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(BOUNDARY);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data;name=\"upload\";filename=\"" + fileName + "\"\r\n");
        sb.append("Content-Type:application/octet-stream\r\n\r\n");
        byte[] data = sb.toString().getBytes();
        out.write(data);
        //DataInputStream in = new DataInputStream(new FileInputStream(file));
        DataInputStream in = new DataInputStream(is);
        int bytes = 0;
        byte[] bufferOut = new byte[1024];
        while ((bytes = in.read(bufferOut)) != -1) {
            out.write(bufferOut, 0, bytes);
        }
        in.close();
        out.write(end_data);
        out.flush();
        out.close();

        responseBody = readStream(conn.getResponseCode() == 200 ? conn.getInputStream() : conn.getErrorStream());

        return responseBody;
    }

    /**
     * 创建一个有参的URL
     *
     * @param url    URL
     * @param params 参数
     * @return 返回带参的url
     */
    public static String createUrl(String url, Map<String, Object> params) {
        boolean flag = url.contains("?");
        StringBuilder newUrl = new StringBuilder(url);
        if (ValidUtil.isNotEmpty(params)) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (!flag) {
                    newUrl.append("?");
                    flag = true;
                } else {
                    newUrl.append("&");
                }
                newUrl.append(entry.getKey().concat("=").concat(entry.getValue().toString()));
            }
        }
        return newUrl.toString();
    }


}
