package com.liumapp.tutorials.h2db.ibatis;

import com.liumapp.tutorials.h2db.ibatis.domain.Cars;
import com.liumapp.tutorials.h2db.ibatis.mapper.CarMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * file H2dbSpringIbatisTest.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/6/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class H2dbSpringIbatisTest {

    @Autowired
    private CarMapper mapper;

    @Test
    public void testSelect () {
        System.out.println(("----- selectAll method test ------"));
        List<Cars> userList = mapper.selectList(null);
        Assert.assertEquals(8, userList.size());
        userList.forEach(System.out::println);
    }
}