package com.springboot.entity;

import lombok.Data;

@Data
public class Car {
    private Integer id;
    private String name;
    private Integer price;
    private String colour;
    private String brand;
}