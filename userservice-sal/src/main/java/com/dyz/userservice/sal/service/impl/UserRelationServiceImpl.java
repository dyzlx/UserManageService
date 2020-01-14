package com.dyz.userservice.sal.service.impl;


import com.dyz.userservice.common.exception.IllegalParamException;
import com.dyz.userservice.common.exception.NoDataException;
import com.dyz.userservice.domain.entity.User;
import com.dyz.userservice.domain.entity.UserRelation;
import com.dyz.userservice.domain.repository.UserRelationRepository;
import com.dyz.userservice.domain.repository.UserRepository;
import com.dyz.userservice.sal.bo.UserInfoBo;
import com.dyz.userservice.sal.bo.UserRelationInfoBo;
import com.dyz.userservice.sal.service.UserRelationService;
import com.dyz.userservice.sal.translation.UserModelTranslator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserRelationServiceImpl implements UserRelationService {

    @Autowired
    private UserRelationRepository userRelationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRED)
    public void makeFriends(UserRelationInfoBo relationInfoBo) {
        log.info("begin to make friend, bo = {}", relationInfoBo);
        if(!ObjectUtils.allNotNull(relationInfoBo, relationInfoBo.getInitiatorUserId(), relationInfoBo.getRecipientUserId())) {
            log.error("param is null");
            throw new IllegalParamException(0, "param is null");
        }
        User initiatorUser = getUserByUserId(relationInfoBo.getInitiatorUserId());
        User recipientUser = getUserByUserId(relationInfoBo.getRecipientUserId());
        UserRelation relation = UserRelation.builder()
                .initiatorId(initiatorUser.getId())
                .recipientId(recipientUser.getId())
                .createTime(new Date()).build();
        userRelationRepository.save(relation);
        log.info("end of make friends");
    }

    @Override
    @Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRED)
    public void deleteFriends(UserRelationInfoBo relationInfoBo) {
        log.info("begin to delete friend, bo = {}", relationInfoBo);
        if(!ObjectUtils.allNotNull(relationInfoBo, relationInfoBo.getInitiatorUserId(), relationInfoBo.getRecipientUserId())) {
            log.error("param is null");
            throw new IllegalParamException(0, "param is null");
        }
        deleteRelationBidirectional(relationInfoBo.getInitiatorUserId(), relationInfoBo.getRecipientUserId());
        log.info("end of delete friends");
    }

    @Override
    public List<UserInfoBo> getFriends(Integer userId) {
        log.info("get friends, userId = {}", userId);
        User user = getUserByUserId(userId);
        List<UserRelation> userRelations = userRelationRepository.queryUserRelationsByUserId(user.getId());
        List<UserInfoBo> results = UserModelTranslator.toBoList(
                userRelations.stream().map(x -> {
                    User aUser = userRepository.getUserById(x.getInitiatorId());
                    User bUser = userRepository.getUserById(x.getRecipientId());
                    return Objects.equals(aUser, user) ? bUser : aUser;
                }).collect(Collectors.toList())
        );
        log.info("end of get friends, result = {}", results);
        return results;
    }

    /**
     * get user
     * @param userId
     * @return
     */
    private User getUserByUserId(Integer userId) {
        User user = userRepository.getEnableUserById(userId);
        if(Objects.isNull(user)) {
            log.error("no such enable user");
            throw new NoDataException(0, "no such user, userId=" + userId);
        }
        return user;
    }

    /**
     * delete relation bidirectional
     * @param aUserId
     * @param bUserId
     */
    private void deleteRelationBidirectional(Integer aUserId, Integer bUserId) {
        UserRelation aUserRelation = userRelationRepository
                .queryByInitiatorIdAndRecipientId(aUserId, bUserId);
        UserRelation bUserRelation = userRelationRepository
                .queryByInitiatorIdAndRecipientId(bUserId, aUserId);
        if(Objects.isNull(aUserRelation)) {
            log.error("no such user relation {}->{}", aUserId, bUserId);
            throw new NoDataException(0, "no such user relation");
        }
        if(Objects.isNull(bUserRelation)) {
            log.error("no such user relation {}->{}", bUserId, aUserId);
            throw new NoDataException(0, "no such user relation");
        }
        userRelationRepository.deleteAll(new ArrayList<>(Arrays.asList(aUserRelation, bUserRelation)));
    }
}
