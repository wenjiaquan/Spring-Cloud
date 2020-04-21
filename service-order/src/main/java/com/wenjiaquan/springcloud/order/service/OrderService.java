package com.wenjiaquan.springcloud.order.service;

import com.wenjiaquan.springcloud.order.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    /**
     * 根据id获取user
     * @param id
     * @return
     */
    public Order getOrderByid(Integer id){
        Order order = new Order();
        order.setId(id);
        order.setOrderno(System.currentTimeMillis()+"");
        order.setUserId(1);
        return order;
    }
}
