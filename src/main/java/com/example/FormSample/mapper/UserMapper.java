package com.example.FormSample.mapper;

import com.example.FormSample.dto.UserDto;
import com.example.FormSample.mapper.typeHandler.UserStatusTypeHandler;
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
            "select user_id, name, status from `user`"
    })
    List<UserDto> findAll();

    @Select(value = {
            "select user_id, name, status from `user` where user_id = #{userId}"
    })
    UserDto findById(Integer userId);

    @Insert("insert into `user` (name, status) values (#{name}, #{status})")
    void save(UserDto user);
}
