package com.livgo.cloud.common.util.log;


import com.livgo.cloud.common.util.date.DateUtil;
import com.livgo.cloud.common.util.http.HttpUtil;
import com.livgo.cloud.common.util.json.JsonUtil;
import com.livgo.cloud.common.util.valid.ValidUtil;
import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


public final class LogUtil {

    public final static String BEGINLINE = "####################请求开始####################";
    public final static String ENDLINE = "####################请求完成####################";


    public static String logReqUrl(HttpServletRequest request) {
        return "请求地址:" + request.getRequestURL();
    }

    public static String logReqClient(HttpServletRequest request) {
        return "请求客户端:" + "Time:" + DateUtil.getCurDateTime()
                + " , IP:" + HttpUtil.getIpAddr(request)
                + " , Agent:" + HttpUtil.getUserAgent(request);
    }

    public static String logReqArgs(HttpServletRequest request) {
        //TODO 过滤敏感日志信息
        Map map = new HashMap<>(request.getParameterMap());
        if (null != map) {
            if (ValidUtil.isNotEmpty(map.get("password"))) {
                map.put("password", "***");
            }
            if (ValidUtil.isNotEmpty(map.get("paypassword"))) {
                map.put("paypassword", "***");
            }
            if (ValidUtil.isNotEmpty(map.get("PASSWORD"))) {
                map.put("PASSWORD", "***");
            }
            if (ValidUtil.isNotEmpty(map.get("oldpassword"))) {
                map.put("oldpassword", "***");
            }
            if (ValidUtil.isNotEmpty(map.get("newpassword"))) {
                map.put("newpassword", "***");
            }
        }

        return "请求参数:" + JsonUtil.toJson(map);
    }

    public static String logFilter(String msg) {
        //TODO 过滤敏感日志信息
        return msg;
    }

    public static void logSuspect(Logger logger, String msg, HttpServletRequest request) {
        logger.warn("可疑记录:" + msg
                + " , URL:" + request.getRequestURL()
                + " , Args:" + logReqArgs(request)
                + " , IP:" + HttpUtil.getIpAddr(request)
                + " , Agent:" + HttpUtil.getUserAgent(request));
    }

    public static void logValid(Logger logger, String msg) {
        logger.warn("验证失败：" + msg);
    }

    public static void logEmpty(Logger logger, String msg) {
        logger.warn("数据为空：" + msg);
    }

    public static void warn(Logger logger, String msg) {
        logger.warn("警告日志：" + msg);
    }

    public static void info(Logger logger, String msg) {
        logger.info("记录日志:" + msg);
    }

    public static void error(Logger logger, Throwable e) {
        logger.error("错误日志:" + e);
    }

    public static void error(Logger logger, String msg) {
        logger.error("错误日志:" + msg);
    }

}
