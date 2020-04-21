package com.wenjiaquan.springcloud.order.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private Integer id;
    private String orderno;
    private Integer userId;
    private String username;
}
