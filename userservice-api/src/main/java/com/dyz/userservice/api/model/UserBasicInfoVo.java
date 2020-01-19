package com.dyz.userservice.api.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserBasicInfoVo {

    private Integer userId;

    private String nickName;

    private Integer profilePhotoId;

    private boolean available;
}
