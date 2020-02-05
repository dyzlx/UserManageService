package com.dyz.userservice.api.translation;

import com.dyz.userservice.api.model.UserRelationInfoVo;
import com.dyz.userservice.sal.bo.UserRelationInfoBo;

import java.util.Objects;

public class UserRelationModelTranslator {

    public static UserRelationInfoBo toBo(UserRelationInfoVo infoVo) {
        if (Objects.isNull(infoVo)) {
            return null;
        }
        return UserRelationInfoBo.builder()
                .initiatorUserId(infoVo.getInitiatorUserId())
                .recipientUserId(infoVo.getRecipientUserId())
                .build();
    }
}
