# Base-grpc-framework project
#### &emsp;&emsp;A framework base on springBoot for grpc server develop. It also integration with Mapstrct、 Google-Grpc.You can use it as base framework that onle need to develop bussness code. Mainly function:

&emsp;&emsp; - __TrackLog：__ Support log tracking for each thread

&emsp;&emsp; - __Interception：__ Such as grpc-client、grpc-server、mvcController

&emsp;&emsp; - __ModelBean：__ Support model bean convent to each other, also proto

&emsp;&emsp; - __DataTool：__ Make data operation easlier, specific pagination

#### [Docment and Course](  https://blog.51cto.com/arch/5386304)

##  一、Start
- __Step-1、Create demo database:__ 
  ```
  #---------- create database ----------
   dbName:badCase
   port:3306
   username: root
   password: 12345678
  
  #---------- create table -------------
  create table t_sys_record
  (
    id          varchar(32)            not null primary key,
    biz_id      varchar(32) default '' null comment 'business id',
    user_id     varchar(32)            null comment 'operator userId',
    track_uid   varchar(128)           null comment 'tracklog UUID',
    code        varchar(32)            null comment 'primary operator code',
    custom_code varchar(32)            null comment 'slave operator code ',
    status      int                    null comment '1: enable, 0:disable',
    ctime       datetime               null comment 'create time',
    utime       datetime               null comment 'update time',
    cid         varchar(32)            null comment 'creater id',
    cname       varchar(32)            null comment 'creater name'
  );
  ```
- __Step-2、Run server:__ also can run com.zd.baseframework.BaseFrameworkApplication.java with config active profiles=dev
  ```
  java -jar -Dspring.profiles.active=dev base-grpc-framework-application-1.0-SNAPSHOT.jar
  ```
- __Step-3、Client Test:__ 
  ```
  open http://localhost:18080/swagger-ui.html
  ```

## 二、Compile
  ```
  cd base-grpc-framework
  mvn clean install -Dmaven.test.skip=true
  
  cd base-grpc-framework-application
  mvn clean package -Dmaven.test.skip=true
  ```

## 三、 Configuration
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
---
## FAQ
#### 1、Can't find Grpc-proto object at base-grpc-framework-core module?
```
cd base-grpc-framework-api
mvn protobuf:compile -f pom.xml
mvn protobuf:compile-custom -f pom.xml
```
## Change logs
- Release-v0.0.1
  ```
  The First release version
  ```
- .....