package com.example.FormSample.repository;

import com.example.FormSample.entity.User;
import com.example.FormSample.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository  {

    @Autowired
    UserMapper userMapper;

    public void deleteById(Integer userId) {
        userMapper.deleteById(userId);
    }

    public void deleteAllById(List<Integer> deleteList) {
        userMapper.deleteAllById(deleteList);
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public void save(User user) {
        userMapper.save(user);
    }
}
