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
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;- [Docment](  https://blog.51cto.com/arch/5386304)

## Change logs

- V0.1： 2022-09-01 initialize