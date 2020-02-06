package com.dyz.userservice.api.translation;

import com.dyz.userservice.api.model.RoleCreateVo;
import com.dyz.userservice.api.model.RoleInfoVo;
import com.dyz.userservice.sal.bo.RoleCreateBo;
import com.dyz.userservice.sal.bo.RoleInfoBo;
import com.dyz.userservice.sal.bo.RoleQueryBo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoleModelTranslator {

    public static RoleInfoVo toVo(RoleInfoBo infoBo) {
        if(Objects.isNull(infoBo)) {
            return null;
        }
        return RoleInfoVo.builder()
                .name(infoBo.getName())
                .roleId(infoBo.getRoleId())
                .build();
    }

    public static List<RoleInfoVo> toVoLsit(List<RoleInfoBo> infoBos) {
        if(Objects.isNull(infoBos)) {
            return null;
        }
        List<RoleInfoVo> results = new ArrayList<>();
        infoBos.forEach(x -> results.add(toVo(x)));
        return results;
    }

    public static RoleQueryBo toBo(Integer rodeId, String name) {
        return RoleQueryBo.builder().roleId(rodeId).name(name).build();
    }

    public static RoleCreateBo toBo(RoleCreateVo createVo) {
        if(Objects.isNull(createVo)) {
            return null;
        }
        return RoleCreateBo.builder().name(createVo.getName()).build();
    }
}
