package com.wjq.demo.test;

import com.wjq.demo.dao.UserCrudRepository;
import com.wjq.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CrudRepositoryTest {
    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     * 添加修改
     */
    @Test
    public void save(){
        User user = new User();
        user.setUsername("woshinibaba");
        user.setPassword("13265");
        user.setPhone("46844565");
        user.setCreated(new Date());
        User user1 = new User();
        user1.setUsername("我是你爷爷");
        user1.setPassword("13265");
        user1.setPhone("46844565");
        user1.setCreated(new Date());
        List<User> userlist = new ArrayList<>();
        userlist.add(user);
        userlist.add(user1);
        //userCrudRepository.save(user);
        userCrudRepository.saveAll(userlist);
    }

    @Test
    public void del(){

    }
}
