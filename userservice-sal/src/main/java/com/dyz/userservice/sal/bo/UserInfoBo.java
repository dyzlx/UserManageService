package com.dyz.userservice.sal.bo;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@Builder
@EqualsAndHashCode
public class UserInfoBo {

    private Integer userId;

    private String nickName;

    private Integer profilePhotoId;

    private String gender;

    private String emailAddress;

    private String phoneNumber;

    private Date registerTime;

    private Date birthday;

    private boolean enable;

    private boolean available;

}
