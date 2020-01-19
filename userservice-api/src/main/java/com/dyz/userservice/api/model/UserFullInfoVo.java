package com.dyz.userservice.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserFullInfoVo {

    private int userId;

    private String emailAddress;

    private String phoneNumber;

    private String nickName;

    private String registerTime;

    private String birthday;

    private String gender;

    private boolean enable;

    private boolean available;

    private int profilePhotoId;
}
