package com.livgo.cloud.common.util.tip;

import com.livgo.cloud.common.util.date.DateUtil;
import org.junit.Test;

/**
 * Description:
 * Author:     gaocl
 * Date:       2017/12/21
 * Version:    V1.0.0
 * Update:     更新说明
 */
public class TipUtilTest {

    public static void main(String[] args) {
        long beginTime = DateUtil.getCurTimeMillis();
        for (int i = 0; i < 100000; i++) {

            if (i % 999 == 0) {
                System.out.println(TipUtil.get("tip.public.error.system"));
            } else {
                TipUtil.get("tip.public.error.system");
            }
        }
        long endTime = DateUtil.getCurTimeMillis();
        System.out.println("耗时：" + (endTime - beginTime));
    }

    @Test
    public void test() {
        long beginTime = DateUtil.getCurTimeMillis();
        System.out.println(TipUtil.get("tip.public.error.system"));
        long endTime = DateUtil.getCurTimeMillis();
        System.out.println("耗时：" + (endTime - beginTime));
    }

}
