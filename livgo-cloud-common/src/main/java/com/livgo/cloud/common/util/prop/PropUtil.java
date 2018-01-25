package com.livgo.cloud.common.util.prop;


import com.livgo.cloud.common.util.log.LogUtil;
import com.livgo.cloud.common.util.valid.ValidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Description: Properties工具类
 * Author:     gaocl
 * Date:       2017/12/21
 * Version:    V1.0.0
 * Update:     更新说明
 */
public final class PropUtil {
    private final static Logger logger = LoggerFactory.getLogger(PropUtil.class);

    /**
     * 初始化磁盘Properties文件
     *
     * @param filePath
     * @return
     */
    public static Properties loadFile(String filePath) {
        try {
            Properties prop = new Properties();
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            prop.load(in);
            return prop;
        } catch (IOException e) {
            LogUtil.error(logger, e);
        }
        return null;
    }

    /**
     * 初始化Properties文件
     *
     * @param relativePath 相对路径
     * @return
     */
    public static Properties load(String relativePath) {
        try {
            Properties prop = new Properties();
            InputStream in = Object.class.getResourceAsStream(relativePath);
            prop.load(in);
            return prop;
        } catch (IOException e) {
            LogUtil.error(logger, e);
        }
        return null;
    }

    /**
     * 获取指定Properties文件里的某个key的value
     *
     * @param relativePath
     * @param name
     * @return
     */
    public static Object get(String relativePath, String name) {
        Properties prop = load(relativePath);
        if (null != prop) {
            String val = prop.getProperty(name);
            if (ValidUtil.isNotEmpty(val)) {
                return val.trim();
            }
        }
        return null;
    }

}
