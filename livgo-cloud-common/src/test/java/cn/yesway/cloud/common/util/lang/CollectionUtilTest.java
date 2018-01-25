package com.livgo.cloud.common.util.lang;

import com.livgo.cloud.common.util.valid.ValidUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author:     gaocl
 * Date:       2017/12/20
 * Version:    V1.0.0
 * Update:     更新说明
 */

public class CollectionUtilTest {

    @Test
    public void handlerTest() {
        List lst = new ArrayList();
        lst.add("1");
        lst.add("2");
        CollectionUtil.handler(lst, new ObjectHandler<String>() {
            @Override
            public void handler(String t) {
                System.out.println(t);
            }
        });
    }

    @Test
    public void processTest() {
        List lst1 = new ArrayList();
        List lst = new ArrayList();
        lst.add("1");
        lst.add("2");
        CollectionUtil.process(lst, lst1, new ObjectProcess<String, Integer>() {
            @Override
            public Integer process(String s) {
                if (ValidUtil.isEquals(s, "1")) {
                    return 1;
                }
                return null;
            }
        });
        System.out.println(lst1);
    }
}
