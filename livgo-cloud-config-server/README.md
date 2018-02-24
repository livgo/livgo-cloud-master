使用方法：

    1. @ConfigurationProperties注解的配置对象，可刷新对象value但并不会重新初始化实例
       @RefreshScope清除目标缓存中的范围内的所有bean，用于动态更新已建立的连接池等
    2. 所有项目刷新：
        post请求config-server的/monitor/bus/refresh
        不建议使用
    3. 局部刷新
        post请求config-server的/monitor/bus/refresh?destination=SERVERID
    4. 各项目刷新配置
        post请求各项目的/monitor/refresh 
        建议使用
    5. 覆盖配置中心的公共配置，可在配置中心里各项目的配置文件中重写配置项
    6. 工具刷新：
        可在sys-boot-admin管理页面里修改属性值
        建议使用
    
配置文件说明：

    spring-*.properties:Spring支持的配置
    config-*.properties:公共配置与其他配置
    各项目.properties:各项目固定配置
    
    按顺序从下到上覆盖重复key， 此顺序由各项目加载配置中心文件顺序决定，后加载覆盖前加载
    所以不可更改各项目的config加载顺序
    