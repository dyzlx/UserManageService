package com.dyz.userservice.sal.translation;

import com.dyz.userservice.domain.entity.Role;
import com.dyz.userservice.sal.bo.RoleInfoBo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoleModelTranslator {

    public static RoleInfoBo toBo(Role entity) {
        if(Objects.isNull(entity)) {
            return null;
        }
        return RoleInfoBo.builder().name(entity.getName())
                .roleId(entity.getId()).build();
    }

    public static List<RoleInfoBo> toBoList(List<Role> entitys) {
        if(Objects.isNull(entitys)) {
            return null;
        }
        List<RoleInfoBo> results = new ArrayList<>();
        entitys.forEach(x -> {
            results.add(toBo(x));
        });
        return results;
    }
}
