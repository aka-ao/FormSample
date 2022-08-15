package com.example.FormSample.dto;

import com.example.FormSample.entity.user.User;
import com.example.FormSample.entity.user.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private Integer userId;
    private String name;
    private Integer status;

    public static UserDto transformUserDto(User user) {
        return new UserDto(user.getUserId(), user.getName(), user.getStatus().getStatusCode());
    }
}
