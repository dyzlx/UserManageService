package com.dyz.userservice.api.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleQueryVo {

    private Integer roleId;

    private String name;
}
