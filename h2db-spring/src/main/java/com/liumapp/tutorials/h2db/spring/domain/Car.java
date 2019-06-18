package com.liumapp.tutorials.h2db.spring.domain;

import lombok.Data;

/**
 * file Car.java
 * author liumapp
 * github https://github.com/liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2019/6/17
 */
@Data
public class Car {

    private int id;

    private String name;

    private int price;

    public Car() {
    }

    public Car(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
