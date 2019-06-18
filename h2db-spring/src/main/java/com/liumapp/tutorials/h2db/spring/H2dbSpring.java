package com.liumapp.tutorials.h2db.spring;

import com.liumapp.tutorials.h2db.spring.repository.CarJdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * file H2dbSpring.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/6/17
 */
@SpringBootApplication
public class H2dbSpring implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CarJdbcRepository repository;

    public static void main (String[] args) {
        SpringApplication.run(H2dbSpring.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Car id 6 -> {}", repository.findById(6));
        logger.info("All car info -> {}", repository.findAll());
    }
}
