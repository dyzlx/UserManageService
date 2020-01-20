package com.dyz.userservice.api.model;

import com.dyz.userservice.sal.bo.RoleInfoBo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

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

    private List<RoleInfoVo> roles;
}
