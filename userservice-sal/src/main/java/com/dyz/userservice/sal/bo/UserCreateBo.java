package com.dyz.userservice.sal.bo;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@Builder
@ToString(exclude = {"password"})
public class UserCreateBo {

    private String emailAddress;

    private String phoneNumber;

    private String nickName;

    private Date birthday;

    private String password;

    private String gender;
}
