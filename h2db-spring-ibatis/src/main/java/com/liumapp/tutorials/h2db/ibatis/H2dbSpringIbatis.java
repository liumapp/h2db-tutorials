package com.liumapp.tutorials.h2db.ibatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * file H2dbSpringIbatis.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/6/18
 */
@SpringBootApplication
@MapperScan("com.liumapp.tutorials.h2db.ibatis.mapper")
public class H2dbSpringIbatis
{
    public static void main( String[] args )
    {
        SpringApplication.run(H2dbSpringIbatis.class, args);
    }
}
