package com.wenjiaquan.springcloud.order.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private Integer id;
    private String orderno;
    @TableField("userId")
    private Integer userId;
    private String username;
}
