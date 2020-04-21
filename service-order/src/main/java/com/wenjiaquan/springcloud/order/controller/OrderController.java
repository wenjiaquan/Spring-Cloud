package com.wenjiaquan.springcloud.order.controller;

import com.wenjiaquan.springcloud.order.feign.UserFeignClient;
import com.wenjiaquan.springcloud.order.model.Order;
import com.wenjiaquan.springcloud.order.service.OrderService;
import com.wenjiaquan.springcloud.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.ApplicationScope;

@RestController
@RequestMapping("/order/")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping("getOrderByid")
    public Order getOrderByid(@RequestParam("id") Integer id){
        Order order = orderService.getOrderByid(id);
        //User user = restTemplate.getForObject("http://service-user/user/getUserByid?id=" + order.getId(), User.class);
        User u = new User();
        User user = userFeignClient.getUserByid(id);
        u.setId(1);
        order.setId(1);
        order.setUsername(user.getName());
        log.info("user:{}",user);
        return order;
    }


}
