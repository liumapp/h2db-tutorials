package com.liumapp.tutorials.h2db.ibatis.domain;

import lombok.Data;

/**
 * file Cars.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/6/18
 */
@Data
public class Cars {

    private int id;

    private String name;

    private int price;

    public Cars() {
    }

    public Cars(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
