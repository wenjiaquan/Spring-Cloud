package com.wjq.demo.controller;

import com.wjq.demo.dao.UserDao;
import com.wjq.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("demo")
public class DemoController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("list")
    public List<User> list(){
        List<User> all = userDao.findAll();
        return all;
    }
}
