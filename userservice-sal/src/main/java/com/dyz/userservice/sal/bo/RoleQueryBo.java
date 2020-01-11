package com.dyz.userservice.sal.bo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleQueryBo {

    private Integer roleId;

    private String name;
}
