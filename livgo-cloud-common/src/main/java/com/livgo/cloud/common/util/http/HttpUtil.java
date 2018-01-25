package com.livgo.cloud.common.util.http;


import com.livgo.cloud.common.util.valid.ValidUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: Http 工具类
 * Author:     gaocl
 * Date:       2017/12/21
 * Version:    V1.0.0
 * Update:     更新说明
 */
public final class HttpUtil {


    /**
     * 获得Real IP地址
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (ValidUtil.isEmpty(ip)) {
            ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        }

        if (!ValidUtil.isEmpty(ip)) {
            ip = ip.split(",")[0];
        }
        return ip;
    }

    /**
     * 获取UserAgent
     *
     * @param request
     * @return
     */
    public static String getUserAgent(HttpServletRequest request) {
        if (request == null)
            return null;
        return request.getHeader("User-Agent");
    }


    /**
     * 获取Header里指定信息
     *
     * @param request
     * @return
     */
    public static String getHeader(HttpServletRequest request, String key) {
        if (request == null)
            return null;
        return request.getHeader(key);
    }

    /**
     * 获取来源
     *
     * @param request
     * @return
     */
    public static String getReferer(HttpServletRequest request) {
        if (request == null)
            return null;
        return request.getHeader("referer");
    }

    /**
     * URL编码
     *
     * @param str
     * @return
     */
    public static String escape(String str) {
        int i;
        char j;
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(str.length() * 6);
        for (i = 0; i < str.length(); i++) {
            j = str.charAt(i);
            if (Character.isDigit(j) || Character.isLowerCase(j)
                    || Character.isUpperCase(j))
                tmp.append(j);
            else if (j < 256) {
                tmp.append("%");
                if (j < 16)
                    tmp.append("0");
                tmp.append(Integer.toString(j, 16));
            } else {
                tmp.append("%u");
                tmp.append(Integer.toString(j, 16));
            }
        }
        return tmp.toString();
    }

    /**
     * URL解码
     *
     * @param str
     * @return
     */
    public static String unescape(String str) {
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(str.length());
        int lastPos = 0, pos = 0;
        char ch;
        while (lastPos < str.length()) {
            pos = str.indexOf("%", lastPos);
            if (pos == lastPos) {
                if (str.charAt(pos + 1) == 'u') {
                    ch = (char) Integer.parseInt(str
                            .substring(pos + 2, pos + 6), 16);
                    tmp.append(ch);
                    lastPos = pos + 6;
                } else {
                    ch = (char) Integer.parseInt(str
                            .substring(pos + 1, pos + 3), 16);
                    tmp.append(ch);
                    lastPos = pos + 3;
                }
            } else {
                if (pos == -1) {
                    tmp.append(str.substring(lastPos));
                    lastPos = str.length();
                } else {
                    tmp.append(str.substring(lastPos, pos));
                    lastPos = pos;
                }
            }
        }
        return tmp.toString();
    }

    /**
     * HTML标签转义
     * <p>
     * 空格	 &nbsp;
     * <	小于号	&lt;
     * >	大于号	&gt;
     * &	和号	    &amp;
     * "	引号	    &quot;
     * '	撇号 	&apos;
     * ￠	分	    &cent;
     * £	镑	    &pound;
     * ¥	日圆	    &yen;
     * €	欧元	    &euro;
     * §	小节	    &sect;
     * ©	版权	    &copy;
     * ®	注册商标	&reg;
     * ™	商标	    &trade;
     * ×	乘号	    &times;
     * ÷	除号	    &divide;
     *
     * @param content
     * @return
     */
    public static String unhtml(String content) {
        if (ValidUtil.isEmpty(content)) {
            return "";
        }
        String html = content;
        html = html.replaceAll("'", "&apos;");
        html = html.replaceAll("\"", "&quot;");
        html = html.replaceAll("\t", "&nbsp;&nbsp;");// 替换跳格
        html = html.replaceAll("<", "&lt;");
        html = html.replaceAll(">", "&gt;");
        return html;
    }

    /**
     * 转成HTML
     *
     * @param content
     * @return
     */
    public static String html(String content) {
        if (ValidUtil.isEmpty(content)) {
            return "";
        }
        String html = content;
        html = html.replaceAll("&apos;", "'");
        html = html.replaceAll("&quot;", "\"");
        html = html.replaceAll("&nbsp;", " ");// 替换跳格
        html = html.replaceAll("&lt;", "<");
        html = html.replaceAll("&gt;", ">");
        return html;
    }

}
