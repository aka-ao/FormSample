package com.example.FormSample.repository;

import com.example.FormSample.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
