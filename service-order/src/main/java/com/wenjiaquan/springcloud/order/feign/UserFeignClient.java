package com.wenjiaquan.springcloud.order.feign;

import com.wenjiaquan.springcloud.user.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "service-user",fallback = UserFeignCallback.class)
public interface UserFeignClient {
    /**
     * 根据id获取user
     * @param id
     * @return
     */
    @RequestMapping("/user/getUserByid")
    public User getUserByid(@RequestParam("id") Integer id);

    /**
     * 根据id获取name
     * @param id
     * @return
     */
    @RequestMapping("/user/getUsernameByid")
    public String getUsernameByid(@RequestParam("id") Integer id);
}
