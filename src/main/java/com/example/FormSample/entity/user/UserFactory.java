package com.example.FormSample.entity.user;

public class UserFactory {
    public static User exec(Integer userId, String userName, UserStatus status) {
        User user = null;
        switch (status) {
            case 一般会員:
                user = new NormalUser(userId, userName, status);
                break;
            case プライム会員:
                user = new PrimeUser(userId, userName, status);
                break;
        }

        return user;
    }
}
