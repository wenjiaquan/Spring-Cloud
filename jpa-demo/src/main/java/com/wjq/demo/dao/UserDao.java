package com.wjq.demo.dao;

import com.wjq.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private EntityManager entityManager;

    /**
     * 修改和新增
     * @param u
     * @return
     */
    @Transactional
    public User save(User u){
        User user = entityManager.merge(u);
        return user;
    }

    /**
     * 删除  先查询 再删除
     * @param id
     */
    @Transactional
    public void del(Integer id){
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    /**
     * 查询全部
     * @return
     */
    public List<User> findAll(){
        Query from_user = entityManager.createQuery("from User");
        List list = from_user.getResultList();
        return list;
    }

    /**
     * 模糊查询
     * @param username
     * @return
     */
    public List<User> findByusername(String username){
        String likename="%".concat(username).concat("%");
        Query query = entityManager.createQuery("from User u where u.username like :username");

        query.setParameter("username",likename);
        List resultList = query.getResultList();
        return resultList;
    }
}
