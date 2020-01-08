package com.dyz.userservice.sal.translation;


import com.dyz.userservice.domain.entity.User;
import com.dyz.userservice.sal.bo.UserInfoBo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserModelTranslator {

    public static UserInfoBo toBo(User entity){
        if(Objects.isNull(entity)){
            return null;
        }
        return UserInfoBo.builder()
                .available(entity.isAvailable())
                .birthday(entity.getBirthday())
                .emailAddress(entity.getEmailAddress())
                .enable(entity.isEnable())
                .gender(entity.getGender())
                .nickName(entity.getNickName())
                .phoneNumber(entity.getPhoneNumber())
                .profilePhotoId(entity.getProfilePhotoId())
                .registerTime(entity.getRegisterTime())
                .userId(entity.getId())
                .build();
    }

    public static List<UserInfoBo> toBoList(List<User> entitys){
        if(Objects.isNull(entitys)){
            return null;
        }
        List<UserInfoBo> results = new ArrayList<>();
        entitys.forEach(x -> {
            results.add(toBo(x));
        });
        return results;
    }
}
