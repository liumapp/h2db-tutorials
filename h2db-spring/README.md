## h2-console

开启h2-console:
 
````yaml
spring:
  h2:
    console:
      enabled: true
````

并启动SpringBoot项目后，可在浏览器中访问 ``` http://localhost:8080/h2-console ``` 来查询h2数据库

相关登录参数

* Drive Class: org.h2.Driver

* JDBC URL: jdbc:h2:mem:test


