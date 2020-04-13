package com.springboot.entity;

import lombok.Data;

@Data
public class Forward {
    private Integer id;
    private String executetime;
    private String name;
    private String url;
    private String title;
}