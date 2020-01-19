package com.dyz.userservice.api.translation;

import com.dyz.userservice.api.model.UserBasicInfoVo;
import com.dyz.userservice.api.model.UserChangePwVo;
import com.dyz.userservice.api.model.UserCreateVo;
import com.dyz.userservice.api.model.UserFullInfoVo;
import com.dyz.userservice.common.constant.ServiceConstant;
import com.dyz.userservice.common.exception.IllegalParamException;
import com.dyz.userservice.common.util.DateHandler;
import com.dyz.userservice.sal.bo.UserChangePwBo;
import com.dyz.userservice.sal.bo.UserCreateBo;
import com.dyz.userservice.sal.bo.UserInfoBo;
import com.dyz.userservice.sal.bo.UserQueryBo;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserModelTranslator {

    public static UserQueryBo toBo(Integer userId, String emailAddress, String phoneNumber,
                                   String nickName, String enable, String available, String fromTime, String toTime) {
        UserQueryBo queryBo = null;
        try {
            queryBo = UserQueryBo.builder()
                    .available(Objects.isNull(available) ? null : Boolean.valueOf(available))
                    .emailAddress(emailAddress)
                    .enable(Objects.isNull(enable) ? null : Boolean.valueOf(enable))
                    .nickName(nickName)
                    .phoneNumber(phoneNumber)
                    .userId(userId)
                    .fromRegisterTime(Objects.isNull(fromTime) ? null
                            : DateUtils.parseDate(fromTime, ServiceConstant.DATE_FORMAT_SHORT))
                    .toRegisterTime(Objects.isNull(toTime) ? null
                            : DateUtils.parseDate(toTime, ServiceConstant.DATE_FORMAT_SHORT))
                    .build();
        } catch (ParseException e) {
            throw new IllegalParamException(0, "illegal param");
        }
        return queryBo;
    }

    public static UserQueryBo toBo(Integer userId, String emailAddress, String phoneNumber, String nickName) {
        return UserQueryBo.builder()
                .userId(userId)
                .emailAddress(emailAddress)
                .phoneNumber(phoneNumber)
                .nickName(nickName)
                .build();
    }

    public static UserBasicInfoVo toUserBasicInfoVo(UserInfoBo infoBo) {
        if(Objects.isNull(infoBo)) {
            return null;
        }
        return UserBasicInfoVo.builder()
                .available(infoBo.isAvailable())
                .nickName(infoBo.getNickName())
                .profilePhotoId(infoBo.getProfilePhotoId())
                .userId(infoBo.getUserId())
                .build();
    }

    public static UserFullInfoVo toUserFillInfoVo(UserInfoBo infoBo) {
        if(Objects.isNull(infoBo)) {
            return null;
        }
        return UserFullInfoVo.builder()
                .available(infoBo.isAvailable())
                .nickName(infoBo.getNickName())
                .profilePhotoId(infoBo.getProfilePhotoId())
                .userId(infoBo.getUserId())
                .birthday(DateHandler.getDateString(infoBo.getBirthday()))
                .enable(infoBo.isEnable())
                .gender(infoBo.getGender())
                .emailAddress(infoBo.getEmailAddress())
                .phoneNumber(infoBo.getPhoneNumber())
                .registerTime(DateHandler.getDateString(infoBo.getRegisterTime()))
                .build();
    }

    public static List<UserBasicInfoVo> toUserBasicInfoVoList(List<UserInfoBo> infoBos) {
        if(Objects.isNull(infoBos)) {
            return null;
        }
        List<UserBasicInfoVo> results = new ArrayList<>();
        infoBos.forEach(x -> results.add(toUserBasicInfoVo(x)));
        return results;
    }

    public static List<UserFullInfoVo> toUserFullInfoVoList(List<UserInfoBo> infoBos) {
        if(Objects.isNull(infoBos)) {
            return null;
        }
        List<UserFullInfoVo> results = new ArrayList<>();
        infoBos.forEach(x -> results.add(toUserFillInfoVo(x)));
        return results;
    }

    public static UserCreateBo toBo(UserCreateVo createVo) {
        if(Objects.isNull(createVo)) {
            return null;
        }
        try {
            return UserCreateBo.builder()
                    .birthday(DateUtils.parseDate(createVo.getBirthday(), ServiceConstant.DATE_FORMAT_SHORT))
                    .emailAddress(createVo.getEmailAddress())
                    .gender(createVo.getGender())
                    .nickName(createVo.getNickName())
                    .password(createVo.getPassword())
                    .phoneNumber(createVo.getPhoneNumber())
                    .profilePhoto(createVo.getProfilePhoto())
                    .build();
        } catch (ParseException e) {
            throw new IllegalParamException(0, "illegal param");
        }
    }

    public static UserChangePwBo toBo(UserChangePwVo changePwVo) {
        if(Objects.isNull(changePwVo)) {
            return null;
        }
        return UserChangePwBo.builder()
                .userId(changePwVo.getUserId())
                .newPassword(changePwVo.getNewPassword())
                .originPassword(changePwVo.getOriginPassword())
                .build();
    }
}
