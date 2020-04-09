package com.springboot.entity;

import lombok.Data;

@Data
public class Computer {
    private Integer id;
    private String name;
    private Integer price;
    private String cpu;
    private String disk;
    private String ram;
    private String system;
}