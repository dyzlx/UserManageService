package com.dyz.userservice.sal.service.impl;

import com.dyz.userservice.common.exception.IllegalParamException;
import com.dyz.userservice.common.exception.NoDataException;
import com.dyz.userservice.domain.entity.Role;
import com.dyz.userservice.domain.repository.RoleRepository;
import com.dyz.userservice.sal.bo.RoleCreateBo;
import com.dyz.userservice.sal.bo.RoleInfoBo;
import com.dyz.userservice.sal.bo.RoleQueryBo;
import com.dyz.userservice.sal.service.RoleService;
import com.dyz.userservice.sal.translation.RoleModelTranslator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleInfoBo> queryRoleInfos(RoleQueryBo queryInfoBo) {
        log.info("begin to query role infos, queryBo = {}", queryInfoBo);
        if(Objects.isNull(queryInfoBo)) {
            log.error("query param is null");
            throw new IllegalParamException(0, "query param is null");
        }
        List<RoleInfoBo> results = RoleModelTranslator.toBoList(
                roleRepository.queryRoleInfo(queryInfoBo.getRoleId(), queryInfoBo.getName()));
        log.info("end of query role info, results = {}", results);
        return results;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRED)
    public Integer createRole(RoleCreateBo createBo) {
        log.info("begin to create role, createBo = {}", createBo);
        if(!ObjectUtils.allNotNull(createBo, createBo.getName())) {
            log.error("create param is null");
            throw new IllegalParamException(0, "create param is null");
        }
        Role role = Role.builder().name(createBo.getName()).build();
        roleRepository.save(role);
        log.info("end of create role");
        return role.getId();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRED)
    public void deleteRole(Integer roleId) {
        log.info("begin to delete role, roleId = {}", roleId);
        if(Objects.isNull(roleId)) {
            log.error("delete param is null");
            throw new IllegalParamException(0, "delete param is null");
        }
        Role role = roleRepository.queryById(roleId);
        if(Objects.isNull(role)) {
            log.error("no such role");
            throw new NoDataException(0, "no such role");
        }
        roleRepository.delete(role);
        log.info("end of delete role");
    }
}
