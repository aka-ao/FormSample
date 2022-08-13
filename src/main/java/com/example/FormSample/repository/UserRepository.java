package com.example.FormSample.repository;

import com.example.FormSample.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserRepository  {

    @Delete("delete from user where user_id = #{userId}")
    void deleteById(Integer userId);

    @Delete({
            "<script>",
            "delete FROM user",
            "where user_id in",
            "<foreach item=\"item\" index=\"index\" collection=\"list\" open=\"(\" separator=\",\" close=\")\">",
            "#{item}",
            "</foreach>",
            "</script>"
    })
    void deleteAllById(List<Integer> deleteList);

    @Select(value = {
            "select user_id as userId, name, status from user"
    })
    List<User> findAll();

    @Insert("insert into `user` (name, status) values (#{name}, #{status})")
    void save(User user);
}
