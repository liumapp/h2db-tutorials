package com.liumapp.tutorials.h2db.spring.repository;

import com.liumapp.tutorials.h2db.spring.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * file CarJdbcRepository.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/6/18
 */
@Repository
public class CarJdbcRepository {

    @Autowired
    private JdbcTemplate template;

    public Car findById (Integer id) {
        return template.queryForObject("select * from cars where id=?", new Object[] {
                        id
                },
                new BeanPropertyRowMapper< Car >(Car.class));
    }

}
