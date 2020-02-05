package com.dyz.userservice.api;


import com.dyz.userservice.api.model.Result;
import com.dyz.userservice.api.model.UserBasicInfoVo;
import com.dyz.userservice.api.model.UserRelationInfoVo;
import com.dyz.userservice.api.translation.UserModelTranslator;
import com.dyz.userservice.api.translation.UserRelationModelTranslator;
import com.dyz.userservice.sal.service.UserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "user_relation")
public class UserRelationController {

    @Autowired
    private UserRelationService userRelationService;

    @RequestMapping(value = "{userId}", method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    public ResponseEntity<Result> getFriends(@PathVariable Integer userId) {
        List<UserBasicInfoVo> result = UserModelTranslator.toUserBasicInfoVoList((userRelationService.getFriends(userId)));
        return ResponseEntity.status(HttpStatus.OK).body(Result.builder().content(result).build());
    }

    @RequestMapping(value = "", method = RequestMethod.POST,
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    public ResponseEntity<Result> makeFriends(@Validated @RequestBody UserRelationInfoVo infoVo) {
        userRelationService.makeFriends(UserRelationModelTranslator.toBo(infoVo));
        return ResponseEntity.status(HttpStatus.OK).body(Result.builder().build());
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    public ResponseEntity<Result> deleteFriends(@Validated @RequestBody UserRelationInfoVo infoVo) {
        userRelationService.deleteFriends(UserRelationModelTranslator.toBo(infoVo));
        return ResponseEntity.status(HttpStatus.OK).body(Result.builder().build());
    }

}
