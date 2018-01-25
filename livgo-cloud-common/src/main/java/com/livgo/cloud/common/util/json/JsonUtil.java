package com.livgo.cloud.common.util.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

/**
 * Description: Json工具类
 * Author:     gaocl
 * Date:       2017/12/22
 * Version:    V1.0.0
 * Update:     更新说明
 */
public final class JsonUtil {

    private static Gson gson = null;

    static {
        if (gson == null) {
            gson = new Gson();
        }
    }

    /**
     * 转成json
     *
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        String jsonStr = null;
        if (gson != null) {
            jsonStr = gson.toJson(obj);
        }
        return jsonStr;
    }

    /**
     * 转成bean
     *
     * @param jsonStr
     * @param cls
     * @return
     */
    public static <T> T toBean(String jsonStr, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(jsonStr, cls);
        }
        return t;
    }

    /**
     * 转成list
     *
     * @param jsonStr
     * @param cls
     * @return
     */
    public static <T> List<T> toListBeans(String jsonStr, Class<T> cls) {
        List<T> list = null;
        if (gson != null) {
            list = gson.fromJson(jsonStr, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * 转成list中有map
     *
     * @param jsonStr
     * @return
     */
    public static <T> List<Map<String, T>> toListMaps(String jsonStr) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(jsonStr,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }

    /**
     * 转成map
     *
     * @param jsonStr
     * @return
     */
    public static <T> Map<String, T> toMap(String jsonStr) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(jsonStr, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }
}

