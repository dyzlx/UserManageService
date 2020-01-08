package com.dyz.userservice.sal.bo;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@Builder
public class UserCreateBo {

    private String emailAddress;

    private String phoneNumber;

    private String nickName;

    private Date birthday;

    private String password;

    private String gender;

    private MultipartFile profilePhoto;
}
