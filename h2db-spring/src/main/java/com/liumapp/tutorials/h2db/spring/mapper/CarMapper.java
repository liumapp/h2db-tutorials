package com.liumapp.tutorials.h2db.spring.mapper;

import com.liumapp.tutorials.h2db.spring.domain.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * file CarMapper.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/6/18
 */
public class CarMapper implements RowMapper <Car> {

    @Override
    public Car mapRow(ResultSet resultSet, int i) throws SQLException {
        Car car = new Car();
        car.setId(resultSet.getInt("id"));
        car.setName(resultSet.getString("name"));
        car.setPrice(resultSet.getInt("price"));
        return car;
    }

}
