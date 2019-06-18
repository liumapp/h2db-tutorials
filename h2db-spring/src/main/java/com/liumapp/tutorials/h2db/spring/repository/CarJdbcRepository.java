package com.liumapp.tutorials.h2db.spring.repository;

import com.liumapp.tutorials.h2db.spring.domain.Car;
import com.liumapp.tutorials.h2db.spring.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List< Car > findAll() {
        return template.query("select * from cars", new CarMapper());
    }

    public int deleteById(long id) {
        return template.update("delete from cars where id=?", new Object[] {
                id
        });
    }
    public int insert(Car car) {
        return template.update("insert into cars (id, name, price) " + "values(?,  ?, ?)",
                new Object[] {
                        car.getId(), car.getName(), car.getPrice()
                });
    }
    public int update(Car car) {
        return template.update("update cars " + " set name = ?, price = ? " + " where id = ?",
                new Object[] {
                        car.getName(), car.getPrice(), car.getId()
                });
    }

}
