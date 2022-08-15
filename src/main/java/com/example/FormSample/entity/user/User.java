package com.example.FormSample.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class User {
    private Integer userId;
    private String name;
    private UserStatus status;

    public abstract String buyProduct(String name, Integer price);
}
