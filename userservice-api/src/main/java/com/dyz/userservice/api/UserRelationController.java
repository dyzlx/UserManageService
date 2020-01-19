package com.dyz.userservice.api;


import com.dyz.userservice.sal.service.UserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user_relation")
public class UserRelationController {

    @Autowired
    private UserRelationService userRelationService;


}
