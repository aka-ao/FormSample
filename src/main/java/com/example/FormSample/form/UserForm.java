package com.example.FormSample.form;

import com.example.FormSample.entity.user.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    private String userName;
    private UserStatus status;

    /**
     * ここがないと数値からEnumへの変換ができない
     * */
    public void setStatus(Integer statusCode) {
        this.status = UserStatus.valueOf(statusCode);
    }
}
