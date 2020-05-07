package com.wjq.demo.test;

import com.wjq.demo.dao.UserDao;
import com.wjq.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void save(){
        User u=new User();
        u.setId(1);
         u.setUsername("阿萨德");
         u.setPassword("456882");
        u.setPhone("8555615452");
        u.setCreated(new Date());
        User save = userDao.save(u);
        System.err.println(save);
    }

    @Test
    public void findAll(){
        List<User> all = userDao.findAll();
        for(User user:all) {
            System.out.println(user);
        }
    }

    @Test
    public void findByusername(){
        List<User> all = userDao.findByusername("sdfs");
        System.err.println(all);
    }

    @Test
    public void del(){
        userDao.del(1);
        System.err.println("删除成功");
    }

}
