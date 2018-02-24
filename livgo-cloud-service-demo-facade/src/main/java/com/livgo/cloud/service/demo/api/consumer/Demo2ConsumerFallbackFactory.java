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
public class Demo2ConsumerFallbackFactory implements FallbackFactory<Demo2Consumer> {
    private final static Logger logger = LoggerFactory.getLogger(Demo2ConsumerFallbackFactory.class);

    @Override
    public Demo2Consumer create(Throwable throwable) {
        LogUtil.error(logger, throwable);
        return new Demo2Consumer() {

            @Override
            public ResultBean hello1(String name) {
                return ResultBean.FAIL(throwable.getMessage());
            }

            @Override
            public ResultBean hello2(String name) {
                return ResultBean.FAIL(throwable.getMessage());
            }
        };
    }
}
