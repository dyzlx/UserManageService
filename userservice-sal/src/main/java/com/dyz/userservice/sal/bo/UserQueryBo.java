package com.dyz.userservice.sal.bo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserQueryBo {

    private Integer userId;

    private String emailAddress;

    private String phoneNumber;

    private String nickName;

    private Date fromRegisterTime;

    private Date toRegisterTime;
}
