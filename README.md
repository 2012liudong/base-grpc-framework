# base-grpc-framework project
A framework base springBoot for grpc server develop. It also integration with Mapstrct、 Google-Grpc.
You can use it as base framework that onle need to develop bussness code. Main function:

1、__TrackLog：__ Support log-tracking function for each thread and provide LogGenerator API. The log attr includeing
tid、appId、token、exec(elapsed time) ...;

2、__Interception：__ Definition some default interceptions，includeing grpc-client、grpc-server、mvcController;

3、__ModelBeanCopy：__ Support model bean(entity、bo、vo、dto) convent to each other. Support grpc type and java type convent;

4、__DataOperTool：__ Base mybatis plus, make data operation easlier, specific pagination;


## 1、Quick Start

> java -jar -Dspring.profiles.active=dev  base-grpc-framework-application.jar

- __active:__ environment variable for app
  ```
  spring.profiles.active=dev

- __jarFileName:__ to see file pom.xml, default base-grpc-framework-application.jar
  ```
  <artifactId>base-grpc-framework-parent</artifactId>
---

## Change logs

- V0.1： 2022-09-01 initialize