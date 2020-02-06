package com.dyz.userservice.api;


import com.dyz.userservice.api.model.Result;
import com.dyz.userservice.api.model.RoleCreateVo;
import com.dyz.userservice.api.model.RoleInfoVo;
import com.dyz.userservice.api.translation.RoleModelTranslator;
import com.dyz.userservice.sal.bo.RoleInfoBo;
import com.dyz.userservice.sal.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    public ResponseEntity<Result> queryRoleInfos(@RequestParam Integer roleId, @RequestParam String name) {
        List<RoleInfoVo> results = RoleModelTranslator.toVoLsit(
                roleService.queryRoleInfos(RoleModelTranslator.toBo(roleId, name)));
        return ResponseEntity.status(HttpStatus.OK).body(Result.builder().content(results).build());
    }

    @RequestMapping(value = "", method = RequestMethod.POST,
            produces = {"application/json","application/xml"},
            consumes = {"application/json","application/xml"})
    public ResponseEntity<Result> createRole(@Validated @RequestBody RoleCreateVo createVo) {
        Integer roleId = roleService.createRole(RoleModelTranslator.toBo(createVo));
        return ResponseEntity.status(HttpStatus.OK).body(Result.builder().content(roleId).build());
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    public ResponseEntity<Result> deleteRole(@PathVariable Integer roleId) {
        roleService.deleteRole(roleId);
        return ResponseEntity.status(HttpStatus.OK).body(Result.builder().build());
    }
}
