package com.example.FormSample.mapper;

import com.example.FormSample.entity.User;
import com.example.FormSample.repository.typeHandler.UserStatusTypeHandler;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
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
            "select user_id, name, status from user"
    })
    @Results(id="user", value = {
            @Result(column = "user_id", property = "userId"),
            @Result(column = "name", property = "name"),
            @Result(column = "status", property = "status", typeHandler = UserStatusTypeHandler.class)
    })
    List<User> findAll();

    @Insert("insert into `user` (name, status) values (#{name}, #{status.statusCode})")
    void save(User user);
}
