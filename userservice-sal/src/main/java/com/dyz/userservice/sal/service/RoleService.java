package com.dyz.userservice.sal.service;

import com.dyz.userservice.sal.bo.RoleCreateBo;
import com.dyz.userservice.sal.bo.RoleInfoBo;
import com.dyz.userservice.sal.bo.RoleQueryBo;

import java.util.List;

public interface RoleService {

    List<RoleInfoBo> queryRoleInfos(RoleQueryBo queryInfoBo);

    Integer createRole(RoleCreateBo createBo);

    void deleteRole(Integer roleId);
}
