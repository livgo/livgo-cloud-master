package com.livgo.cloud.service.demo.provider;

import com.livgo.cloud.common.model.bean.ResultBean;
import com.livgo.cloud.common.util.log.LogUtil;
import com.livgo.cloud.config.kafka.KafkaConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author:     gaocl
 * Date:       2017/12/1
 * Version:    V1.0.0
 * Update:     更新说明
 */
@RestController
@RequestMapping("service-demo-demo2")
@RefreshScope
public class Demo2Provider {
    private final static Logger logger = LoggerFactory.getLogger(Demo2Provider.class);

    @Autowired
    private KafkaConfig kafkaConfig;
    @Value("${spring.rabbitmq.host}")
    private String rabbitmqHost;
    @Value("${redis.key}")
    private String redisKey;


    @RequestMapping("hello1/{name}")
    public ResultBean hello1(@PathVariable("name") String name) {
        LogUtil.info(logger, "hello1 ==========>>" + name);
        return ResultBean.SUCCESS("Hello, " + name +
                ",rabbitmqHost:" + rabbitmqHost +
                ",redisKey:" + redisKey
        );
    }

    //    @HystrixCommand(fallbackMethod = "helloFallback")
    @RequestMapping("hello2/{name}")
    public ResultBean hello2(@PathVariable("name") String name) {
        LogUtil.info(logger, "hello2 ==========>>" + name);
        for (int j = 0; j < Integer.MAX_VALUE; j++) {

        }
        return ResultBean.SUCCESS("Hello, " + name +
                ",rabbitmqHost:" + rabbitmqHost +
                ",redisKey:" + redisKey
        );
    }

//    /**
//     * 细粒度控制服务
//     * <p>
//     * HystrixCollapser，合并请求到hiList处理，适用于单次响应时间较长并且高并发的场景
//     * Cacheable，可做结果缓存redis等
//     *
//     * @param name
//     * @return
//     */
//    @RequestMapping("hello2/{name}")
//    @HystrixCommand(fallbackMethod = "helloFallback")
//    @HystrixCollapser(
//            batchMethod = "helloList",
//            scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL,
//            collapserProperties = {
//                    @HystrixProperty(name = "timerDelayInMilliseconds", value = "50"),
//                    @HystrixProperty(name = "maxRequestsInBatch", value = "200")
//            }
//    )
////    @Cacheable
//    public ResultBean hello2(@PathVariable("name") String name) {
////        int i = 1 / 0;
//        for (int j = 0; j < Integer.MAX_VALUE; j++) {
//
//        }
//        LOG.info("hello2：" + name);
//        return null;
//    }
//
//    @HystrixCommand(commandKey = "helloList")
//    public List<ResultBean> helloList(List<String> nameList) {
//        LOG.info("请求已合并");
//        //批量处理
//        List<ResultBean> lst = new ArrayList<>();
//        for (String name : nameList) {
//            lst.add(ResultBean.SUCCESS(name));
//        }
//        return lst;
//    }
//
//
//    public ResultBean helloFallback(String name) {
//        return ResultBean.FALLBACK("sorry");
//    }
}
