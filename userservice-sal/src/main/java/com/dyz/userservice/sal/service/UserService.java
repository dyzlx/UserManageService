package com.dyz.userservice.sal.service;


import com.dyz.userservice.sal.bo.UserChangePwBo;
import com.dyz.userservice.sal.bo.UserCreateBo;
import com.dyz.userservice.sal.bo.UserInfoBo;
import com.dyz.userservice.sal.bo.UserQueryBo;

import java.util.List;

public interface UserService {

    List<UserInfoBo> queryUsersInfo(UserQueryBo queryBo);

    Integer createUser(UserCreateBo createBo);

    void unableUser(Integer userId);

    void changeUserAvailableStatus(Integer userId, boolean available);

    void changeUserPassword(UserChangePwBo changePwBo, Integer userId);

}
