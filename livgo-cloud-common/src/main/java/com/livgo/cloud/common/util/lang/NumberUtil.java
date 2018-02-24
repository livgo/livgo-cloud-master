package com.livgo.cloud.common.util.lang;


import java.text.DecimalFormat;

/**
 * Description:数值工具类
 * Author:     gaocl
 * Date:       2017/12/22
 * Version:     V1.0.0
 * Update:     更新说明
 */
public final class NumberUtil {

    /**
     * 四舍五入
     *
     * @param d
     * @param scale
     * @return
     */
    public static Double halfUp(Double d, int scale) {
        int si = Integer.parseInt("1" + FixdUtil.appendZero(scale));
        d = d * si;
        d = Double.valueOf(Math.round(d));
        return d / si;
    }

    /**
     * 不四舍五入
     *
     * @param d
     * @param scale
     * @return
     */
    public static Double halfDown(Double d, int scale) {
        return Double.valueOf(new DecimalFormat("#." + FixdUtil.appendZero(scale)).format(d));
    }

}
