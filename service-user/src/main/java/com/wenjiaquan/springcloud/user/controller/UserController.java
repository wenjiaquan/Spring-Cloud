package com.wenjiaquan.springcloud.user.controller;

import com.wenjiaquan.springcloud.user.model.User;
import com.wenjiaquan.springcloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("getUserByid")
    public User getUserByid(Integer id){
        return userService.getUserByid(id);
    }

    @RequestMapping("getUsernameByid")
    public String getUsernameByid(Integer id){
        return userService.getUsernameByid(id);
    }
}
