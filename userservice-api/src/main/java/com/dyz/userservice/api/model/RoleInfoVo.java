package com.dyz.userservice.api.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleInfoVo {

    private Integer roleId;

    private String name;
}
