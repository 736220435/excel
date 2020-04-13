package com.springboot.entity;

import lombok.Data;

@Data
public class ForwardResult {
    private Integer id;
    private Integer mblog_forward_id;
    private String posttime;
    private String endtime;
    private String website_account;
}
