package com.wenjiaquan.springcloud.order.controller;

import com.wenjiaquan.springcloud.order.model.Order;
import com.wenjiaquan.springcloud.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("getUserByid")
    public Order getOrderByid(Integer id){

        return orderService.getOrderByid(id);
    }


}
