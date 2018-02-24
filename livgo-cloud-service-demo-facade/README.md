降级逻辑：

    以下四种情况将触发Fallback：
    1. run()方法抛出非HystrixBadRequestException异常。
    2. run()方法调用超时
    3. 熔断器circuit-breaker打开
    4. 线程池/队列/信号量是否跑满
    
