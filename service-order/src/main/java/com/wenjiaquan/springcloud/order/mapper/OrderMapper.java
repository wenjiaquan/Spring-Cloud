package com.wenjiaquan.springcloud.order.mapper;

import com.wenjiaquan.springcloud.order.model.Order;

public interface OrderMapper {
    Order getOrderByid(Integer id);
}
