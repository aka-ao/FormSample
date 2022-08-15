package com.example.FormSample.service;

import com.example.FormSample.entity.user.User;
import com.example.FormSample.entity.user.UserFactory;
import com.example.FormSample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }

    public void deleteAllById(List<Integer> deleteList) {
        userRepository.deleteAllById(deleteList);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer userId) {
        return userRepository.findById(userId);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
