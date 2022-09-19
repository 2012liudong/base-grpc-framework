# Base-grpc-framework project
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;A framework base springBoot for grpc server develop. It also integration with Mapstrct、 Google-Grpc.
You can use it as base framework that onle need to develop bussness code. Main function:

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;1、__TrackLog：__ Support log-tracking function for each thread and provide LogGenerator API

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;2、__Interception：__ Definition such as grpc-client、grpc-server、mvcController

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;3、__ModelBeanConvent：__ Support model bean convent to each other as also grpc type

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;4、__DataOperTool：__ Base mybatis plus that make data operation easlier, specific pagination;


## 1、Quick Start
> a、create demo database 

- __createMysqlDB:__ 
  ```
  jdbc:mysql://127.0.0.1:3306/badCase?characterEncoding=utf8
  username: root
  password: 12345678
  
- __initDbTable:__ 
  ```
  create table t_sys_record
  (
    id          varchar(32)            not null primary key,
    biz_id      varchar(32) default '' null comment '业务ID',
    user_id     varchar(32)            null comment '操作用户ID',
    track_uid   varchar(128)           null comment '链路ID',
    code        varchar(32)            null comment '操作代码',
    custom_code varchar(32)            null comment '操作2级代码',
    status      int                    null comment '记录状态:1可查询，0不可查询',
    ctime       datetime               null,
    utime       datetime               null,
    cid         varchar(32)            null,
    cname       varchar(32)            null
  )

> b、Run through jar : java -jar -Dspring.profiles.active=dev  base-grpc-framework-application.jar

- __active:__ environment variable for app
  ```
  spring.profiles.active=dev
- __jarFileName:__ definition in pom.xml file. default name is 'base-grpc-framework-application.jar'
  ```
  <artifactId>base-grpc-framework-parent</artifactId>
  
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;also can run by mainClass(com.zd.baseframework.BaseFrameworkApplication.java) with config active.profiles=dev 

## 2、 Document
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;- [Docment and Course](  https://blog.51cto.com/arch/5386304)

## 3、 Configuration
 ```
# app server config
server:
  port: 18080
  compression:
    enabled: true
    mime-types: application/json,application/octet-stream

grpc:
  server:
    port: 9898   #remote port
    in-process-name: native  #local port
  client:
    inProcess: # grpc server name
      address: in-process:native
      enableKeepAlive: true
      keepAliveWithoutCalls: true

logging:
  config: classpath:log4j2.xml
  level:
    root: INFO
    org.springframework.web: ERROR

app-properties:
  token-key: token
  http-api-path: /api/**

# spring config
spring:
  application:
    name: GrpcFramework-Server-APP
  aop:
    auto: true
    proxy-target-class: true
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/badCase?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai
    username: root
    password: 12345678
    druid:
      initial-size: 5
      min-idle: 5
      max-active: 20
      max-wait: 60000
      validation-query: SELECT 1 FROM DUAL
      max-pool-prepared-statement-per-connection-size: 5
      test-while-idle: true
      test-on-borrow: false
      test-on-return: false
      time-between-eviction-runs-millis: 60000
      min-evictable-idle-time-millis: 100000
      filters: stat

# mybatis-plug config
mybatis-plus:
  mapper-locations: classpath:/mybatis/*Mapper.xml
  configuration:
    map-underscore-to-camel-case: true 
    default-statement-timeout: 20000 
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl #print sql log, omit to close

# swagger 
swagger-config:
  enabled: true 
  title: GrpcFramework-API
  description: GrpcFramework-Server-Restful-API
  version: V1.0
  base-package: com.zd.baseframework.core.restful # multi package split with comma(,)
  authorization-key-name: token
 ```

## Change logs

- V0.1： 2022-09-01 initialize