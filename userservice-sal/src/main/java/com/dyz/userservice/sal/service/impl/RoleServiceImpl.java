package com.dyz.userservice.sal.service.impl;

import com.dyz.userservice.domain.repository.RoleRepository;
import com.dyz.userservice.sal.bo.RoleCreateBo;
import com.dyz.userservice.sal.bo.RoleInfoBo;
import com.dyz.userservice.sal.bo.RoleQueryBo;
import com.dyz.userservice.sal.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleInfoBo> queryRoleInfos(RoleQueryBo queryInfoBo) {
        return null;
    }

    @Override
    public void createRole(RoleCreateBo createBo) {

    }

    @Override
    public void deleteRole(Integer roleId) {

    }
}
