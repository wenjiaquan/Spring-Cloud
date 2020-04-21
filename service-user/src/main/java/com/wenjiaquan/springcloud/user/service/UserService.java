package com.wenjiaquan.springcloud.user.service;

import com.wenjiaquan.springcloud.user.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    /**
     * 根据id获取user
     * @param id
     * @return
     */
    public User getUserByid(Integer id){
        User user = new User();
        user.setId(id);
        user.setName("username");
        return user;
    }

    /**
     * 根据id获取name
     * @param id
     * @return
     */
    public String getUsernameByid(Integer id){
        User user = getUserByid(id);
        return user.getName();
    }
}
