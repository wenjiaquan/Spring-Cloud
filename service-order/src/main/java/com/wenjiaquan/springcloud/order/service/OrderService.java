package com.wenjiaquan.springcloud.order.service;

import com.wenjiaquan.springcloud.order.mapper.OrderMapper;
import com.wenjiaquan.springcloud.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 根据id获取user
     * @param id
     * @return
     */
    public Order getOrderByid(Integer id){
        Order order=orderMapper.getOrderByid(id);
        order.setOrderno(System.currentTimeMillis()+"");
        return order;
    }
}
