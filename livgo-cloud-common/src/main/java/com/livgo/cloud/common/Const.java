package com.livgo.cloud.common;

import com.livgo.cloud.common.util.sys.SysUtil;

/**
 * Description:常量基类
 * Author:     gaocl
 * Date:       2017/12/19
 * Version:    V1.0.0
 * Update:     更新说明
 */
public class Const {

    // 编码
    public final static String ENCODE = "UTF-8";
    // 错误异常
    public final static String ERROR = "ERROR";
    // 成功
    public final static String SUCCESS = "SUCCESS";
    // 验证失败
    public final static String FAIL = "FAIL";
    // 验证失败但会返回空的等结果信息
    public final static String FAILBACK = "FAILBACK";
    // 一天的秒数
    public final static int SECOND_DAY = 86400;
    // 一个小时的秒数
    public final static int SECOND_HOUR = 3600;
    // 一周的秒数
    public final static int SECOND_WEEK = 7 * 24 * 60 * 60;
    // Session默认保持20分钟
    public final static int SESSION_KEEP_LOGIN = 20 * 60;
    // 分页大小
    public final static int PAGE_SIZE = 10;
    // 分页大小
    public final static int PAGE_SIZE_MIN = 5;
    // 控制请求次数的时间（秒）
    public final static int REQUEST_TIMES_TIME = 1;
    // 控制请求可疑次数
    public final static int REQUEST_TIMES_SUSPICIOUS = 10;
    // 文件后缀分隔符
    public final static String SUFFIX_SEPRATOR = ".";
    // 文件分隔符
    public final static String FILE_SEPRATOR = SysUtil.FILE_SEPRATOR;
    // 缓冲区大小
    public final static Integer BUFFER_SIZE = 1024;
    // 业务跟踪ID
    public final static String TRACE_ID = "TRACE_ID";

}
