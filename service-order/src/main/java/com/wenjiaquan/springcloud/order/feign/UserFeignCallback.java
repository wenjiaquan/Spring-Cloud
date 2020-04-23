package com.wenjiaquan.springcloud.order.feign;

import com.wenjiaquan.springcloud.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserFeignCallback implements UserFeignClient{
    @Override
    public User getUserByid(Integer id) {
        User user = new User();
        user.setName("固定值");
        return user;
    }

    @Override
    public String getUsernameByid(Integer id) {
        return null;
    }
}
