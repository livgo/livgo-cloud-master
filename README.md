Spring Cloud Framework

框架简介：

    此框架为Spring Cloud的简易基础版，主要涉及结构定义，组件构成，流程规范，基础功能，Demo示例
   
    
    开源学习，不可用于商业用途！
    欢迎多交流！
    
结构说明：

    1.livgo-cloud：项目名
    2.admin-xxx: 各后台管理系统
    3.api-xxx: 各API接口
    4.common: 常用工具包
    5.config: 配置包
    6.config-server: 配置中心
    7.core: 非功能性技术核心包
    8.eureka-server: 注册中心，1、2、3（高可用），可只用一个server
    9.gateway-xxx: 网关
    10.job: task等延迟处理任务系统（可选）
    11.service-xxx: 微服务
    12.service-xxx-facade: 微服务接口
    13.sys-boot-admin: 监控平台
    14.sys-hystrix-monitor: 服务断路监控仪表，仅供学习使用（已集成到sys-boot-admin）
    15.sys-log-trace: 日志追踪，仅供学习使用(只用sleuth，放弃zipkin,可选择使用其他日志监控平台)
   
    
使用方法： 

    1.启动顺序，eureka > config-server > 各应用
    2.各module包含使用说明，可详细了解
    3.Swagger地址：各项目域名端口+/swagger-ui.html
    
    
软件安装： 
    
    1.安装mysql, rabbitmq, redis
    2.各配置端口密码等信息可在config-server里查看与对照
    3.可视化页面在监控平台sys-boot-admin
