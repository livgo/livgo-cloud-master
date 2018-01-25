package com.livgo.cloud.common.util.lang;

import com.livgo.cloud.common.util.valid.ValidUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Description: UUID工具类
 * Author:     gaocl
 * Date:       2017/12/22
 * Version:    V1.0.0
 * Update:     更新说明
 */
public final class UUIDUtil {

    /**
     * 获取一个UUID
     *
     * @return
     */
    public static String getRandomUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 获取一个32位UUID
     * 去掉横线的
     *
     * @return
     */
    public static String get32UUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获取大写UUID
     *
     * @return 大写的UUID
     */
    public static String get32UUIDUpper() {
        return get32UUID().toUpperCase();
    }

    /**
     * 获取指定数量的32位UUID
     *
     * @param count
     * @return
     */
    public static List get32UUIDs(int count) {
        List uuids = new ArrayList();
        for (int i = 0; i < count; i++) {
            uuids.add(get32UUID());
        }
        return uuids;
    }

    /**
     * 获取指定数量的32位大写UUID
     *
     * @param count
     * @return
     */
    public static List get32UUIDUppers(int count) {
        List uuids = new ArrayList();
        for (int i = 0; i < count; i++) {
            uuids.add(get32UUIDUpper());
        }
        return uuids;
    }

    /**
     * 获取指定位数的UUID
     *
     * @param n 需介于0-32之间
     * @return
     */
    public static String getNumUUID(int n) {
        if (ValidUtil.isNotBetween(n, 0, 32)) {
            return null;
        }
        return get32UUID().substring(0, n);
    }

    public static void main(String[] args) {
        System.out.println(getNumUUID(0));
    }

}
