package com.dyz.userservice.sal.service;


import com.dyz.userservice.sal.bo.UserChangePwBo;
import com.dyz.userservice.sal.bo.UserCreateBo;
import com.dyz.userservice.sal.bo.UserDetailInfoBo;
import com.dyz.userservice.sal.bo.UserGeneralInfoBo;
import com.dyz.userservice.sal.bo.UserQueryBo;

import java.util.List;

public interface UserService {

    /**
     *
     * @param queryBo
     * @return
     */
    List<UserGeneralInfoBo> queryUsersGeneralInfo(UserQueryBo queryBo);

    /**
     *
     * @param queryBo
     * @return
     */
    List<UserDetailInfoBo> queryUsersDetailInfo(UserQueryBo queryBo);

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
