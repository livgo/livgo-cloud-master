package com.livgo.cloud.common.util.lang;

import com.livgo.cloud.common.util.valid.ValidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:数组工具类
 * Author:     gaocl
 * Date:       2017/12/21
 * Version:     V1.0.0
 * Update:     更新说明
 */
public final class ArrayUtil {

    private final static Logger LOG = LoggerFactory.getLogger(ArrayUtil.class);

    /**
     * 数组转指定分隔字符
     *
     * @param objs      数组
     * @param separator 分隔符
     * @return
     */
    public static String arrayToString(Object[] objs, String separator) {
        if (ValidUtil.isEmpty(objs)) {
            LOG.error("objs is empty or is null");
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (Object obj : objs) {
            sb.append(obj.toString()).append(separator);
        }
        return sb.substring(0, sb.length() - 1);
    }


}
