package com.dyz.userservice.sal.bo;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class UserGeneralInfoBo {

    private Integer userId;

    private String nickName;

    private Integer profilePhotoId;

    private String gender;

}
