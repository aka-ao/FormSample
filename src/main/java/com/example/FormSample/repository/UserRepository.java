package com.example.FormSample.repository;

import com.example.FormSample.dto.UserDto;
import com.example.FormSample.entity.user.User;
import com.example.FormSample.entity.user.UserFactory;
import com.example.FormSample.entity.user.UserStatus;
import com.example.FormSample.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
        List<User> userList = new ArrayList<>();
        userMapper.findAll().forEach(userDto -> {
            User user = UserFactory.exec(userDto.getUserId(), userDto.getName(), UserStatus.valueOf(userDto.getStatus()));
            userList.add(user);
        });
        return userList;
    }

    public User findById(Integer userId) {
        System.out.println(userId);
        UserDto userDto = userMapper.findById(userId);
        User user = UserFactory.exec(userDto.getUserId(), userDto.getName(), UserStatus.valueOf(userDto.getStatus()));
        return user;
    }

    public void save(User user) {
        userMapper.save(UserDto.transformUserDto(user));
    }
}
