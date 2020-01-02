package com.dyz.userservice.sal.service;


import com.dyz.userservice.sal.bo.UserChangePwBo;
import com.dyz.userservice.sal.bo.UserCreateBo;
import com.dyz.userservice.sal.bo.UserInfoBo;
import com.dyz.userservice.sal.bo.UserQueryBo;

import java.util.List;

public interface UserService {

    /**
     *
     * @param queryBo
     * @return
     */
    List<UserInfoBo> queryUsersInfo(UserQueryBo queryBo);

    /**
     *
     * @param createBo
     * @return
     */
    Integer createUser(UserCreateBo createBo);

    /**
     *
     * @param userId
     */
    void unableUser(Integer userId);

    /**
     *
     * @param userId
     * @param available
     */
    void changeUserAvailableStatus(Integer userId, boolean available);

    /**
     *
     * @param changePwBo
     */
    void changeUserPassword(UserChangePwBo changePwBo);

    /**
     *
     * @param userId
     * @param roleId
     */
    void changeUserRole(Integer userId, Integer roleId);

}
