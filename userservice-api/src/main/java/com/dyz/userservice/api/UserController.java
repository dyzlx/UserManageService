package com.dyz.userservice.api;


import com.dyz.userservice.api.model.*;
import com.dyz.userservice.api.translation.UserModelTranslator;
import com.dyz.userservice.sal.bo.UserQueryBo;
import com.dyz.userservice.sal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "basic", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    public ResponseEntity<Result> queryBasicUserInfo(
            @RequestParam(required = false) Integer userId,
            @RequestParam(required = false) String emailAddress,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String nickName) {
        UserQueryBo queryBo = UserModelTranslator.toBo(userId, emailAddress, phoneNumber, nickName);
        List<UserBasicInfoVo> results = UserModelTranslator.toUserBasicInfoVoList(userService.queryUsersInfo(queryBo));
        return ResponseEntity.status(HttpStatus.OK).body(Result.builder().content(results).build());
    }

    @RequestMapping(value = "full", method = RequestMethod.GET, produces = {"application/json", "application/xml"})
    public ResponseEntity<Result> queryFullUserInfo(
            @RequestParam(required = false) Integer userId,
            @RequestParam(required = false) String emailAddress,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String nickName,
            @RequestParam(required = false) String enable,
            @RequestParam(required = false) String available,
            @RequestParam(required = false) String fromTime,
            @RequestParam(required = false) String toTime) {
        UserQueryBo queryBo = UserModelTranslator.toBo(
                userId, emailAddress, phoneNumber, nickName, enable, available, fromTime, toTime);
        List<UserFullInfoVo> results = UserModelTranslator.toUserFullInfoVoList(userService.queryUsersInfo(queryBo));
        return ResponseEntity.status(HttpStatus.OK).body(Result.builder().content(results).build());
    }

    @RequestMapping(value = "", method = RequestMethod.POST,
            produces = {"application/json","application/xml"},
            consumes = {"application/json","application/xml"})
    public ResponseEntity<Result> createUser(@Validated @RequestBody UserCreateVo createVo) {
        Integer userId = userService.createUser(UserModelTranslator.toBo(createVo));
        return ResponseEntity.status(HttpStatus.OK).body(Result.builder().content(userId).build());
    }

    @RequestMapping(value = "changePassword", method = RequestMethod.PUT,
            produces = {"application/json","application/xml"},
            consumes = {"application/json","application/xml"})
    public ResponseEntity<Result> changePassword(@Validated @RequestBody UserChangePwVo changePwVo) {
        userService.changeUserPassword(UserModelTranslator.toBo(changePwVo));
        return ResponseEntity.status(HttpStatus.OK).body(Result.builder().build());
    }


}
