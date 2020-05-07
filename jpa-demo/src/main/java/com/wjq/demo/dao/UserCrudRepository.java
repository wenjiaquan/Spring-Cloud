package com.wjq.demo.dao;

import com.wjq.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface UserCrudRepository extends CrudRepository<User,Integer> {
}
