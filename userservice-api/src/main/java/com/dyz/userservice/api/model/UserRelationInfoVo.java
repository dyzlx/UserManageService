package com.dyz.userservice.api.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRelationInfoVo {

    @NotNull
    private Integer initiatorUserId;

    @NotNull
    private Integer recipientUserId;
}
