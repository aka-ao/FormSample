package com.example.FormSample.entity.user;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public enum UserStatus {
    一般会員(1),
    プライム会員(2);

    private Integer statusCode;



    UserStatus(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public static UserStatus valueOf(Integer statusCode) {
        UserStatus[] statuses = values();
        UserStatus status = null;
        for (UserStatus userStatus: statuses
             ) {
            if(userStatus.getStatusCode().equals(statusCode)) {
                status = userStatus;
                break;
            }
        }
        return status;
    }

    /**
     * UserStatusに定義されているステータスをMap形式で受け取る.
     * */
    public static Map<Integer, String> getAllStatus() {
        List<UserStatus> statuses = Arrays.asList(UserStatus.class.getEnumConstants());
        return statuses.stream().collect(
                Collectors.toMap(
                        status -> status.statusCode,
                        status -> status.name()
                )
        );
    }
}
