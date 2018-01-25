package com.livgo.cloud.common.util.pk;

import com.livgo.cloud.common.util.date.DateUtil;
import com.livgo.cloud.common.util.lang.UUIDUtil;

/**
 * Description:主键生成工具类
 * Author:     gaocl
 * Date:       2017/12/22
 * Version:    V1.0.0
 * Update:     更新说明
 */
public final class PKUtil {

    /**
     * 生成主键
     *
     * @return 24位主键，时间精确到毫秒
     */
    public static String createID24() {
        return DateUtil.format(DateUtil.FORMAT10) + UUIDUtil.getNumUUID(7);
    }

    /**
     * 生成主键
     *
     * @return 20位主键，时间精确到秒
     */
    public static String createID20() {
        return DateUtil.format(DateUtil.FORMAT6) + UUIDUtil.getNumUUID(6);
    }


}
