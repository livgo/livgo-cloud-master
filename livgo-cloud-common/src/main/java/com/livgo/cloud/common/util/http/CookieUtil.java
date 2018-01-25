package com.livgo.cloud.common.util.http;


import com.livgo.cloud.common.Const;
import com.livgo.cloud.common.util.log.LogUtil;
import com.livgo.cloud.common.util.valid.ValidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:Cookie工具类
 * IE和Chrome内核的浏览器会认为http://localhost为无效的域名 不保存cookie，需在火狐上测试本地， 或改为127.0.0.1
 * Author:     gaocl
 * Date:       2017/12/21
 * Version:    V1.0.0
 * Update:     更新说明
 */
public final class CookieUtil {
    private final static Logger logger = LoggerFactory.getLogger(CookieUtil.class);

    // Cookie 有效期（s）
    public final static int COOKIE_MAXAGE = 7 * 24 * 60 * 60;//一周

    /**
     * 添加Cookie
     *
     * @param response
     * @param name     Key
     * @param value    Value
     */
    public static void addCookie(HttpServletResponse response, String name, String value) {

        try {
            if (!ValidUtil.isEmpty(value)) {
                value = URLEncoder.encode(value, Const.ENCODE);
            }
        } catch (UnsupportedEncodingException e) {
            LogUtil.error(logger, e);
        }
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(COOKIE_MAXAGE);
        response.addCookie(cookie);

    }

    /**
     * 添加Cookie并设置有效期
     *
     * @param response
     * @param name     Key
     * @param value    Value
     * @param maxAge   有效期（秒）
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        try {
            if (!ValidUtil.isEmpty(value)) {
                value = URLEncoder.encode(value, Const.ENCODE);
            }
        } catch (UnsupportedEncodingException e) {
            LogUtil.error(logger, e);
        }
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if (maxAge > 0) cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 删除Cookie
     *
     * @param request
     * @param response
     * @param name     Cookie Key
     */
    public static void delCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
        }
    }

    /**
     * 更新Cookie
     *
     * @param request
     * @param response
     * @param name     Key
     * @param newValue 新值
     */
    public static void updCookie(HttpServletRequest request, HttpServletResponse response, String name, String newValue) {
        try {
            if (!ValidUtil.isEmpty(newValue)) {
                newValue = URLEncoder.encode(newValue, Const.ENCODE);
            }
        } catch (UnsupportedEncodingException e) {
            LogUtil.error(logger, e);
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    cookie.setValue(newValue);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }

    /**
     * 更新Cookie
     *
     * @param request
     * @param response
     * @param name     Key
     * @param newValue 新值
     * @param maxAge   有效期（秒）
     */
    public static void updCookie(HttpServletRequest request, HttpServletResponse response, String name, String newValue, int maxAge) {
        try {
            if (!ValidUtil.isEmpty(newValue)) {
                newValue = URLEncoder.encode(newValue, Const.ENCODE);
            }
        } catch (UnsupportedEncodingException e) {
            LogUtil.error(logger, e);
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    cookie.setValue(newValue);
                    cookie.setPath("/");
                    if (maxAge > 0) cookie.setMaxAge(maxAge);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }

    /**
     * 更新Cookie有效期
     *
     * @param request
     * @param response
     * @param name     Key
     * @param maxAge   有效期（秒）
     */
    public static void updCookieMaxAge(HttpServletRequest request, HttpServletResponse response, String name, int maxAge) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    cookie.setPath("/");
                    if (maxAge > 0) cookie.setMaxAge(maxAge);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }

    /**
     * 获取指定Cookie
     *
     * @param request
     * @param name    Key
     * @return
     */
    public static String getCookieByName(HttpServletRequest request, String name) {
        if (name == null) return null;
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    try {
                        if (!ValidUtil.isEmpty(cookie.getValue())) {
                            return URLDecoder.decode(cookie.getValue(), Const.ENCODE);
                        }
                    } catch (UnsupportedEncodingException e) {
                        LogUtil.error(logger, e);
                        return null;
                    }
                }
            }
        }
        return null;
    }

    private static Map<String, Cookie> getCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }


    /**
     * 刷新Cookie
     *
     * @param request
     * @param response
     * @param name     Key
     */
    public static void refushCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        Map<String, Cookie> cookieMap = getCookieMap(request);
        Cookie cookie = cookieMap.get(name);
        cookie.setMaxAge(COOKIE_MAXAGE);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 刷新Cookie
     *
     * @param request
     * @param response
     * @param name     Key
     * @param maxAge   有效期（秒）
     */
    public static void refushCookie(HttpServletRequest request, HttpServletResponse response, String name, int maxAge) {
        Map<String, Cookie> cookieMap = getCookieMap(request);
        Cookie cookie = cookieMap.get(name);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
    }


}
