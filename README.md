# spring-h2db-tutorials

H2是一个纯Java开发的嵌入式数据库，它可以作为内存数据库将数据保存在内存中，也可以持久化保存在硬盘中

H2最主要的一个特征在于它足够轻，轻到只有一个jar包便可以启动

以Mysql为例，传统的数据库要启动一般包含下面几个步骤

* 下载安装Mysql

* 建库建表

* 创建应用、设置源地址、建立连接并编码

而H2可以省略安装的操作，并且极大简化建库建表跟编码的工作

咋一看，好像没啥特别的作用，但在下面这几个应用场景中还是用h2最为合适

* 案例型项目：纯粹为了验证某一种技术方案可行性而编写的demo项目

* 各种项目下的测试单元：测试单元如果涉及到数据库的操作，那么这种情况下使用h2并将数据临时存储在内存种是最合适不过的

* client-server类型的项目

H2作为一款嵌入式数据库，同时支持两种运行模式：In-memory DataBae与Persisted Database

前者是在系统启动时，将数据库直接创建在内存中，系统每次重启都会清除所有数据库相关信息(案例演示跟测试单元中常用这种模式)

后者则是将数据持久化保存在硬盘中，当然现在并不推荐这种方式（毕竟要持久化保存数据的话，还是mysql这些来的靠谱）

假设要创建一个名为test_base的数据库，如果我们以In-memory DataBae的模式启动，那么按照下述编写代码即可:

````java
String JDBC_DRIVER = "org.h2.Driver";
String url = "jdbc:h2:mem:test_base";
String user = "sa";
String passwd = "";
//注册JDBC驱动类
Class.forName(JDBC_DRIVER);
//建立链接
Connection conn = DriverManager.getConnection(url, user, passwd);
```` 

如果要以Persisted Database模式启动，将url改为: ``` jdbc:h2:./data/db/test_base ``` 即可（更详细的代码请参考h2db-basic的代码）

注意这里的"./data/db/"表示操作系统的相对目录，test_base为数据库名

除了上述直接用原生的写法之外，h2也可以在Spring Boot、Mybatis等框架下运行

* h2在Spring Boot下的运行请参考h2db-spring的代码

* h2在Spring Boot下结合Mybatis运行请参考h2db-spring-ibatis的代码

* h2结合测试单元的使用案例请参考h2db-spring-ibatis的代码

## 参考链接

* https://www.springboottutorial.com/spring-boot-and-h2-in-memory-database

* https://dzone.com/articles/spring-boot-and-spring-jdbc-with-h2

* https://github.com/baomidou/mybatis-plus



