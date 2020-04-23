package com.wenjiaquan.springcloud.user.service;

import com.wenjiaquan.springcloud.user.mapper.UserMapper;
import com.wenjiaquan.springcloud.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据id获取user
     * @param id
     * @return
     */
    public User getUserByid(Integer id){
        return userMapper.getUserByid(id);
    }

    /**
     * 根据id获取name
     * @param id
     * @return
     */
    public String getUsernameByid(Integer id){
        User user = getUserByid(id);
        user.setId(id);
        user.setName("username");
        return user.getName();
    }
}
