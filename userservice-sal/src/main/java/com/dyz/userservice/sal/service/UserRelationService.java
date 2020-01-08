package com.dyz.userservice.sal.service;


import com.dyz.userservice.sal.bo.UserRelationInfoBo;

public interface UserRelationService {

    /**
     *
     * @param relationInfoBo
     */
    void makeFriends(UserRelationInfoBo relationInfoBo);

    /**
     *
     * @param relationInfoBo
     */
    void deleteFriends(UserRelationInfoBo relationInfoBo);
}
