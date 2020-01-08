package com.dyz.userservice.sal.service.impl;

import com.dyz.userservice.common.exception.IllegalParamException;
import com.dyz.userservice.domain.repository.UserRepository;
import com.dyz.userservice.sal.bo.UserChangePwBo;
import com.dyz.userservice.sal.bo.UserCreateBo;
import com.dyz.userservice.sal.bo.UserInfoBo;
import com.dyz.userservice.sal.bo.UserQueryBo;
import com.dyz.userservice.sal.service.UserService;
import com.dyz.userservice.sal.translation.UserModelTranslator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserInfoBo> queryUsersInfo(@NotNull UserQueryBo queryBo) {
        log.info("begin to query user info");
        if (Objects.isNull(queryBo)) {
            log.error("param is null");
            throw new IllegalParamException(0, "query param is null");
        }
        List<UserInfoBo> results = UserModelTranslator.toBoList(
                userRepository.queryEnableUsers(
                        queryBo.getUserId(), queryBo.getEmailAddress(),
                        queryBo.getPhoneNumber(), queryBo.getNickName(),
                        queryBo.getFromRegisterTime(), queryBo.getToRegisterTime()
                )
        );
        log.info("end of query user info, result = {}", results);
        return results;
    }

    @Override
    public Integer createUser(@NotNull UserCreateBo createBo) {
        log.info("begin to create user, createBo = {}", createBo);
        if(Objects.isNull(createBo)){
            log.error("param is null");
            throw new IllegalParamException(0, "create param is null");
        }



        log.info("end of create user");
        return null;
    }

    @Override
    public void unableUser(Integer userId) {

    }

    @Override
    public void changeUserAvailableStatus(Integer userId, boolean available) {

    }

    @Override
    public void changeUserPassword(@NotNull UserChangePwBo changePwBo) {

    }

    @Override
    public void changeUserRole(Integer userId, Integer roleId) {

    }
}
