package com.dyz.userservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserChangeRoleVo {

    @NotNull
    private Integer userId;

    @NotEmpty
    private List<Integer> roleIds;
}
