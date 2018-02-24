package com.livgo.cloud.service.demo.api.consumer;

import com.livgo.cloud.common.model.bean.ResultBean;
import com.livgo.cloud.common.util.log.LogUtil;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Author:     gaocl
 * Date:       2017/12/8
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Component
public class Demo1ConsumerFallbackFactory implements FallbackFactory<Demo1Consumer> {
    private final static Logger logger = LoggerFactory.getLogger(Demo1ConsumerFallbackFactory.class);

    @Override
    public Demo1Consumer create(Throwable throwable) {
        LogUtil.error(logger, throwable);

        return new Demo1Consumer() {

            @Override
            public ResultBean hi1(String name) {
                return ResultBean.FALLBACK("sorry");
            }

            @Override
            public ResultBean hi2(String name) {

                return ResultBean.FAIL(throwable.getMessage());
            }
        };
    }
}
