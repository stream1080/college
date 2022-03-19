## 慕课学院后端项目

系统后端接口部分，使用目前市面上流行的 SpringBoot+SpringCloud 进行微服务架构，使用 Feign、Gateway、Hystrix ，以及阿里巴巴的 Nacos 等组件搭建了项目的基础环境。采用 MyBatis-Plus 进行持久层的操作，使用了 OAuth2+JWT 实现了分布式的访问。此外，项目中使用了阿里巴巴的 EasyExcel 实现对 Excel 的读写操作，使用了 Redis 进行首页数据的缓存，使用 Git 进行代码的版本控制，整合了 Swagger 生成接口文档。

```
college                  // 聚合项目
├── common                      // 通用代码层
│       └── utils               // 工具类
│       └── base                // 业务通用代码
├── gateway                 // gateway网关
│       
├── service                     // 业务代码层
│       └── service_cms             // 前台内容api
│       └── service_edu             // 后台内容api
│       └── service_oss             // 阿里云oss文件存储
│       └── service_sms             // 阿里云短信分发
│       └── service_statistics      // 统计报表模块
│       └── service_trade           // 课程交易模块
│       └── service_ucenter         // 用户模块
│       └── service_vod             // 腾讯云vod视频存储
├── sql                             // 数据库文件
│       └── edu_cms.sql             // 前台内容数据库表
│       └── edu_college.sql         // 学院核心数据库表
│       └── edu_statistics.sql      // 统计内容数据库表
│       └── edu_trade.sql           // 订单交易数据表
│       └── edu_ucenter.sql         // 用户信息数据表
├── log                             // 日志文件
│       └── edu                     // 各业务的相关日志文件

```

