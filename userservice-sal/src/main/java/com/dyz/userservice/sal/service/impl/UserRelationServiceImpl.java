package com.dyz.userservice.sal.service.impl;


import com.dyz.userservice.domain.repository.UserRelationRepository;
import com.dyz.userservice.sal.bo.UserRelationInfoBo;
import com.dyz.userservice.sal.service.UserRelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserRelationServiceImpl implements UserRelationService {

    @Autowired
    private UserRelationRepository userRelationRepository;

    @Override
    public void makeFriends(UserRelationInfoBo relationInfoBo) {

    }

    @Override
    public void deleteFriends(UserRelationInfoBo relationInfoBo) {

    }
}
