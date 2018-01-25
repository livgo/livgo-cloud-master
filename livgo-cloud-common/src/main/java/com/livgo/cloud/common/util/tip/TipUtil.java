package com.livgo.cloud.common.util.tip;


import com.livgo.cloud.common.Const;
import com.livgo.cloud.common.util.log.LogUtil;
import com.livgo.cloud.common.util.valid.ValidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

/**
 * Description: 提示语工具类
 * Author:     gaocl
 * Date:       2017/12/21
 * Version:    V1.0.0
 * Update:     更新说明
 */
public final class TipUtil {
    private final static Logger logger = LoggerFactory.getLogger(TipUtil.class);
    // 获取tip资源, 需要配置加载tip.properties
    private final static ResourceBundle resource = ResourceBundle.getBundle("tip");
    private final static ResourceBundle resourceBase = ResourceBundle.getBundle("tipbase");

    /**
     * 获取属性值
     * tip优先于tipbase
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        String val = "";

        try {
            if (resource.containsKey(key)) {
                val = new String(resource.getString(key).getBytes("ISO-8859-1"), Const.ENCODE);
            } else if (resourceBase.containsKey(key)) {
                val = new String(resourceBase.getString(key).getBytes("ISO-8859-1"), Const.ENCODE);
            }
        } catch (Exception e) {
            LogUtil.error(logger, e);
        }

        return val;
    }


    /**
     * 获取属性值，并format填充占位符
     * tip优先于tipbase
     *
     * @param key
     * @param params
     * @return
     */
    public static String get(String key, Object... params) {
        String val = get(key);
        if (ValidUtil.isEmpty(val)) {
            return "";
        }
        return String.format(val, params);
    }

}
